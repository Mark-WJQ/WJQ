package com.wjq.beanHandle.declareParents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by wangjianqiang on 2018/11/10.
 */
@Aspect
@Component
public class DeclaerIntroducer {
    @DeclareParents(value = "com.wjq.cglib.HelloService+",defaultImpl = DeclareImpl.class)
    public Declare declare;
}
