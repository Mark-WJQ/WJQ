package com.wjq;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wangjianqiang on 2017/10/6.
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Part.class);
        for (int i = 0 ; i < 10 ; i++){
            typeCounter.count(Part.creatRandom());
        }
        System.out.println(typeCounter.toString());







    }




}

interface Factory<T> {
    T create();
}


class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();


    static {
        partFactories.add(new FueFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteerBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }


    private static Random rand = new Random(47);
    public static Part creatRandom(){
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

}


class Filter extends Part {
}


class FueFilter extends Filter {

    public static class Factory implements com.wjq.Factory<FueFilter> {

        public FueFilter create() {
            return new FueFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements com.wjq.Factory<AirFilter> {

        public AirFilter create() {
            return new AirFilter();
        }
    }
}


class CabinAirFilter extends Filter {
    public static class Factory implements com.wjq.Factory<CabinAirFilter> {

        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}


class OilFilter extends Filter {

    public static class Factory implements com.wjq.Factory<OilFilter> {

        public OilFilter create() {
            return new OilFilter();
        }
    }
}


class Belt extends Part {
}


class FanBelt extends Belt {
    public static class Factory implements com.wjq.Factory {

        public FanBelt create() {
            return new FanBelt();
        }
    }
}


class GeneratorBelt extends Belt {
    public static class Factory implements com.wjq.Factory<GeneratorBelt> {

        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}


class PowerSteerBelt extends Belt {
    public static class Factory implements com.wjq.Factory<PowerSteerBelt> {

        public PowerSteerBelt create() {
            return new PowerSteerBelt();
        }
    }
}