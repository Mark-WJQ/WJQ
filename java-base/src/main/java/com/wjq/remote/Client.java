package com.wjq.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/10/22.
 */
public class Client {


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        PersonService ps = (PersonService) Naming.lookup("rmi://127.0.0.1:6600/PersonService");
        List<PersonEntity> pl = ps.getList();

        for (PersonEntity pe : pl){
            System.out.println(pe);
        }
    }
}
