package com.wjq.asm;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;

public class TestAdapter extends AdviceAdapter implements Opcodes  {


    protected TestAdapter(int i, MethodVisitor methodVisitor, int i1, String s, String s1) {
        super(i, methodVisitor, i1, s, s1);
    }


    @Override
    protected void onMethodEnter() {

        super.onMethodEnter();
    }




}
