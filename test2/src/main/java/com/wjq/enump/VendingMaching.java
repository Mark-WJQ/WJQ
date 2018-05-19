package com.wjq.enump;

import com.wjq.generic.Generators;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianqiang on 2018/5/3.
 */
public class VendingMaching {

    enum Input{
        NICKEL(5),DIME(10),QUARTER(25),
        DOLLAR(100),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),ABORT_TRANSACTION{
            @Override
            int amount() {
               throw new RuntimeException("ABORT.amount()");
            }
        },
        STOP{
            @Override
            int amount() {
                throw new RuntimeException("shut_down.amount()");
            }
        };


        int value;

        Input(int value) {
            this.value = value;
        }

        Input() {
        }

        int amount(){return value;};

        static Random rand = new Random(47);

        public static Input randomSelection(){
            return values()[rand.nextInt(values().length -1)];
        }
    }


    enum Category{
        MONEY(Input.NICKEL,Input.DIME,Input.QUARTER,Input.DOLLAR),
        ITEM_SELECTION(Input.TOOTHPASTE,Input.CHIPS,Input.SOAP,Input.SODA),
        QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
        SHUT_DOWN(Input.STOP);

        private Input[] values;

        Category(Input... types) {
            values = types;
        }

        private static EnumMap<Input,Category> categorys = new EnumMap<Input, Category>(Input.class);


        static {
            for (Category c : Category.class.getEnumConstants()){
                for (Input type : c.values)
                    categorys.put(type,c);
            }
        }

        public static Category categorize(Input input){
            return categorys.get(input);
        }
    }



    private static class Context{

        private State state = State.RESTING;
        private int amount;
        private Input selection;

    }


    enum Machine{M1,M2,M3}

    enum StateDuration{TRANSIENT}

    enum State{

        RESTING{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY: amout +=  input.amount();
                    state = ADDING_MONEY;
                    break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        default:
                }
            }
        },ADDING_MONEY{
            @Override
            void next(Input input) {
                switch (Category.categorize(input)){
                    case MONEY:
                        amout += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amout < selection.amount())
                            System.out.println("Infficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                        default:
                }
            }
        },DISPENSING(StateDuration.TRANSIENT){
            @Override
            void next() {
                System.out.println("here is your " + selection);
                amout -= selection.amount();
                state = GIVING_CHANGE;
            }
        },GIVING_CHANGE(StateDuration.TRANSIENT){
            @Override
            void next() {
                if (amout > 0){
                    System.out.println("your change " + amout);
                    amout = 0;
                }
                state = RESTING;
            }
        },TERMINAL{
            @Override
            void outPut() {
                System.out.println("Halted");
            }
        };

        private boolean isTransient;

        State(StateDuration trans) {
            isTransient = true;
        }


        State() {
        }

        void next(Input input){
            throw new RuntimeException("Only call " + "next (Input input) for non-transient state");
        }

        void next(){
            throw new RuntimeException("Only call " + "next () for non-transient state");
        }

        void outPut(){
            System.out.println(amout);
        }
    }

    private static Map<Machine,Context> em = Collections.synchronizedMap(new EnumMap<Machine, Context>(Machine.class));
    static {
        for (Machine machine :Machine.values()){
            em.put(machine,new Context());
        }
    }



    private static final ReentrantLock lock = new ReentrantLock();


    private static State state;
    private static int amout;
    private static Input selection;


    static void run(Generator<Input> gen,Machine m){
        Context ctx = em.get(m);
        while (ctx.state != State.TERMINAL){
            lock.lock();
            state = ctx.state;
            amout = ctx.amount;
            selection = ctx.selection;
            try{
                state.next(gen.next());
                while (state.isTransient)
                    state.next();
                state.outPut();
                ctx.state = state;
                ctx.amount = amout;
                ctx.selection = selection;
                em.put(m,ctx);
            }finally {
                lock.unlock();
            }
            Thread.yield();
        }
    }




}


interface Generator<T>{
    T next();
}

class RandomInputGenerator implements Generator<VendingMaching.Input> {


    @Override
    public VendingMaching.Input next() {
        return VendingMaching.Input.randomSelection();
    }
}


