package com.wjq.monitor.interceptor;

import com.wjq.monitor.alarm.AlarmInfo;
import com.wjq.monitor.alarm.AlarmSupport;
import com.wjq.monitor.domain.MonitorAttribute;
import com.wjq.monitor.domain.MonitorAttributeSource;
import com.wjq.monitor.domain.Result;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;

import java.util.Objects;

/**
 * 切面
 */
public class MonitorInterceptor implements MethodInterceptor {

    private Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);


    private AlarmSupport alarmSupport;

    /**
     * 报警属性源
     */
    private MonitorAttributeSource attributeSource;


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        MonitorAttribute attribute = attributeSource.getMonitorAttribute(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()));

        AlarmInfo alarmInfo = alarmSupport.registerInfo(invocation.getMethod(), AopUtils.getTargetClass(invocation.getThis()),attribute);

        try {
            Object result = invocation.proceed();
            if (Objects.nonNull(result) && result instanceof Result) {
                try {
                    String code = ((Result) result).getCode();
                    if (attribute.ingoreCode(code)){

                    }else {
                        if (attribute.errorCode(code)) {
                            if (Objects.nonNull(alarmInfo)) {
                                //todo 记录可用率
                                alarmInfo.setResult((Result) result);
                                alarmSupport.functionError(alarmInfo);
                            }
                        }

                        if (attribute.alarmCode(code)) {
                            //todo 报警
                            //todo 报警记录
                            if (Objects.nonNull(alarmInfo)) {
                                alarmInfo.setResult((Result) result);
                                alarmSupport.alarm(alarmInfo);
                            }
                        }
                    }
                } catch (Throwable t) {
                    //TODO 忽略以免影响正常流程，或是日志记录
                    logger.error("报警处理异常请注意",t);
                }
            }

            return result;

        } catch (Throwable e) {
            try {
                if (attribute.ingoreError(e)) {

                } else {

                    if (attribute.error(e)) {
                        //todo 记录可用率
                        alarmInfo.setException(e);
                        alarmSupport.functionError(alarmInfo);
                    }

                    if (attribute.alarm(e)) {
                        //todo 报警记录
                        alarmInfo.setException(e);
                        alarmSupport.alarm(alarmInfo);
                    }
                }
            }catch (Throwable t){
                logger.error("报警处理异常请注意",t);
            }
            throw e;
        } finally {
            alarmSupport.end(alarmInfo);
        }

    }
}
