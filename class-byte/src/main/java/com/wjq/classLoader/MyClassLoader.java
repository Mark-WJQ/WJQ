package com.wjq.classLoader;

import java.io.*;

public class MyClassLoader extends ClassLoader {


    String path = "/Users/wangjianqiang/IdeaProjects/WJQ/class-byte/target/classes/";


    /**
     * Creates a new class loader using the specified parent class loader for
     * delegation.
     *
     * <p> If there is a security manager, its {@link
     * SecurityManager#checkCreateClassLoader()
     * <tt>checkCreateClassLoader</tt>} method is invoked.  This may result in
     * a security exception.  </p>
     *
     * @param parent The parent class loader
     * @throws SecurityException If a security manager exists and its
     *                           <tt>checkCreateClassLoader</tt> method doesn't allow creation
     *                           of a new class loader.
     * @since 1.2
     */
    public MyClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        return defineClass(name,data,0,data.length);
    }


    private byte[] loadClassData(String name){
        name = name.replace(".","//");
        try {
            FileInputStream fis = new FileInputStream(new File(path + name + ".class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = fis.read()) !=-1){
            baos.write(b);
            }
        return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("myclassLoader ---------- finalize");
        super.finalize();

    }
}
