package com.wjq.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {


    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                String fileName =  name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null){
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];

                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };



        Object obj = classLoader.loadClass("com.wjq.jvm.ClassLoaderTest");
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);

        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("----------");
            }
        };

        thread.start();
        thread.start();


    }


}
