package com.wjq.monitor.domain;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public  class DefaultMonitorAttribute extends DefaultMonitorDefinition implements MonitorAttribute {


    private MonitorConfig monitorConfig;



    /**
     * 忽略code，认为是正常code
     *
     * @param code
     * @return
     */
    @Override
    public boolean ingoreCode(String code) {
        return false;
    }
}
