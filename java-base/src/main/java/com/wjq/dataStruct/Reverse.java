package com.wjq.dataStruct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Reverse {


    public static int reverse(int x) {

        Deque<Integer> stack = new LinkedList<Integer>();
        int y = x % 10;
        while (x != 0) {
            stack.offer(y);
            x = x / 10;
            y = x % 10;
        }
        Long z = 0L;
        while (!stack.isEmpty()) {
            z = z * 10 + stack.pop();
        }
        if ( z > Integer.MAX_VALUE || z < Integer.MIN_VALUE)
            return 0;
        return z.intValue();
    }


    public static void main(String[] args) {
        System.out.println( reverse(Integer.MAX_VALUE));
    }







}
