package com.wjq.asm;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generator {


    public static void main(String[] args) throws IOException {
        ClassReader reader = new ClassReader("com/wjq/Base");

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor visitor = new MyClassVisitor(writer);

        reader.accept(visitor,ClassReader.SKIP_DEBUG);

        byte[] data = writer.toByteArray();

        File file = new File("/Users/wangjianqiang/IdeaProjects/WJQ/class-byte/target/classes/com/wjq/Base.class");

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
        System.out.println("success generator");


    }


}
