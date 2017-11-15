package com.wjq;

/**
 * Created by wangjianqiang on 2017/10/5.
 */
public class Shapes {



    public static void main(String[] args) {
        shape s = new Rhomboid();
        //不能强制转换
        ((Circle)s).draw();
    }

}



abstract class shape{
    void draw(){
        System.out.println(this + toString());
    };
    @Override
    public abstract String toString();
}

class Circle extends shape{

    public String toString() {
        return "Circle";
    }
}

class Rhomboid extends shape{

    public String toString() {
        return "Rhomboid";
    }
}


