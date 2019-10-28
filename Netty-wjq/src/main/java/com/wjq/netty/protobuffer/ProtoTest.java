package com.wjq.netty.protobuffer;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoTest {


    public static void main(String[] args) throws InvalidProtocolBufferException {

        FirstProto.Person person = FirstProto.Person.newBuilder().setId(1).setName("hahah").build();

        System.out.println(person);


        byte[] person2Byte = person.toByteArray();


        person = FirstProto.Person.parseFrom(person2Byte);



    }
}
