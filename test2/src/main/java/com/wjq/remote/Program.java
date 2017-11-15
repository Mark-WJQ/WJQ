package com.wjq.remote;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by wangjianqiang on 2017/10/22.
 */
public class Program {


    public static void main(String[] args) {
        try {
        PersonService ps = new PersonServiceImpl();

            //注册通讯端口
            LocateRegistry.createRegistry(6600);
            //注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/PersonService",ps);

            System.out.println("Service start");
            System.in.read();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
