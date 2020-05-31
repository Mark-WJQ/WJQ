package com.wjq.monitor.domain;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class AlarmRuleAttribute implements Serializable {
    private static final long serialVersionUID = -237713387061716158L;

    /**
     * 异常名
     */
    private String exceptionName;

    public AlarmRuleAttribute(String exceptionName) {
        Assert.hasText(exceptionName, "'exceptionName' cannot be null or empty");
        this.exceptionName = exceptionName;
    }


    public AlarmRuleAttribute(Class<? extends Throwable> clazz) {
        Assert.notNull(clazz, "'clazz' cannot be null");
        if (!Throwable.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(
                    "Cannot construct alarms rule from [" + clazz.getName() + "]: it's not a Throwable");
        }
        this.exceptionName = clazz.getName();
    }

   public int rule(Throwable e){

        return 0;
    }




}
