package com.wjq.dataStruct;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 两数之和
 * Created by wangjianqiang on 2019/5/14.
 */
public class SumTest {



        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer>  map = new HashMap<>();
            for (int i = 0;i < nums.length;i++){

                int sub = target - nums[i];
                if (map.containsKey(sub)){
                    System.out.println(map.get(sub) +"========="+i);
                    return new int[]{map.get(sub),i};
                }
                map.putIfAbsent(nums[i],i);
            }
            return null;
        }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);

        ListNode next = head;
        head.next = next;
        int v1 = 0,v2 = 0,high= 0;


        do{

            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int v = v1 + v2 + high;
            ListNode node;
            if(v < 10){
                high = 0;
                node = new ListNode(v);
            }else{
                node = new ListNode(v - 10);
                high = 1;
            }
            if (l1 == null && l2 == null && high == 1){
                node.next = new ListNode(1);
            }
            next = next.next = node;
            v1 = v2 = 0;

        }while( l1 != null || l2 != null );


        return head.next;


    }


     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
       ListNode n = l1.next = new ListNode(4);
       n = n.next = new ListNode(3);
        n.next = new ListNode(5);


       ListNode l2 = new ListNode(5);
       n = l2.next =  new ListNode(6);
       n.next = new ListNode(4);
      ListNode l3 = addTwoNumbers(l1,l2);
        do {
            System.out.println(l3.val);
        }while ((l3 = l3.next) != null);



    }


}
