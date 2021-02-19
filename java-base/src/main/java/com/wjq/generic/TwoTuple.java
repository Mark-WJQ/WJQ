package com.wjq.generic;

/**
 * Created by wangjianqiang on 2017/11/28.
 *
 * 元组
 */
public class TwoTuple<A,B> {
    //不能修改，但是便于访问-----final
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
