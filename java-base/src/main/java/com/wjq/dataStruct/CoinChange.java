package com.wjq.dataStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 凑零钱
 * @author wjq
 * @version 1.0.0
 * @ClassName CoinChange.java
 * @createTime 2020年02月23日 12:11:00
 */
public class CoinChange {


    /**
     * 包里破解
     * @param amount
     * @param coins
     * @return
     */
    public static int coinChange(int amount, List<Integer> coins) {

        if (amount == 0)
            return 0;
        //最小
        int minCount = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            if (coin > amount)
                continue;
            int sc = coinChange(amount - coin, coins);
            if (sc == -1) continue;
            minCount = Math.min(sc, minCount);
            minCount += 1;
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;

    }


    public static void main(String[] args) {


        List<Integer> coins = new ArrayList<>(3);
        coins.add(3);
        coins.add(2);
        coins.add(5);
        System.out.println(coinChange(13, coins));

        System.out.println(cointChange(13, coins));

        System.out.println(helpero(13, coins));


    }


    public static int cointChange(int amount, List<Integer> coins){


        int[] is = new int[amount + 1];
        Arrays.fill(is,-2);

      return helper(amount,coins,is);

    }



    /**
     * 备忘录法
     * @param amount
     * @param coins
     * @return
     */
    public static int helper(int amount, List<Integer> coins,int[] amounts){

        if (amount == 0)
            return 0;

        if (amounts[amount] != -2)
            return amounts[amount];

        //最小
        int minCount = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            if (coin > amount)
                continue;
            int sc = helper(amount - coin, coins,amounts);
            if (sc == -1) continue;
            minCount = Math.min(sc + 1, minCount);
            amounts[amount] =minCount;
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;

    }


    /**
     * 动态规划,贪心算法
     * @return
     */
    public static int helpero(int amount, List<Integer> coins){

        int[] amounts = new int[amount+1];
        Arrays.fill(amounts,Integer.MAX_VALUE);
        amounts[0] = 0;
        for (int i = 1; i<=amount; i++){
            for (Integer coin : coins){
                if (i < coin)
                    continue;
                amounts[i] = Math.min(amounts[i],Math.abs(1 + amounts[i - coin]));

            }
        }
        return amounts[amount] == Integer.MAX_VALUE ? -1 : amounts[amount];











    }



}
