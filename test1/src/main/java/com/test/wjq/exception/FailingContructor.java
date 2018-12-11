package com.test.wjq.exception;

import com.alibaba.dubbo.common.utils.StringUtils;

/**
 * Created by wangjianqiang on 2017/11/14.
 */
public class FailingContructor {

    String s;

    public FailingContructor() throws Exception {
        s = "aa";
        if (StringUtils.isEmpty(s))
            throw new NullPointerException();

    }

    void dispos(){
        s = null;
        System.out.println(s);
    }


    public static void main(String[] args) {
        try {
            FailingContructor fc = new FailingContructor();
            try{
                System.out.println( fc.s);
            }finally {
                fc.dispos();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
