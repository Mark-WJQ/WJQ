package com.wjq.monitor.domain;

import java.lang.reflect.Method;

/**
 * 注解解析类型
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class AnnotationMonitorAttributeSourceImpl extends AnnotationMonitorAttributeSource<Monitor> {


    @Override
    public MonitorAttribute getMonitorAttribute(Monitor anno, Method method, Class<?> target) {
        RuleBasedMonitorAttribute monitorAttribute = new RuleBasedMonitorAttribute();
        monitorAttribute.setAlarmCodes(anno.alarmCodes());
        monitorAttribute.setAlarms(anno.alarm());
        monitorAttribute.setKey(anno.key());
        monitorAttribute.setError(anno.error());
        monitorAttribute.setErrorCodes(anno.errorCodes());
        monitorAttribute.setIngoreCodes(anno.ingoreCodes());
        monitorAttribute.setIngoreErrors(anno.ingoreError());
        return monitorAttribute;
    }

    @Override
    public Class<Monitor> getAnnoClazz() {
        return Monitor.class;
    }


}
