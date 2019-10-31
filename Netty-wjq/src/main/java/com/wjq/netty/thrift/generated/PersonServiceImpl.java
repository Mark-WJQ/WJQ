package com.wjq.netty.thrift.generated;

import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {




    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {


        System.out.println("Got Client Param " + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {


        System.out.println("Got Client Param");
        System.out.println(person);

    }

}
