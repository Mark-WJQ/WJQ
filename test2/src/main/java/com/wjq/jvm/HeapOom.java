package com.wjq.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2018/3/18.
 */
public class HeapOom {


    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }


}

