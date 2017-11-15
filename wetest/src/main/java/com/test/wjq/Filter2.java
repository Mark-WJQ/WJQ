package com.test.wjq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/4/28.
 */
public class Filter2 implements FilterInterface {
    public <T, F, K> T doFileter(F f, K k) {
        JSONObject js = JSON.parseObject((String)f);
        JSONObject j2 = JSON.parseObject((String)k);
        j2.put("key2","wosji2");
        return (T)j2;
    }
}
