package com.wjq.monitor.interceptor;

import com.wjq.monitor.domain.Monitor;
import com.wjq.monitor.domain.MonitorConfig;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
@Configuration
@ConditionalOnProperty(name = "monitor.enable",havingValue = "true")
@ConditionalOnClass(MonitorConfig.class)
@EnableConfigurationProperties(MonitorConfig.class)
public class Config {


    @Autowired
   private MonitorConfig monitorConfig;


    @Bean
    @ConditionalOnProperty(name = "monitor.expression")
    public MonitorPointcutAdapter expressionPointcut(){
        AspectJExpressionPointcut pointCut = new AspectJExpressionPointcut();
        pointCut.setExpression(monitorConfig.getExpression());
        return new MonitorPointcutAdapter(pointCut);
    }

    @Bean
    @ConditionalOnProperty(name = "monitor.annotation")
    public MonitorPointcutAdapter annotationMatchingPointcut(){
        Pointcut pointcut = new AnnotationMatchingPointcut(monitorConfig.getAnnotation(),monitorConfig.getAnnotation(),true);
        return new MonitorPointcutAdapter(pointcut);
    }


    @Bean
    public Pointcut composablePointcut(ObjectProvider<MonitorPointcutAdapter[]> provider){
        MonitorPointcutAdapter[] monitorPointcutAdapters = provider.getIfAvailable();
        if (Objects.isNull(monitorPointcutAdapters)){
            return new AnnotationMatchingPointcut(Monitor.class,Monitor.class,true);
        }

        if (monitorPointcutAdapters.length > 1){
            ComposablePointcut composablePointcut = new ComposablePointcut();
            for (MonitorPointcutAdapter adapter : monitorPointcutAdapters){
                composablePointcut.union(adapter.getPointcut());
            }
            return composablePointcut;
        }
        return monitorPointcutAdapters[0].getPointcut();
    }

}
