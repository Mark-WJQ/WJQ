package com.wjq;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

/**
 * Created by wangjianqiang on 2017/10/5.
 * <p>
 * 在初始化类时：
 * 先执行 静态代码块，在执行构造犯法
 * 有父类时：执行 父类静态代码块，子类静态代码块，父类构造方法，子类构造方法
 */
public class Toytest {


    public static void ptintInfo(Class cc) {


        Class<Toy> tc = Toy.class;

        for (Constructor c : tc.getDeclaredConstructors()) {
            System.out.println(c);
        };

        System.out.println("Class Name:" + cc.getName() + ";isInterface:" + cc.isInterface() + ";simpleName:" + cc.getSimpleName() + ";canonical name :" + cc.getCanonicalName());
    }


    public static void main(String[] args) {






        Class cc = null;
        try {
            cc = Class.forName("com.wjq.FancyToy");
            cc.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        ptintInfo(cc);

        for (Class face : cc.getInterfaces()) {
            ptintInfo(face);
        }

        Class up = cc.getSuperclass();

        Object obj = null;

        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        ptintInfo(obj.getClass());

    }


}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {

    static {

        System.out.println("this is toy");
    }

    private Toy() {
        System.out.println("instace toy");
    }

    public Toy(int i) {
        System.out.println("instace toy");
    }


}


class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

    static {
        System.out.println("this is FancyToy");
    }

    public FancyToy() {
        super(1);
        System.out.println("instance FancyToy");
    }
}



