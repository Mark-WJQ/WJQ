package com.wjq.dataStruct;

import java.util.*;

public class RomanToInt {


    enum ROMAN {


        I("I", 1, null),
        V("V", 5, I),
        X("X", 10, I),
        L("L", 50, X),
        C("C", 100, X),
        D("D", 500, C),
        M("M", 1000, C);


        ROMAN(String code, int i, ROMAN roman) {
            this.i = i;
            this.code = code;
            this.left = roman;
        }

        private int i;

        private String code;

        private ROMAN left;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }


        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public ROMAN getLeft() {
            return left;
        }

        public void setLeft(ROMAN left) {
            this.left = left;
        }
    }


    public static Map<String, ROMAN> map = new HashMap<>();

    static {
        ROMAN[] romens = ROMAN.values();
        for (ROMAN r : romens) {
            map.put(r.code, r);
        }
    }


    public static int romanToInt(String s) {


        if (s == null || "".equals(s)) {
            return 0;
        }

        int l = s.length();
        int sum = 0;
        for (int i = l - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            ROMAN r = map.get(c.toString());
            sum += r.getI();
            while (i != 0 && r.left != null && r.left.code.equals(String.valueOf(s.charAt(i - 1)))) {
                sum -= r.left.getI();
                i--;
                r = map.get(String.valueOf(s.charAt(i)));
            }
        }


        return sum;


    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }


}
