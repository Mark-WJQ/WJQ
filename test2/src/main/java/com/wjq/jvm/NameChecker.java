package com.wjq.jvm;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * Created by wangjianqiang on 2018/7/1.
 */
public class NameChecker {

    private final Messager messager;
    NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();



   private ProcessingEnvironment processingEnv;

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkNames(Element element){
        nameCheckerScanner.scan(element);
    }



    private class NameCheckerScanner extends ElementScanner8<Void,Void>{

        //类
        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(),aVoid);
            checkCamelCase(e,true);
             super.visitType(e, aVoid);
             return null;
        }

        //方法
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD){
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName()))
                    messager.printMessage(Diagnostic.Kind.WARNING,"一个普通方法" + name + "不应该与类名重复，避免与构造函数产生混淆",e);
                checkCamelCase(e,false);
            }

             super.visitExecutable(e, aVoid);
            return null;
        }

        //变量
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            // 如果这个Variable是枚举或常量，则按大写命名检查，否则按照驼峰
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e))
                checkAllCaps(e);
            else
                checkCamelCase(e,false);
             super.visitVariable(e, aVoid);
             return null;
        }

        private boolean heuristicallyConstant(VariableElement e){

            //这个变量所属的类是否是接口
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE)
                return true;
            else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC,Modifier.STATIC,Modifier.FINAL)))
                return true;
            else
                return false;

        }


        private void checkCamelCase(Element e,boolean initialCaps){
            String name = e.getSimpleName().toString();

            boolean previousUpper = false;
            boolean conventional = true;

            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)){
                previousUpper = true;
                if (!initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当以小写字母开头",e);
                    return;
                }
            }else if (Character.isLowerCase(firstCodePoint)){
                if (initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当以大写字母开头",e);
                    return;
                }

            }else {
                conventional = false;
            }

            if (conventional){
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)){
                    cp = name.codePointAt(i);
                    if (Character.isUpperCase(cp)) {
                        if (previousUpper) {
                            conventional = false;
                            break;
                        }
                        previousUpper = true;
                    }else
                        previousUpper = false;

                }
            }

            if (!conventional)
                messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当符合驼峰命名法",e);

        }

        /**
         * 大写命名检查，要求第一个必须是大写的英文字母，其余部分可以是下划线或大写字母
         * @param e
         */
        private void checkAllCaps(Element e){
            String name = e.getSimpleName().toString();
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);

            if (!Character.isUpperCase(firstCodePoint)){
                conventional = false;
            }else {
                boolean previousUnderscore = false;
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)){

                    cp = name.codePointAt(i);
                    if (cp == '_'){
                        if (previousUnderscore){
                            conventional = false;
                            return;
                        }
                        previousUnderscore = true;
                    }else {
                        previousUnderscore = false;
                        if (!Character.isUpperCase(cp) && !Character.isDigit(cp)){
                            conventional = false;
                            break;
                        }
                    }

                }
            }
            if (!conventional)
                messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当全部以大写字母或下划线命名，并且以字母开头",e);

        }
    }


    public static void main(String[] args) {
        System.out.println(Character.charCount(' '));

    }

}
