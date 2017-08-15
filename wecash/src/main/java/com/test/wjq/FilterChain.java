package com.test.wjq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */
public class FilterChain {

    private List<FilterInterface> filterInterfaces = new ArrayList<FilterInterface>();

    public void addFilter(FilterInterface filter){
        filterInterfaces.add(filter);
    }

    <T> T doFileter(String js1,T js2){
        for (FilterInterface filter:filterInterfaces){
            js2 = filter.doFileter(js1,js2);
        }
        return js2;
    }
}
