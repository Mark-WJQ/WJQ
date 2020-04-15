package com.wjq.dataStruct;

/**
 * 将数字变成 0 的操作次数
 *
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Num20 {


    /**
     * 负数的位表示
     * 先取原码即正数
     * 再取反码即原码取反
     * 反码加1 可以得到负数的位表示
     * @param args
     */

    public static void main(String[] args) {

        int k = 14;
        int i = 0;
        while(k != 0){
            if ((k & 1) == 1){
                k = k & -2;
            }else{
                k = k >> 1;
            }
            i++;
        }


        System.out.println(i);

    }


    public String reverseLeftWords(String s, int n) {


       String left = s.substring(n);
       String rev = s.substring(0,n);

        return left + rev;
    }
}
