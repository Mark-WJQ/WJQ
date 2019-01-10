package com.wjq.otherpackge;

import com.wjq.innerclass.P1Inner;
import p1.com.wjq.OuterP1;

import java.util.concurrent.CompletableFuture;

/**
 * Created by wangjianqiang on 2017/10/29.
 */
public class ThirdClass extends P1Inner {

    OuterP1 getP1 (){
        System.out.println(i);
        return new Inner();
    }

    public static void main(String[] args) {


        CompletableFuture future = CompletableFuture.supplyAsync(()->{
            System.out.println("");
            return "";
        });

    }

}
