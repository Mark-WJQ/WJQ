package com.wjq.monitor.interceptor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;

/**
 * @author wangjianqiang24
 * @date 2020/5/26
 */
public class MonitorAdvisor extends AbstractPointcutAdvisor {


    private Pointcut pointcut;

    private Advice advice;

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }


    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}
