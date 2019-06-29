package com.wjq.beanHandle;

import com.wjq.Car1;
import org.springframework.util.ReflectionUtils;

public class TestReflectionUtil {


    public static void main(String[] args) {


        ReflectionUtils.doWithFields(Car1.class, field -> {


            System.out.println(field.getName());


        });



    }


}
