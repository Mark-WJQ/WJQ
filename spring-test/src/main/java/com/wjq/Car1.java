package com.wjq;

import com.wjq.beanHandle.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car1 extends Car {


    private Double p2;


    private int testVal;

    @Value("${test.val}")
    public void setTestVal(int testVal) {
        this.testVal = testVal;
        System.out.println(testVal+"----------------------------");
    }

    public static void main(String[] args) {
    }

}
