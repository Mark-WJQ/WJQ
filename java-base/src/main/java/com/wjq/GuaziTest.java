package com.wjq;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GuaziTest {





    public void findIndex(int[] arr,int key){
        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            List<Integer> indexs = new ArrayList<>(arr.length);
            indexs.add(i);
            map.putIfAbsent(arr[i], indexs);

            int next = key - arr[i];
            if (map.containsKey(next)) {
                List<Integer> last = map.get(next);
                last.add(i);
                System.out.println(last);
                return;
            }
            indexs = new ArrayList<>(arr.length);
            for (int j = 0; j <= i; j++) {
                indexs.add(j);
            }
            map.putIfAbsent(sum, indexs);
        }
    }





}
