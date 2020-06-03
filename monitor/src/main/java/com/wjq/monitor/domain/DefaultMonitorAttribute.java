package com.wjq.monitor.domain;

import java.util.Objects;

/**
 * 默认监控属性处理
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class DefaultMonitorAttribute extends DefaultMonitorDefinition implements MonitorAttribute {

    /**
     * 是否合并配置
     */
    private boolean mergeConfig;

    @Override
    public boolean ingoreError(Throwable t) {
        return compute(t, this.getIngoreErrors());
    }


    @Override
    public boolean error(Throwable t) {
        if (Objects.isNull(getErrors()) || getErrors().length == 0){
            return true;
        }
        return compute(t, getErrors());
    }

    @Override
    public boolean alarm(Throwable t) {
        return compute(t, getAlarms());
    }

    /**
     * 匹配异常
     * @param t
     * @param errors
     * @return
     */
    protected boolean compute(Throwable t, Class<? extends Throwable>[] errors) {
        if (Objects.isNull(errors) || errors.length == 0){
            return false;
        }
        for (Class<? extends Throwable> c : errors) {
            if (c.isAssignableFrom(t.getClass())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean ingoreCode(String code) {
        return computeCode(code,getIngoreCodes());
    }

    @Override
    public boolean errorCode(String code) {
        if (Objects.isNull(getErrorCodes()) || getErrorCodes().length == 0){
            return true;
        }
        return computeCode(code,getErrorCodes());
    }

    @Override
    public boolean alarmCode(String code) {
       return computeCode(code,getAlarmCodes());
    }

    /**
     * 匹配结果码
     * @param code
     * @param codes
     * @return
     */
    protected boolean computeCode(String code, String[] codes) {
        if (Objects.isNull(codes) || codes.length == 0){
            return false;
        }

        for (String c : codes) {
            if (c.equals(code)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 是合并配置信息
     *
     * @return
     */
    @Override
    public boolean mergeConfig() {
        return mergeConfig;
    }


    public void setMergeConfig(boolean mergeConfig) {
        this.mergeConfig = mergeConfig;
    }
}
