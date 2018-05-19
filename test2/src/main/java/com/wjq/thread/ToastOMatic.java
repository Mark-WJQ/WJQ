package com.wjq.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by wangjianqiang on 2018/5/13.
 */
public class ToastOMatic {
}

class Toast{
    Toast(int id) {
        this.id = id;
    }

    public enum Status{
        DRY,BUTTERED,JAMMED,READY{
            @Override
            public String toString() {
                return  BUTTERED.toString() + " & " + JAMMED.toString();
            }
        }
    }

    private Status status = Status.DRY;

    private final int id;


    public void butter(){
        status = status == Status.DRY ? Status.BUTTERED : Status.READY;
    }

    public void jam(){
        status = status == Status.DRY ? Status.JAMMED : Status.READY;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}



class ToastQueen extends LinkedBlockingQueue<Toast>{}
