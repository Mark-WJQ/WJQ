package com.wjq.monitor.interceptor;

import com.wjq.monitor.alarm.AlarmInfo;
import com.wjq.monitor.alarm.AlarmSupport;
import com.wjq.monitor.domain.MonitorAttribute;
import com.wjq.monitor.domain.MonitorAttributeSource;
import com.wjq.monitor.result.Result;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * 切面操作类，该类是对匹配到的对象做了代理处理，
 * 可以记录执行过程中出现的一些异常情况
 *
 * @author wangjianqiang24
 * @date 2020/06/02
 */
public class MonitorInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);


    /**
     * 实际记录对象
     */
    private AlarmSupport alarmSupport;

    /**
     * 报警属性源
     */
    private MonitorAttributeSource attributeSource;


    /**
     * 切面处理构造方法
     *
     * @param alarmSupport    处理方式
     * @param attributeSource 属性获取类
     */
    public MonitorInterceptor(AlarmSupport alarmSupport, MonitorAttributeSource attributeSource) {
        Assert.notNull(alarmSupport, "请设置 alarmSupport");
        Assert.notNull(attributeSource, "请设置 attributeSource");
        this.alarmSupport = alarmSupport;
        this.attributeSource = attributeSource;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        MonitorAttribute attribute = attributeSource.getMonitorAttribute(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()));
        AlarmInfo alarmInfo = alarmSupport.registerInfo(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()), invocation.getArguments(), attribute);
        try {
            Object result = invocation.proceed();
            if (Objects.nonNull(result) && result instanceof Result && Objects.nonNull(attribute) && Objects.nonNull(alarmInfo)) {
                handleCode(attribute, (Result) result, alarmInfo);
            }
            return result;
        } catch (Throwable e) {
            if (Objects.nonNull(attribute) && Objects.nonNull(alarmInfo)) {
                handleError(attribute, e, alarmInfo);
            }
            throw e;
        } finally {
            alarmSupport.end(alarmInfo);
        }
    }


    /**
     * 处理异常
     *
     * @param attribute  属性
     * @param e 异常
     * @param alarmInfo 注册报警信息
     */
    private void handleError(MonitorAttribute attribute, Throwable e, AlarmInfo alarmInfo) {
        try {
            alarmInfo.setException(e);
            if (attribute.ingoreError(e)) {
                //donothing or just log
                alarmSupport.ingore(alarmInfo);
            } else {
                if (attribute.error(e)) {
                    //记录可用率
                    alarmSupport.functionError(alarmInfo);
                }
                if (attribute.alarm(e)) {
                    //报警记录
                    alarmSupport.alarm(alarmInfo);
                }
            }
        } catch (Throwable t) {
            logger.error("报警处理异常请注意", t);
        }
    }

    /**
     * 处理code
     *
     * @param attribute
     * @param result
     * @param alarmInfo
     */
    private void handleCode(MonitorAttribute attribute, Result result, AlarmInfo alarmInfo) {
        try {
            alarmInfo.setResult(result);
            String code = result.getCode();
            if (attribute.ingoreCode(code)) {
                alarmSupport.ingore(alarmInfo);
            } else {
                if (attribute.errorCode(code)) {
                    // 记录可用率
                    alarmSupport.functionError(alarmInfo);
                }
                if (attribute.alarmCode(code)) {
                    // 报警记录
                    alarmSupport.alarm(alarmInfo);
                }
            }
        } catch (Throwable t) {
            //忽略以免影响正常流程，或是日志记录
            logger.error("报警处理异常请注意", t);
        }
    }
}
