package com.test.wjq.collection;

import java.util.*;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName LinkedHashMapTest.java
 * @createTime 2019年12月07日 11:43:00
 */
public class LinkedHashMapTest {


    public static void main(String[] args) {


        LinkedHashMap<String,String> hashMap = new LinkedHashMap<>();

        hashMap.put("111","333");
        hashMap.put("2222","444");
        hashMap.put("111","333");

       Set<Map.Entry<String,String >> entrySet = hashMap.entrySet();
      Iterator<Map.Entry<String,String>> iterator  = entrySet.iterator();
      while (iterator.hasNext()){
         Map.Entry entry = iterator.next();
      }





        System.out.println(hashMap);


    }


}
