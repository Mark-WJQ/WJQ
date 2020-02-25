package com.wjq.dataStruct;

import java.util.*;

/**
 * 卖钢筋
 *
 * @author wjq
 * @version 1.0.0
 * @ClassName CutIron.java
 * @createTime 2020年02月23日 14:06:00
 */
public class CutIron {


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 5);
        map.put(3, 8);
        map.put(4, 9);
        map.put(5, 10);
        map.put(6, 17);
        map.put(7, 17);
        map.put(8, 20);
        map.put(9, 24);
        map.put(10, 30);
        System.out.println(cutIron(10, map));

        System.out.println(cutIronBack(10, map));

        System.out.println(cutIronDyn(10, map));


    }


    /**
     * @param n     钢筋长度
     * @param price 价格映射
     * @return
     */
    public static int cutIron(int n, HashMap<Integer, Integer> price) {

        if (n == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> set = price.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (n < entry.getKey())
                continue;
            int sc = cutIron(n - entry.getKey(), price);
            if (sc == 1)
                continue;
            max = Math.max(entry.getValue() + sc, max);
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }


    /**
     * 备忘录切割法
     *
     * @param n
     * @param price
     * @return
     */
    public static int cutIronBack(int n, HashMap<Integer, Integer> price) {
        int[] amounts = new int[n + 1];
        Arrays.fill(amounts, Integer.MIN_VALUE);
        amounts[0] = 0;
        return helper(n, price, amounts);
    }


    public static int helper(int n, HashMap<Integer, Integer> price, int amounts[]) {
        if (n == 0)
            return 0;
        if (amounts[n] != Integer.MIN_VALUE)
            return amounts[n];
        int max = Integer.MIN_VALUE;
        Set<Map.Entry<Integer, Integer>> set = price.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (n < entry.getKey())
                continue;
            int sc = helper(n - entry.getKey(), price, amounts);
            if (sc == -1)
                continue;
            max = Math.max(entry.getValue() + sc, max);
        }
        amounts[n] = max;
        return max == Integer.MIN_VALUE ? -1 : max;
    }


    /**
     * 动态规划
     * @param n
     * @param price
     * @return
     */
    public static int cutIronDyn(int n, HashMap<Integer, Integer> price) {
        int[] amounts = new int[n + 1];
        Arrays.fill(amounts, Integer.MIN_VALUE);
        amounts[0] = 0;
        amounts[1] = 1;

        for (int i = 1; i <= n; i++) {
            Set<Map.Entry<Integer, Integer>> set = price.entrySet();
            Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (i < entry.getKey())
                    continue;
                amounts[i] = Math.max(entry.getValue() + amounts[i - entry.getKey()], amounts[i]);
            }

        }
        return amounts[n] == Integer.MIN_VALUE ? -1 : amounts[n];
    }


}
