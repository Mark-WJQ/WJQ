package com.wjq.monitor.interceptor;

import org.springframework.aop.Pointcut;

/**
 * @author wangjianqiang24
 * @date 2020/5/26
 */
public class MonitorPointcutAdapter {

    private Pointcut pointcut;

    public MonitorPointcutAdapter(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }
}
