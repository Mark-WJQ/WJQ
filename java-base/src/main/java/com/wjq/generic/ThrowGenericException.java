package com.wjq.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/12/13.
 */
public class ThrowGenericException {


    public static void main(String[] args) {


        try {
            FileInputStream fis = new FileInputStream("");
            InputStreamReader isr = new InputStreamReader(fis);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int k = 1;
        System.out.println(k-->1);
        //k-->1 means k-- >=1

        ProcessRunner<String,Failure1,Failure2> runner = new ProcessRunner<>();

        for (int i = 0 ; i < 3 ; i ++){
            runner.add(new Processor1());
        }

        try{
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            failure1.printStackTrace();
        } catch (Failure2 failure2) {
            failure2.printStackTrace();
        }


        ProcessRunner<Integer,Failure2,Failure1> runner1 = new ProcessRunner<>();
        for (int i = 0; i < 3; i ++)
            runner1.add(new Processor2());
        try {
            System.out.println(runner1.processAll());
        } catch (Failure2 failure2) {
            failure2.printStackTrace();
        } catch (Failure1 failure1) {
            failure1.printStackTrace();
        }

    }
}


interface Processor<T,E extends Exception,K extends Exception>{
    void process(List<T> resultCollector) throws E,K;
}



class ProcessRunner<T,E extends Exception,K extends Exception> extends ArrayList<Processor<T,E,K>>{

    List<T> processAll() throws E,K{
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T,E,K> processor : this){
            processor.process(resultCollector);
        }
        return resultCollector;
    }


}



class Failure1 extends Exception{}

class Failure2 extends Exception{}

class Processor1 implements Processor<String,Failure1,Failure2>{

    static int count = 3;


    @Override
    public void process(List<String> resultCollector) throws Failure1 {
        if (count-->1){
            System.out.println(count);
            resultCollector.add("Hep!");
        }
        else
            resultCollector.add("Ho!");
        if (count < 0){
            throw new Failure1();
        }
    }
}


class Processor2 implements Processor<Integer,Failure2,Failure1>{

    static int count = 2;


    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if (count-- ==0){
            resultCollector.add(47);
        }
        else
            resultCollector.add(1);
        if (count < 0){
            throw new Failure2();
        }
    }
}