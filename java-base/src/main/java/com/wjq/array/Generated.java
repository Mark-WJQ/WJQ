package com.wjq.array;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by wangjianqiang on 2017/12/21.
 */
public class Generated {

    public static <T> T[] array(T[] a,Generator<T> gen){
        return new CollectionDate<T>(gen,a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> clazz,Generator<T> gen,int size){
        T[] a = (T[]) Array.newInstance(clazz,size);
        return new CollectionDate<T>(gen,a.length).toArray(a);
    }


    static class CollectionDate<T> extends ArrayList<T>{
        private Generator<T> gen;
        private int size;

        public CollectionDate(Generator<T> gen, int size) {
            for (int i = 0;i < size; i ++){
                this.add(gen.next());
            }
        }

    }


    public static void main(String[] args) {
        Double[] ds = new Double[10];
        System.out.println(Arrays.deepToString(array(ds,new CountingGenerator.Double(1))));

        System.out.println(Arrays.deepToString(array(BigDecimal.class,new CountingGenerator.Bigdecimal(),10)));

        //Array.set
    }

}




class Task extends ForkJoinTask{
    /**
     * Returns the result that would be returned by {@link #join}, even
     * if this task completed abnormally, or {@code null} if this task
     * is not known to have been completed.  This method is designed
     * to aid debugging, as well as to support extensions. Its use in
     * any other context is discouraged.
     *
     * @return the result, or {@code null} if not completed
     */
    @Override
    public Object getRawResult() {
        return null;
    }

    /**
     * Forces the given value to be returned as a result.  This method
     * is designed to support extensions, and should not in general be
     * called otherwise.
     *
     * @param value the value
     */
    @Override
    protected void setRawResult(Object value) {

    }

    /**
     * Immediately performs the base action of this task and returns
     * true if, upon return from this method, this task is guaranteed
     * to have completed normally. This method may return false
     * otherwise, to indicate that this task is not necessarily
     * complete (or is not known to be complete), for example in
     * asynchronous actions that require explicit invocations of
     * completion methods. This method may also throw an (unchecked)
     * exception to indicate abnormal exit. This method is designed to
     * support extensions, and should not in general be called
     * otherwise.
     *
     * @return {@code true} if this task is known to have completed normally
     */
    @Override
    protected boolean exec() {
        return false;
    }
}

