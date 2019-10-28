package com.wjq.javassist;

import com.wjq.Base;
import javassist.*;
import javassist.bytecode.SignatureAttribute;

import java.io.IOException;

public class JavassistTest {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {

        ClassPool cp = ClassPool.getDefault();
        CtClass ct = cp.getCtClass("com.wjq.Base");
        CtMethod cm = ct.getDeclaredMethod("process");

        cm.insertBefore("{ System.out.println(\"start\"); }");
        cm.insertAfter("{ System.out.println(\"end\"); }");

        Class clazz = ct.toClass();

        ct.writeFile("/Users/wangjianqiang/IdeaProjects/WJQ/class-byte/src/main/java/com/wjq/javassist");

       Base base = (Base) clazz.newInstance();

       base.process(1);

    }


}
