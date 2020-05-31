package com.wjq.monitor.domain;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class DefaultMonitorDefinition implements MonitorDefinition {


   private String key;

    /**
     * 应用名
     */
    private String appName;

    /**
     * 主键前缀
     */
    private String keyPre;

    /**
     * 报警异常
     *
     * @return
     */
    private Class<? extends Throwable>[] alarms;

    /**
     * 记录可用率异常
     *
     * @return
     */
    private Class<? extends Throwable>[] error;


    /**
     * 忽略记录
     *
     * @return
     */
    private Class<? extends Throwable>[] ingoreErrors;


    /**
     * 报警code
     *
     * @return
     */
    private String[] alarmCodes;


    /**
     * 记录可用率code
     *
     * @return
     */
    private String[] errorCodes;


    /**
     * 忽略code
     *
     * @return
     */
    private String[] ingoreCodes;

    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setKeyPre(String keyPre) {
        this.keyPre = keyPre;
    }

    @Override
    public Class<? extends Throwable>[] getAlarms() {
        return alarms;
    }

    public void setAlarms(Class<? extends Throwable>[] alarms) {
        this.alarms = alarms;
    }

    @Override
    public Class<? extends Throwable>[] getError() {
        return error;
    }

    public void setError(Class<? extends Throwable>[] error) {
        this.error = error;
    }

    @Override
    public Class<? extends Throwable>[] getIngoreErrors() {
        return ingoreErrors;
    }

    public void setIngoreErrors(Class<? extends Throwable>[] ingoreErrors) {
        this.ingoreErrors = ingoreErrors;
    }

    @Override
    public String[] getAlarmCodes() {
        return alarmCodes;
    }

    public void setAlarmCodes(String[] alarmCodes) {
        this.alarmCodes = alarmCodes;
    }

    @Override
    public String[] getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(String[] errorCodes) {
        this.errorCodes = errorCodes;
    }

    @Override
    public String[] getIngoreCodes() {
        return ingoreCodes;
    }

    public void setIngoreCodes(String[] ingoreCodes) {
        this.ingoreCodes = ingoreCodes;
    }

    /**
     * 获取应用名字
     *
     * @return
     */
    @Override
    public String getAppName() {
        return this.appName;
    }

    /**
     * 获取报警key
     *
     * @return
     */
    @Override
    public String getKeyPre() {
        return this.keyPre;
    }
}
