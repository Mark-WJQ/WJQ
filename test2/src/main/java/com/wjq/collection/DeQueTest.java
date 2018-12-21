package com.wjq.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangjianqiang on 2018/12/16.
 */
public class DeQueTest {


    public static void main(String[] args) {
        Deque<String> deque = new LinkedBlockingDeque<>();

        deque = new ArrayDeque<>();

    }

}
