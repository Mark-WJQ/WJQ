package com.wjq.thread;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by wangjianqiang on 2018/5/20.
 * 饭店仿真
 */
public class RestaurantWithQueues {

    public static void main(String[] args) throws IOException {
        ExecutorService exe = Executors.newCachedThreadPool();
        RestaurantR r = new RestaurantR(5,2,exe);
        System.out.println("press 'Enter' to quite");
        exe.execute(r);
        System.in.read();
        exe.shutdownNow();
    }
}

class Table implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private WaitPersonR wp;
    private OrderTicket orderTicket = new OrderTicket(this);
    private final CyclicBarrier cyclicBarrier;
    private final int nCustomer;
    private final ExecutorService exec;

    private List<CustomerR> customers;


    public Table(WaitPersonR person, int nCustomer, ExecutorService exec) {

        this.nCustomer = nCustomer;
        this.exec = exec;
        this.wp = person;

        customers = Collections.synchronizedList(new LinkedList<>());
        cyclicBarrier = new CyclicBarrier(nCustomer + 1, new Runnable() {
            @Override
            public void run() {
                System.out.println(orderTicket.toString());
            }
        });


    }



    public WaitPersonR getWp() {
        return wp;
    }

    public void placeOrder(CustomerR customer,Food food){
        orderTicket.placeOrder(customer,food);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        CustomerR customer;
        for (int i = 0 ; i< nCustomer;i++){
           // customers.add(new CustomerR(this,))
        }

    }
}


class OrderTicket{
    private static int counter = 0;
    private final int id = counter++;
    private final Table table;
    private final List<Order> orders = Collections.synchronizedList(new LinkedList<>());

    public OrderTicket(Table table) {
        this.table = table;
    }

    public WaitPersonR getWaitPerson(){
        return table.getWp();
    }

    public void placeOrder(CustomerR customer,Food food){

    }
}

class Order{
    private static int counter = 0;
    private final int id = counter++;
    private final CustomerR customer;
    private final WaitPersonR waitPerson;
    private final Food food;

    public Order(CustomerR customer, WaitPersonR waitPerson, Food food) {
        this.customer = customer;
        this.waitPerson = waitPerson;
        this.food = food;
    }


    public Food item(){
        return food;
    }

    public CustomerR getCustomer() {
        return customer;
    }

    public WaitPersonR getWaitPerson() {
        return waitPerson;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: "  + food + " for: " + customer + " served by: " + waitPerson;
    }
}

class Plate{

    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public Order getOrder() {

        return order;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

class CustomerR implements Runnable{


    private static int counter = 0;
    private final int id = counter++;
    private final WaitPersonR waitPerson;
    //阻塞队列，且只能放一个，必须take()以后才能put()
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public CustomerR(WaitPersonR waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate plate) throws InterruptedException {
        placeSetting.put(plate);
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        for (Course course : Course.values()){
            Food food = course.randomSelection();
            try{
                //点餐
               waitPerson.placeOrder(this,food);
               //Blocks until course has been delivered
                System.out.println(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + "wating for " + course + "interrupted");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "CustomerR{" +
                "id=" + id +
                '}';
    }
}

class WaitPersonR implements Runnable{

    private static int counter = 0;
    private final int id = counter++;
    private final RestaurantR restaurant;
    BlockingDeque<Plate> fillOrders = new LinkedBlockingDeque<>();

    public WaitPersonR(RestaurantR restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder(CustomerR cust,Food food){

        try{
            //shouldn't actually block because this is a linkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(cust,this,food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try{
            while (!Thread.interrupted()){
                //block until a course is ready
                Plate plate = fillOrders.take();
                System.out.println(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " inturrupted");
        }
        System.out.println(this + " out duty");
    }

    @Override
    public String toString() {
        return "WaitPersonR{" +
                "id=" + id +
                '}';
    }
}

class ChefR implements Runnable{

    private static int counter = 0;
    private final int id = counter++;
    private final RestaurantR restaurant;
    private static Random rand = new Random(47);

    public ChefR(RestaurantR restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        try{
            while (!Thread.interrupted()){
                Order order = restaurant.orders.take();
                Food item = order.item();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                Plate plate = new Plate(order,item);
                order.getWaitPerson().fillOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " inturrupted");
        }
        System.out.println(this + " off duty");

    }

    @Override
    public String toString() {
        return "ChefR{" +
                "id=" + id +
                '}';
    }
}


class RestaurantR implements Runnable{

    private List<WaitPersonR> waitPersons = new ArrayList<>();
    private List<ChefR> chefs = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();

    private static Random random = new Random(47);
    BlockingDeque<Order> orders = new LinkedBlockingDeque<>();

    public RestaurantR(int nwp, int nc, ExecutorService exec) {
        this.exec = exec;
        for (int i = 0 ; i < nwp; i++){
            WaitPersonR wp = new WaitPersonR(this);
            waitPersons.add(wp);
            exec.execute(wp);
        }
        for (int i = 0 ; i < nc; i++){
            ChefR chef = new ChefR(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                //A new customer arrives,assign a waitPerson
                WaitPersonR wp = waitPersons.get(random.nextInt(waitPersons.size()));
                CustomerR c = new CustomerR(wp);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
        System.out.println("Restaurant closing");

    }
}

interface Food{

    enum Appetizer implements Food{
        SALAD,SOUP,SPRING_ROOLS;
    }
    enum mainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,BACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
    }
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,LATTE,CAPPUCCION,TEA,HERB_TEA;
    }
}

enum Course{
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.mainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    Course(Class<? extends Food> clazz) {
        values = clazz.getEnumConstants();
    }

    public Food randomSelection(){
        Random random = new Random(47);
        return values[random.nextInt(values.length)];
    }
}
