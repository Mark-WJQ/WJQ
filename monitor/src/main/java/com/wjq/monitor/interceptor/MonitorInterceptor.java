package com.wjq.monitor.interceptor;

import com.wjq.monitor.alarm.AlarmInfo;
import com.wjq.monitor.alarm.AlarmSupport;
import com.wjq.monitor.domain.MonitorAttribute;
import com.wjq.monitor.domain.MonitorAttributeSource;
import com.wjq.monitor.domain.Result;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;

import java.util.Objects;

/**
 * 切面
 */
public class MonitorInterceptor implements MethodInterceptor {


    private AlarmSupport alarmSupport;


    /**
     * 报警属性源
     */
    private MonitorAttributeSource attributeSource;


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        MonitorAttribute attribute = attributeSource.getMonitorAttribute(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()));

        AlarmInfo alarmInfo = alarmSupport.getAlarmInfo(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()));

        try {


            Object result = invocation.proceed();
            if (Objects.nonNull(result) && result instanceof Result) {
                try {
                    String code = ((Result) result).getCode();
                    if (attribute.errorCodes(code)) {
                        //todo 记录可用率
                        alarmInfo.setAlarmInfo(((Result) result).getInfo());
                        alarmSupport.functionError(alarmInfo);
                    }

                    if (attribute.alarmCodes(code)) {
                        //todo 报警
                        //todo 报警记录
                        alarmInfo.setAlarmInfo(((Result) result).getInfo());
                        alarmSupport.alarm(alarmInfo);
                    }
                } catch (Throwable t) {
                    //TODO 忽略以免影响正常流程，或是日志记录
                }
            }

            return result;

        } catch (Throwable e) {
            //todo 日志记录

            if (attribute.ingoreError(e)) {

            } else {

                if (attribute.error(e)) {
                    //todo 记录可用率
                    alarmInfo.setAlarmInfo(e.getMessage());
                    alarmSupport.functionError(alarmInfo);
                }

                if (attribute.alarm(e)) {
                    //todo 报警记录
                    alarmInfo.setAlarmInfo(e.getMessage());
                    alarmSupport.alarm(alarmInfo);
                }
            }
            throw e;
        } finally {
            alarmSupport.end(alarmInfo);
        }

    }
}
