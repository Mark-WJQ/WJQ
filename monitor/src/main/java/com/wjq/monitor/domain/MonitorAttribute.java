package com.wjq.monitor.domain;

/**
 * 监控类型属性
 */
public interface MonitorAttribute extends MonitorDefinition {

    /**
     * 报警异常
     * @return
     */
    boolean alarm(Throwable t);

    /**
     * 记录可用率异常
     * @return
     */
    boolean error(Throwable t);


    /**
     * 忽略异常
     * @param t
     * @return
     */
    boolean ingoreError(Throwable t);

    /**
     * 报警code
     * @return
     */
    boolean alarmCodes(String code);


    /**
     * 记录可用率code
     * @return
     */
    boolean errorCodes(String code);


}
