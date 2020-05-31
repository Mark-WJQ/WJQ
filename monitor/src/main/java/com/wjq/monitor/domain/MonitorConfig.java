package com.wjq.monitor.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.annotation.Annotation;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
@ConfigurationProperties(prefix = "monitor")
public class MonitorConfig {


    /**
     * 表达式
     */
    private String expression;


    /**
     * 注解类路径
     */
    private Class<? extends Annotation> annotation;


    private String appName;

    /**
     * 前缀
     */
    private String keyPre;


    /**
     * 报警异常
     */
    private Class<? extends Throwable>[] alarmExceptions;

    /**
     * 错误记录异常
     */
    private Class<? extends Throwable>[] errorExceptions;

    /**
     * 忽略异常
     */
    private Class<? extends Throwable>[] ingoreExceptions;

    /**
     * 错误code
     */
    private String[] errorCodes;

    /**
     * 报警code
     */
    private String[] alarmCodes;

    /**
     * 忽略code
     * 成功或幂等
     */
    private String[] ingoreCodes;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Class<? extends Annotation> getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getKeyPre() {
        return keyPre;
    }

    public void setKeyPre(String keyPre) {
        this.keyPre = keyPre;
    }

    public Class<? extends Throwable>[] getAlarmExceptions() {
        return alarmExceptions;
    }

    public void setAlarmExceptions(Class<? extends Throwable>[] alarmExceptions) {
        this.alarmExceptions = alarmExceptions;
    }

    public Class<? extends Throwable>[] getErrorExceptions() {
        return errorExceptions;
    }

    public void setErrorExceptions(Class<? extends Throwable>[] errorExceptions) {
        this.errorExceptions = errorExceptions;
    }

    public Class<? extends Throwable>[] getIngoreExceptions() {
        return ingoreExceptions;
    }

    public void setIngoreExceptions(Class<? extends Throwable>[] ingoreExceptions) {
        this.ingoreExceptions = ingoreExceptions;
    }

    public String[] getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(String[] errorCodes) {
        this.errorCodes = errorCodes;
    }

    public String[] getAlarmCodes() {
        return alarmCodes;
    }

    public void setAlarmCodes(String[] alarmCodes) {
        this.alarmCodes = alarmCodes;
    }

    public String[] getIngoreCodes() {
        return ingoreCodes;
    }

    public void setIngoreCodes(String[] ingoreCodes) {
        this.ingoreCodes = ingoreCodes;
    }
}
