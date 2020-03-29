package com.wjq.factoryBean;

import com.wjq.Car1;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class DemoFatoryBean implements FactoryBean<Car1> {
    @Override
    public Car1 getObject() throws Exception {
        return new Car1();
    }

    @Override
    public Class<Car1> getObjectType() {
        return Car1.class;
    }
}
