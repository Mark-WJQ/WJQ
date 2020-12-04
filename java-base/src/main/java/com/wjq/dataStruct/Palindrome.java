package com.wjq.dataStruct;

import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {




    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        Deque<Integer> stack = new LinkedList<Integer>();
        int ori = x;
        int y = x % 10;
        while (x != 0) {
            stack.offer(y);
            x = x / 10;
            y = x % 10;
        }
        int z = 0;
        while (!stack.isEmpty()) {
            z = z * 10 + stack.pop();
        }

        if (ori == z)
            return true;
        return false;

    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
