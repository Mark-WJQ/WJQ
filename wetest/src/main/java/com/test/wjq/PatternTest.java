package com.test.wjq;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/4/28.
 */
public class PatternTest {

        public static void main(String[] args){
            JSONObject js1 = new JSONObject();
            js1.put("11","11");
            JSONObject js2 = new JSONObject();
            js2.put("22",22);

            FilterChain chain = new FilterChain();
            chain.addFilter(new Filter1());
            chain.addFilter(new Filter2());
            System.out.println(chain.doFileter(js1.toString(),js2.toString()));

        }

}
