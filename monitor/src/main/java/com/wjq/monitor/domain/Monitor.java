package com.wjq.monitor.domain;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Monitor{


    /**
     * 唯一标识
     * @return
     */
    String key();

    /**
     * 报警异常
     * @return
     */
    Class<? extends  Throwable>[] alarm() default {};

    /**
     * 记录可用率异常
     * @return
     */
    Class<? extends  Throwable>[] error() default {};


    /**
     * 忽略记录
     * @return
     */
    Class<? extends  Throwable>[] ingoreError() default {};


    /**
     * 报警code
     * @return
     */
    String[] alarmCodes() default {};


    /**
     * 记录可用率code
     * @return
     */
    String[] errorCodes() default {};


    /**
     * 忽略code
     * @return
     */
    String[] ingoreCodes();



}
