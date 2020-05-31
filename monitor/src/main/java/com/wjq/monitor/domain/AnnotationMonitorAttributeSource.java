package com.wjq.monitor.domain;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public abstract class AnnotationMonitorAttributeSource<T extends Annotation> implements MonitorAttributeSource {


    @Autowired
    private MonitorConfig monitorConfig;


    @Override
    public MonitorAttribute getMonitorAttribute(Method method, Class<?> target) {

        Class<T> classType = getAnnoClazz();
        T anno = null;
        if (method.isAnnotationPresent(classType)) {
            anno = method.getAnnotation(classType);
        } else if (target.isAnnotationPresent(classType)) {
            anno = target.getAnnotation(classType);
        }
        if (Objects.nonNull(anno)) {
            MonitorAttribute attribute = getMonitorAttribute(anno, method, target);
            if (attribute instanceof DefaultMonitorAttribute){
                ((DefaultMonitorAttribute) attribute).setAppName(monitorConfig.getAppName());
                //todo 设置key
            }
            return attribute;
        }
        return null;
    }


    /**
     * 从注解中获取监控属性
     *
     * @param anno
     * @param method
     * @param target
     * @return
     */
    abstract MonitorAttribute getMonitorAttribute(T anno, Method method, Class<?> target);

    /**
     * 获取注解类型
     *
     * @return
     */
    abstract Class<T> getAnnoClazz();


}
