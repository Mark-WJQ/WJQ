package com.wjq;

import java.lang.instrument.Instrumentation;

public class TestAgent {

    public static void agentmain(String args, Instrumentation inst)  {

        System.out.println("-----------------" + args);

        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestTransFormer(), true);
        try {



            //重定义类并载入新的字节码
            inst.retransformClasses(Class.forName("com.wjq.instrument.Base"));

            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
