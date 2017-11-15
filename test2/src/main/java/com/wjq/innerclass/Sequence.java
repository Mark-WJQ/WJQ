package com.wjq.innerclass;

/**
 * Created by wangjianqiang on 2017/11/1.
 */
public class Sequence <T>{



    private Object[] items;

    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }



    public void add(Object x){
        if (next < items.length){
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selecter{

        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length)
                i++;
        }
    }


    public Selecter selecter(){
        return new SequenceSelector();
    }


    private class RevertSelector implements Selecter{

        private int i = items.length;

        public boolean end() {
            return i == 0;
        }

        public Object current() {
            return items[i-1];
        }

        public void next() {
            if (i >0)
                i--;

        }
    }

    public Selecter rs(){
        return new RevertSelector();
    }



    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0;i < 10 ; i++){
            sequence.add(i);
        }
        Selecter selecter = sequence.selecter();
        while (!selecter.end()){
            System.out.println(selecter.current());
            selecter.next();
        }

        Selecter rs = sequence.rs();
        while (!rs.end()){
            System.out.println(rs.current());
            rs.next();
        }

    }
}

interface Selecter{
    boolean end();
    Object current();
    void next();
}
