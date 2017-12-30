package com.wjq.generic;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangjianqiang on 2017/12/5.
 */
public class Sets {

    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result = copy(a);
        result.addAll(b);
        return result;

    }

    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = copy(a);
        result.retainAll(b);
        return result;

    }

    public static <T> Set<T> difference(Set<T> a,Set<T> b){
        Set<T> result = copy(a);
        result.removeAll(b);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a,Set<T> b ){
        return difference(union(a,b),intersection(a,b));
    }

    public static <T> Set<T> copy(Set<T> a){
        if (a instanceof EnumSet){
            return ((EnumSet) a).clone();
        }
        return new HashSet<T>();
    }


    public static void main(String[] args) {
        Set<Watercolors> s1 = EnumSet.range(Watercolors.BRILLIANT_RED,Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> s2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE,Watercolors.BURNT_UMBER);
        System.out.println("s1 :" + s1);
        System.out.println("s2 :" + s1);
        System.out.println(union(s1,s2));



    }


}

enum Watercolors{
    ZINC,LEMON_YELLOW,MEDIUM_YELLOW,DEEP_YELLOW,ORANGE,BRILLIANT_RED,CRIMSON,MAGENTA,ROSE_MADDER,VIOLET,CERULEAN_BLUE_HUE,
    PHTHALO_BLUE,ULTRAMARINE,COBALT_BLUE_HUE,PERMANENT_GREEN,VIRIDIAN_HUE,SAP_GREEN,YELLOW_OCHER,BURNT_SIENNA,RAW_UMBER,BURNT_UMBER,
    PAYNES_GRAY,IVORY_BLACK
}


