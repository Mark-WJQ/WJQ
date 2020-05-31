package com.wjq.monitor.domain;

import java.lang.reflect.Method;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class MonitorAttributeSourceImpl implements MonitorAttributeSource {

    private MonitorConfig monitorConfig;

    /**
     * 获取监控属性
     *
     * @param method
     * @param target
     * @return
     */
    @Override
    public MonitorAttribute getMonitorAttribute(Method method, Class<?> target) {

        method.getAnnotation(monitorConfig.getAnnotation());
        return null;
    }
}
