package com.wjq.monitor.alarm;

import com.wjq.monitor.domain.Result;

/**
 * 报警注册参数
 */
public interface AlarmInfo {

    /**
     * 设置报警信息
     */
    void setResult(Result info);

    /**
     * 异常传递
     * @param t
     */
    void setException(Throwable t);





}
