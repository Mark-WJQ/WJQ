package com.wjq.classLoader;

import com.wjq.instrument.Base;
import sun.net.util.URLUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestClassLoader {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InterruptedException, IOException {

        int i = 0;



            /*ClassLoader classLoader = TestClassLoader.class.getClassLoader();
            System.out.println(classLoader);
            System.out.println(classLoader.getParent());
            System.out.println(classLoader.getParent().getParent());*/



            URL[] urls = new URL[]{new URL("file:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar")};
            //新建一个类加载器
           MyClassLoader myClassLoader = new MyClassLoader(null);

            Class clazz = myClassLoader.loadClass("com.wjq.instrument.Base");

            System.out.println(clazz.getClassLoader() + "==============" + Base.class.getClassLoader());

            System.out.println(Base.class.equals(clazz));

           /* try {
                Method method = clazz.getMethod("process");
                Object obj = clazz.newInstance();
                method.invoke(obj);
                method = null;
                obj = null;
            }catch (Exception e){
                e.printStackTrace();
            }
*/
           myClassLoader = null;
           System.out.println("clazz -------------" + clazz.hashCode());
            clazz = null;

        Thread.sleep(30000);

            System.gc();


            Thread.sleep(30000);


    }


}
