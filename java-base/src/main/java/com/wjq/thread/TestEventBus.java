package com.wjq.thread;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangjianqiang on 2018/5/31.
 */
public class TestEventBus {

    public static void main(String[] args) throws IOException {
        TestEventBus testEventBus = new TestEventBus();
        testEventBus.should_recv_event_message();


        System.in.read();
    }


    public void should_recv_event_message(){
        //EventBus eventBus = new EventBus();
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
        CookieContainer cookieContainer = new CookieContainer(eventBus);
        HandleService cookieSeller = new CookieSeller(eventBus);
        HandleService cookieMallBoss = new CookieMallBoss(eventBus);

        cookieContainer.setNumberOfCookie(3);

        cookieContainer.getACookie();
        cookieContainer.getACookie();
        cookieContainer.getACookie();
        System.out.println("=============再次取cookie，触发Empty事件发布==========");
        cookieContainer.getACookie();
     }


}


class EmptyEvent{

}


interface HandleService{

    @AllowConcurrentEvents
    //@Subscribe
    default void handler(EmptyEvent emptyEvent) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getName() + ":" + "receving empty event");
    }
}


class CookieSeller implements HandleService{

    public CookieSeller(EventBus bus) {
        bus.register(this);
    }

}


class CookieMallBoss implements HandleService{
    public CookieMallBoss(EventBus eventBus) {
        eventBus.register(this);
    }
}

class CookieContainer{

    private EventBus eventBus;

    private AtomicInteger numberOfCookie = new AtomicInteger();

    public CookieContainer(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setNumberOfCookie(int numberOfCookie) {
        this.numberOfCookie.set(numberOfCookie);
    }

    public void getACookie(){
        if (numberOfCookie.get() == 0){
            long start = System.currentTimeMillis();
            eventBus.post(new EmptyEvent());
            System.out.println("Publising event time: " + (System.currentTimeMillis() - start) + " ms");
            return;
        }
        numberOfCookie.decrementAndGet();
        System.out.println("retrieve a cookie");
    }
}

