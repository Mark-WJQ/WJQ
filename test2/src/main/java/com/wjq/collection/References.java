package com.wjq.collection;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangjianqiang on 2018/1/21.
 */
public class References {



    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null)
            System.out.println("In queue :" + inq.get());
    }

    public static void main(String[] args) {
       /* int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i = 0 ;i < size; i++){
            VeryBig big = new VeryBig("soft : " + i);
            sa.add(new SoftReference<VeryBig>(big,rq));
            System.out.println("Juste created : " + sa.getLast().get());
            checkQueue();
        }*/

       /*SoftReference<VeryBig> sr = new SoftReference<VeryBig>(new VeryBig("111"));
       WeakReference<VeryBig> wr = new WeakReference<VeryBig>(new VeryBig("2222"),rq);
        System.out.println(wr.get());
        checkQueue();
        System.gc();
        System.out.println(wr.get());
        checkQueue();*/


        PhantomReference<VeryBig> pr = new PhantomReference<>(new VeryBig("333"),rq);

        //System.out.println(pr.get());
       System.gc();

        checkQueue();


        /*LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for (int i = 0 ;i < size; i++){
            wa.add(new WeakReference<VeryBig>(new VeryBig("weak : " + i),rq));
            System.out.println("Juste created : " + wa.getLast().get());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("SOFT"));

        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for (int i = 0; i < size ; i ++) {
            pa.add(new PhantomReference<>(new VeryBig("Ph " + i), rq));
            System.out.println("Juste created :" + pa.getLast().get());
            checkQueue();
        }*/
    }

}

class VeryBig{
    private static final int SIZE = 10000;
    private Long[] la = new Long[SIZE];

    private static String ident;

    public VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}
