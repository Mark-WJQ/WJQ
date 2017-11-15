package com.wjq.innerclass;

/**
 * Created by wangjianqiang on 2017/11/1.
 */
public interface InterfaceInner {

    void howdy();

    /**
     * 接口中默认static，final，嵌套类
     */
    class Test implements InterfaceInner{

        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
