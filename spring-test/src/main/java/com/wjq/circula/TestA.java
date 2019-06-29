package com.wjq.circula;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestA {

    public TestA() {
    }



    @Autowired
    TestB b;
}
