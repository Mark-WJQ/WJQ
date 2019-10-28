package com.test.wjq;

public class TestClass {


    public static final int i1 = 1;


    public static String ref = test.NODE_SMS_PLACEHOLDER_CONDITION;

    public TestClass() {
        System.out.println();
    }


    public static int i2 = 2;

    static {
        System.out.println(i2);
    }


    public int[] a;

    @Deprecated
    public void test(int[] b, int i, String s, Comparable comparable) {
        comparable.compareTo(1);

        int c = 1 / 0;
        try {
            int j = i;
            j += b[1];
        } catch (Exception e) {

        }
    }


    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (RuntimeException e) {
            x = 2;
            return x;
        }
    }





    public void testDouble(){

        double a = 1;
        System.out.println(a);

    }


    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(testClass.inc());
    }


}
