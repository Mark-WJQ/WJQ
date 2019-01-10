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

    //给HelloService实现类自动实现Declare接口
    @DeclareParents(value = "com.wjq.cglib.HelloServiceimpl",defaultImpl = DeclareImpl.class)
    public Declare declare;
}
