package com.wjq.asm;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.Label;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClassVisitor extends ClassVisitor implements Opcodes {


    public MyClassVisitor(ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }


    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (!name.equals("<init>") && mv != null) {
            mv = new MyMethodVistor(mv);
        }
        return mv;
    }


    class MyMethodVistor extends MethodVisitor implements Opcodes {



        private final Label beginLabel = new Label();
        private final Label endLabel = new Label();


        public MyMethodVistor(MethodVisitor methodVisitor) {
            super(ASM5, methodVisitor);
        }

        //在访问code区前处理
        @Override
        public void visitCode() {
            ExecutorService service = Executors.newFixedThreadPool(1);
            super.visitCode();
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("start");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitMethodInsn(INVOKESTATIC,"com/wjq/asm/MyTest","print","()V",false);
            mv.visitLabel(beginLabel);
        }

        @Override
        public void visitInsn(int opcodes) {

            if ((opcodes >= IRETURN && opcodes <= RETURN) || opcodes == ATHROW) {
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitLdcInsn("end");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            }
            mv.visitInsn(opcodes);

        }


        private Label label;

        @Override
        public void visitMaxs(int i, int i1) {
            mv.visitLabel(endLabel);
            label = new Label();
            mv.visitLabel(label);
            mv.visitInsn(Opcodes.ATHROW);
            super.visitMaxs(i, i1);
        }


        @Override
        public void visitEnd() {
            super.visitTryCatchBlock(beginLabel, endLabel, label, RuntimeException.class.getTypeName());
            super.visitEnd();
        }
    }
}
