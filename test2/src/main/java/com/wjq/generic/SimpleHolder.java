package com.wjq.generic;


/**
 * Created by wangjianqiang on 2017/12/6.
 */
public class SimpleHolder<T> {
    private T obj;

    public SimpleHolder(T obj) {
        this.obj = obj;
    }


    public T get(){
        return obj;
    }

    public void set(T obj){
        this.obj = obj;
    }

    public static void main(String[] args) {
        //SimpleHolder<Building> sm = new SimpleHolder<Building>();

        Building building = new Building();
        House house = new House();
        System.out.println(house.getClass().isInstance(building));
        System.out.println(building.getClass().isInstance(house));


    }
}


class Building{}

class House extends Building{}