package com.wjq.remote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/10/22.
 */
public class PersonServiceImpl implements PersonService,Serializable {
    public PersonServiceImpl() {
        super();
    }

    public List<PersonEntity> getList() {

        System.out.println("get person start");
        List<PersonEntity> pl = new ArrayList<PersonEntity>();
        PersonEntity p1 = new PersonEntity();
        p1.setAge(10);
        p1.setId(1);
        p1.setName("hello");

        pl.add(p1);

        PersonEntity p2 = new PersonEntity();
        p2.setName("hi");
        p2.setId(2);
        p2.setAge(20);

        pl.add(p2);


        return pl;
    }
}
