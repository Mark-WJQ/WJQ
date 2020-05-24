package com.wjq.monitor.domain;

import java.lang.reflect.Method;

public interface MonitorAttributeSource {

    /**
     * 获取监控属性
     * @param method
     * @param target
     * @return
     */
     MonitorAttribute getMonitorAttribute(Method method,Class<?> target);
}
