package com.wjq.monitor.domain;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public abstract class AbstractMonitorAttribute implements MonitorAttribute {


    private MonitorConfig monitorConfig;




    public AbstractMonitorAttribute(MonitorConfig monitorConfig) {
        this.monitorConfig = monitorConfig;
    }

    @Override
    public boolean alarm(Throwable t) {
       Class<? extends Throwable>[] alarms = getAlarms();

       for (Class<? extends Throwable> clazz : alarms){


          if (t instanceof RuntimeException){

          }
       }
        return false;
    }
}
