package com.wjq.proxy;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切点
 * 定义通知被应用的位置
 */
@Component
public class DirectPointCut implements Pointcut {

    private Class anno;


    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {

                if (aClass.isAnnotationPresent(anno))
                    return true;
                return false;
            }
        };

        //return null;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        //return null;
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> aClass) {
                return false;
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(Method method, Class<?> aClass, Object... objects) {
                return false;
            }
        };
    }
}
