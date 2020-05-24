package com.wjq.monitor.alarm;

import java.lang.reflect.Method;

public interface AlarmSupport {

    /**
     * 获取报警信息组成信息,
     * 有异常自己内部处理不要抛出来
     * 如果返回空则不记录信息
     * @param method 当前执行方法
     * @param targetClass 该方法所属的类
     *
     * @return
     */
    AlarmInfo getAlarmInfo(Method method,Class targetClass);

    /**
     * 记录可用率
     * @param info 可用率信息
     */
    void functionError(AlarmInfo info);

    /**
     * 报警
     * @param info 报警信息
     */
    void alarm(AlarmInfo info);

    /**
     * 结束记录
     * @param info
     */
    void end(AlarmInfo info);

}
