package com.wjq.collection;

import com.sun.tools.doclets.formats.html.PackageUseWriter;

import java.util.List;

/**
 * Created by wangjianqiang on 2018/1/14.
 */
public class Tester<C> {

    public static int fieldWidth = 8;
    public static Testparam[] defaultParams = Testparam.array(10,5000,100,5000,1000,5000,10000,5000);
    protected C container;

    protected C initialize(int size ){
        return container;
    }

    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField(){
        return "%" + fieldWidth + "s";
    }

    private static String numberField(){
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeFiled = "%" + sizeWidth + "s";

    private Testparam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headline = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests, Testparam[] paramList) {
        this.container = container;
        this.tests = tests;
        this.paramList = paramList;
    }


    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public static <C> void run(C cntnr,List<Test<C>> tests){
        new Tester<C>(cntnr,tests).timedTest();
    }

    public static <C> void run(C container, List<Test<C>> tests, Testparam[] paramList){
        new Tester<C>(container,tests,paramList);
    }


    private void displayHeader(){
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() -1 ;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0 ; i < dashLength/2; i ++){
            head.append("_");
        }
        head.append(" ");
        head.append(headline);
        head.append(" ");
        for (int i = 0 ; i < dashLength/2; i++)
            head.append("_");
        System.out.println(head);
        System.out.format(sizeFiled,"size");
        for (Test test : tests){
            System.out.format(stringField(),test.name);
        }
        System.out.println();
    }




    public void timedTest(){

        displayHeader();
        for (Testparam param : paramList){
            System.out.format(sizeFiled,param.size);
            for (Test<C> test : tests){
                C Kcontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(Kcontainer,param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(),timePerRep);
            }
            System.out.println();
        }
    }

}


class Testparam{

    public final int size;

    public final int loops;


    public Testparam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    public static Testparam[] array(int... values){
        int size = values.length/2;
        Testparam[] result = new Testparam[size];
        int n = 0;
        for (int i = 0 ; i < size ; i ++){
            result[i] = new Testparam(values[n++],values[n++]);
        }
        return result;
    }


    public static Testparam[] array(String ... values){
        int[] vals = new int[values.length];
        for (int i = 0; i<vals.length; i++){
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}


abstract class Test<C>{
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container,Testparam tp);

}

