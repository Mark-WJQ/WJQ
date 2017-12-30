package com.wjq.generic;

/**
 * Created by wangjianqiang on 2017/12/10.
 */
public class GenericsAndReturnTypes {

    void test(Getter getter){
        Getter r = getter.get();
        GenericGetter gg = getter.get();
    }
}


interface GenericGetter<T extends GenericGetter<T>>{
    T get();
}

interface Getter extends GenericGetter<Getter>{
    Getter get();
}



