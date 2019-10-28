package com.wjq;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class TestTransFormer implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming " + className);
        try {
                System.out.println("-------------------");
                ClassPool cp = ClassPool.getDefault();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(classfileBuffer);
                CtClass cc = cp.makeClass(byteArrayInputStream);
                CtMethod m = cc.getDeclaredMethod("process");
                m.insertBefore("{ System.out.println(\"start\"); }");
                m.insertAfter("{ System.out.println(\"end\"); }");
                return cc.toBytecode();

        }catch (NullPointerException e){

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
