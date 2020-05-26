package com.wjq.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
@Component
public class MyMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before: " + method);
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("after: " + method);
        return object;
    }
}
