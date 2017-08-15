package com.test.wjq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Filter1 implements FilterInterface {
    public <T, F, K> T doFileter(F f, K k) {

        JSONObject js = JSON.parseObject((String)f);
        JSONObject js2 = JSON.parseObject((String)k);
        js2.put("key1","woshi1");
        return (T)js2;
    }
}
