package com.wjq.reflect;

import com.sun.deploy.security.ValidationState;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianqiang on 2018/3/2.
 *
 * 通过反射获取运行时范型实际类型
 *
 *
 */
public class Reflect  {



    public static void main(String[] args) {

        try {

            Method method = MyClass.class.getMethod("getList",List.class);
            method.getModifiers();

            //范型方法返回类型
           Type type = method.getGenericReturnType();
            System.out.println(type.getTypeName());
           if (type instanceof ParameterizedType) {
               ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] types =parameterizedType.getActualTypeArguments();
                for (Type type1 : types){
                    Class clazz = (Class) type1;
                    System.out.println(clazz.getSimpleName());
                }
           }


            System.out.println("===================================");

           //范型参数
           Type[] types = method.getGenericParameterTypes();
           for (Type type2 : types){
               System.out.println(type2.getTypeName());
               ParameterizedType parameterizedType = (ParameterizedType) type2;
               Type[] types1 =parameterizedType.getActualTypeArguments();
               System.out.println(types1[0].getTypeName());
           }

            System.out.println("==============================================");
            Field field = MyClass.class.getField("doubleMap");
            Type ft = field.getGenericType();
            ParameterizedType parameterizedType = (ParameterizedType) ft;
            Type[] fts = parameterizedType.getActualTypeArguments();
            for (Type t : fts){
                System.out.println(t.getTypeName());
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}


class MyClass{

    public Map<String,Double> doubleMap = new HashMap<>();
    public List<String> getList(List<Integer> list){
        return null;
    }
}
