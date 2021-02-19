package com.wjq.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wangjianqiang on 2019/1/6.
 * 约翰福问题：N个人编号从1 到 N，围坐成一个圆圈。从一号开始传递一个热土豆，经过M次传递后，拿着热土豆的人清除，由下一个继续传递，最后剩下的人取胜，如果 M=0，N=5 则游戏人
 * 依次清除，最后留下5号，如果M=1，N=5那么被清除的顺序是2，4，1，5
 */
public class JosephusProblem {


    public static void main(String[] args) {
        //传递次数M，总数N



        List<Integer> list = new ArrayList<>();


        ListIterator<Integer> iterator = list.listIterator();


        pass(1, 5);
        test(1,5);
    }


    public static void test(int m,int n){

        List<Integer> list = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            list.add(i);
        }
        ListIterator<Integer> iter = list.listIterator();
        int item = 0;

        for (int i = 0 ; i < n ; i++){
            if (iter.hasNext())
                iter.next();
            else {
                iter = list.listIterator();
                iter.next();
            }

            for (int j = 0; j < m ; j++){
                if (iter.hasNext()) {
                    item = iter.next();
                }else {
                    iter = list.listIterator();
                    item = iter.next();
                }
            }
            iter.remove();
            System.out.println(item);



        }


    }



    public static void pass(int m, int n) {
        int i, j, mPrime, numLeft;
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (i = 1; i <= n; i++)
            L.add(i);
        ListIterator<Integer> iter = L.listIterator();
        Integer item = 0;
        numLeft = n;
        //取余
        mPrime = m % n;

        for (i = 0; i < n; i++) {
            //这主要针对 m 比 numLeft 大很多，可以绕几圈的数字 eg: m = 8,numLeft = 7,这样不用遍历几圈，而只是移动几个位置
            mPrime = m % numLeft;
            // 如果 mPrime <= numLeft / 2（这样比较的原因是：移动最小的位数）  直接向后移动mPrime 个位置，
            if (mPrime <= numLeft / 2) {
                if (iter.hasNext())
                    item = iter.next();
                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext())
                        iter = L.listIterator();
                    item = iter.next();
                }
            } else {
                // 如果 mPrime > numLeft / 2 ，向前移动 numLeft - mPrime，因为 （numLeft - mPrime）+ mPrime = numLeft，如果前移（numLeft - mPrime）则相当于反向移动 mPrime 个
                for (j = 0; j < numLeft - mPrime; j++) {
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }
            System.out.print("Removed " + item + " ");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();
            System.out.println();
            for (Integer x : L)
                System.out.print(x + " ");
            System.out.println();
            numLeft--;
        }
        System.out.println();
    }


}
