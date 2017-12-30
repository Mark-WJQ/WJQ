package com.wjq.array;

import com.wjq.innerclass.factory.Bicycle;

import java.math.BigDecimal;

/**
 * Created by wangjianqiang on 2017/12/21.
 */
public class CountingGenerator {


    public static class Boolean implements Generator<java.lang.Boolean> {

        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        private byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character>{

        int index = -1;
        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }


    public static class String implements Generator<java.lang.String>{

        private  int lenght = 7;
        Generator<java.lang.Character> cg = new Character();

        public String() {
        }

        public String(int lenght) {
            this.lenght = lenght;
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[lenght];

            for (int i =0 ;i < lenght;i++){
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short>{

        private short value = 0;
        @Override
        public java.lang.Short next() {
            return value++;
        }
    }


    public static class Integer implements Generator<java.lang.Integer>{

        private java.lang.Integer value = 0;
        @Override
        public java.lang.Integer next() {
            return value ++;
        }
    }

    public static class Long implements Generator<java.lang.Long>{
        private long value = 0;

        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float>{
        private float value = 0;

        @Override
        public java.lang.Float next() {
            return value++;
        }
    }

    public static class Double implements Generator<java.lang.Double>{
        double skip = 1;

        public Double(double skip) {
            this.skip = skip;
        }

        private double value = 0;

        @Override
        public java.lang.Double next() {
            return value = value + skip;
        }
    }

    public static class Bigdecimal implements Generator<BigDecimal>{

        BigDecimal value = new BigDecimal(10);
        @Override
        public BigDecimal next() {
            return value = value.add(new BigDecimal(1));
        }
    }



    private static int size = 10;

    public static void test(Class<?> surroundingClass){
        for (Class<?> type : surroundingClass.getClasses()){
            System.out.println(type.getSimpleName());
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for (int i = 0 ; i < size ; i++){
                    System.out.println(g.next());
                }
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        test(CountingGenerator.class);
    }


}

interface Generator<T>{
    T next();
}
