package com.wjq.collection;

/**
 * Created by wangjianqiang on 2018/12/25.
 *
 * 二分查找：顺序结构，关键字有序
 *
 */
public class TestSearch {


    /**
     * 二分查找非递归
     * @param array
     * @param key
     * @return
     */
   public int binarySearch(int[] array,int key){

        int low = 0;
        int high = array.length;
        while (low <= high) {
            int mild = (low + high) / 2;
            if (key == array[mild])
                return mild;
            if (key < array[mild])
                high = mild - 1;
            else
                low = mild + 1;
        }
        return -1;
    }

    public int rescorybinarySearch(int[] array,int key,int low,int high){

        int mild = (low + high) / 2;
        if (low > high)
            return -1;
        if (array[mild] == key)
            return mild;
        if (key < array[mild])
           return rescorybinarySearch(array,key ,low,mild-1);
        if (key > array[mild]) {
           return rescorybinarySearch(array,key ,mild + 1,high);
        }

        return -1;
    }



}
