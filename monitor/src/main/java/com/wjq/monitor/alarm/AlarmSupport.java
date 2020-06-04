package com.wjq.monitor.alarm;

import com.wjq.monitor.domain.MonitorAttribute;

import java.lang.reflect.Method;

public interface AlarmSupport<T extends AlarmInfo> {

    /**
     * 获取报警信息组成信息,
     * 有异常自己内部处理不要抛出来
     * 如果返回空则不记录信息
     * @param method 当前执行方法
     * @param targetClass 该方法所属的类
     *
     * @return
     */
    AlarmInfo registerInfo(Method method, Class targetClass,Object[] arguments,  MonitorAttribute attribute);

    /**
     * 记录可用率
     * @param info 可用率信息
     */
    void functionError(T info);

    /**
     * 报警
     * @param info 报警信息
     */
    void alarm(T info);

    /**
     * 结束记录
     * @param info
     */
    void end(T info);

    /**
     * 忽略情况
     * @param alarmInfo
     */
    void ingore(T alarmInfo);

}
