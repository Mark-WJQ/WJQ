package com.wjq;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2017/10/5.
 */
public class Shapes<T> {



    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        shape s = new Rhomboid();
        //不能强制转换
        //((Circle)s).draw();
        System.out.println(s instanceof Rhomboid);

        List<Integer> li = new ArrayList<Integer>();

        Class<? extends List>  lc = li.getClass();

        System.out.println(lc.getCanonicalName());

        for (Type type : lc.getGenericInterfaces())
            System.out.println(type.getTypeName());
        System.out.println(lc.getGenericSuperclass());

        //System.out.println(li.getClass());

        Rhomboid r = new Rhomboid();
        Class<Rhomboid> cr = Rhomboid.class;
        Class<? super Rhomboid> sc =  cr.getSuperclass();
       //Class<? extends Circle> cc = sc.asSubclass(Circle.class);

        //s = cr.cast(r);
        System.out.println( cr.isAssignableFrom(Rhomboid.class));

        System.out.println(sc.isAssignableFrom(cr));


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


