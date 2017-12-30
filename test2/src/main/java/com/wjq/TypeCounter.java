package com.wjq;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangjianqiang on 2017/11/26.
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {

    private Class<?> baseType;
    public TypeCounter(Class<?> baseType){
        this.baseType = baseType;
    }


    public void count(Object obj){
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + "incorrect type: " + type +", should be type of " + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type,quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<Class<?>,Integer> pair : entrySet()){
            sb.append(pair.getKey().getSimpleName());
            sb.append("=");
            sb.append(pair.getValue());
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("}");
        return sb.toString();
    }

}
