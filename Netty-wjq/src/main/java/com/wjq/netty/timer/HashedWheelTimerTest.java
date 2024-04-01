package com.wjq.netty.timer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {

    public static void main(String[] args) {

        HashedWheelTimer wheeltimer = new HashedWheelTimer();
        TimerTask task = (out) -> {

            System.out.println(System.nanoTime());

        };

        wheeltimer.newTimeout(task,90, TimeUnit.MILLISECONDS);
        System.out.println(System.nanoTime());

        wheeltimer.stop();



    }


}
