package com.wjq.monitor.interceptor;

import com.wjq.monitor.alarm.AlarmSupport;
import com.wjq.monitor.alarm.AlarmSupportImpl;
import com.wjq.monitor.annotation.DefaultMonitorAnnotationParser;
import com.wjq.monitor.annotation.Monitor;
import com.wjq.monitor.annotation.MonitorAnnotationParser;
import com.wjq.monitor.domain.*;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
@Resource
@Configuration
@ConditionalOnProperty(name = "monitor.enable", havingValue = "true")
@EnableConfigurationProperties(MonitorConfig.class)
public class MonitorConfiguration {


    @Bean
    @ConditionalOnProperty(prefix = "monitor", name = "expression")
    public MonitorPointcutAdapter expressionPointcut(MonitorConfig monitorConfig) {
        AspectJExpressionPointcut pointCut = new AspectJExpressionPointcut();
        pointCut.setExpression(monitorConfig.getExpression());
        return new MonitorPointcutAdapter(pointCut);
    }

    @Bean
    @ConditionalOnProperty(prefix = "monitor", name = "annotation")
    public MonitorPointcutAdapter annotationMatchingPointcut(MonitorConfig monitorConfig) {
        return getAnnoAdapter(monitorConfig.getAnnotation());
    }

    @Bean
    @ConditionalOnMissingBean
    public MonitorPointcutAdapter defaultPointcutAdapter(MonitorAttributeSource attributeSource) {
        return getAnnoAdapter(Monitor.class);
    }

    /**
     * 获取注解配置
     *
     * @param clazz
     * @return
     */
    private MonitorPointcutAdapter getAnnoAdapter(Class<? extends Annotation> clazz) {
        Pointcut pointcut = new MonitorAnnotationPointcut(clazz);
        return new MonitorPointcutAdapter(pointcut);
    }


    @Bean
    public Pointcut composablePointcut(ObjectProvider<MonitorPointcutAdapter[]> provider) {
        MonitorPointcutAdapter[] monitorPointcutAdapters = provider.getIfAvailable();
        if (monitorPointcutAdapters.length > 1) {
            ComposablePointcut composablePointcut = new ComposablePointcut(new FALSEPointcut());
            for (MonitorPointcutAdapter adapter : monitorPointcutAdapters) {
                composablePointcut.union(adapter.getPointcut());
            }
            return composablePointcut;
        }
        return monitorPointcutAdapters[0].getPointcut();
    }


    @Bean
    @ConditionalOnMissingBean
    public AlarmSupport alarmSupport() {
        return new AlarmSupportImpl();
    }


    @Bean
    @ConditionalOnMissingBean
    public MonitorAnnotationParser annotationParser() {
        return new DefaultMonitorAnnotationParser();
    }


    @Bean
    @ConditionalOnMissingBean
    public MonitorAttributeSource attributeSource(MonitorConfig monitorConfig, List<MonitorAnnotationParser> annotationParsers) {
        AnnotationMonitorAttributeSource annotationMonitorAttributeSource = new AnnotationMonitorAttributeSource(monitorConfig, annotationParsers);
        ConfigMonitorAttributeSource configMonitorAttributeSource = new ConfigMonitorAttributeSource(monitorConfig);
        CompositeMonitorAttributeSource source = new CompositeMonitorAttributeSource(annotationMonitorAttributeSource, configMonitorAttributeSource);
        return source;
    }


    @Bean
    public Advice monitorAdvice(AlarmSupport alarmSupport, MonitorAttributeSource attributeSource) {
        return new MonitorInterceptor(alarmSupport, attributeSource);
    }


    @Bean
    public DefaultPointcutAdvisor monitorAdvisor(Pointcut composablePointcut, Advice monitorAdvice) {
        return new DefaultPointcutAdvisor(composablePointcut, monitorAdvice);
    }


    private class FALSEPointcut implements Pointcut {
        @Override
        public ClassFilter getClassFilter() {
            return clazz -> false;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new StaticMethodMatcher() {
                @Override
                public boolean matches(Method method, Class<?> targetClass) {
                    return false;
                }
            };
        }
    }

}
