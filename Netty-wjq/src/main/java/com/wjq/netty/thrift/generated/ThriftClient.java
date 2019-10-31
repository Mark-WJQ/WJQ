package com.wjq.netty.thrift.generated;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {


    public static void main(String[] args) {


        TTransport transport = new TFastFramedTransport(new TSocket("localhost",8898),6);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);


        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person);

            System.out.println("--------------------");

            Person p = new Person();
            p.setUsername("李四");
            p.setAge(30);
            p.setMarried(true);
            client.savePerson(p);


        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }finally {
            transport.close();
        }

    }


}


