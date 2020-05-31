package com.wjq.monitor.domain;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjianqiang24
 * @date 2020/5/29
 */
public class RuleBasedMonitorAttribute extends DefaultMonitorAttribute {


    private List<AlarmRuleAttribute> alarmRules;

    private List<AlarmRuleAttribute> errorRules;

    private List<AlarmRuleAttribute> ingoreRules;





    @Override
    public boolean alarm(Throwable t) {
        AlarmRuleAttribute winner = compute(t, alarmRules);
        if (winner == null) {
            return super.alarm(t);
        }
        return true;
    }

    private AlarmRuleAttribute compute(Throwable t, List<AlarmRuleAttribute> rules) {
        AlarmRuleAttribute winner = null;
        if (!CollectionUtils.isEmpty(rules)) {
            int deepest = Integer.MAX_VALUE;
            for (AlarmRuleAttribute rule : alarmRules) {
                int depth = rule.rule(t);
                if (depth >= 0 && depth < deepest) {
                    winner = rule;
                    deepest = depth;
                    break;
                }
            }
        }
        return winner;
    }

    @Override
    public boolean error(Throwable t) {
        AlarmRuleAttribute winner = compute(t, errorRules);
        if (winner == null) {
            return super.alarm(t);
        }
        return true;
    }

    @Override
    public boolean ingoreError(Throwable t) {
        AlarmRuleAttribute winner = compute(t, ingoreRules);
        if (winner == null) {
            return super.alarm(t);
        }
        return true;
    }

    @Override
    public boolean ingoreCode(String code) {
        for (String c : getIngoreCodes()) {
            if (c.equals(code)) {
                return true;
            }
        }
        return super.ingoreCode(code);
    }

    @Override
    public boolean errorCode(String code) {
        for (String c : getErrorCodes()) {
            if (c.equals(code)) {
                return true;
            }
        }

        return super.errorCode(code);
    }

    @Override
    public boolean alarmCode(String code) {
        for (String c : getAlarmCodes()) {
            if (c.equals(code)) {
                return true;
            }
        }
        return super.errorCode(code);
    }


    @Override
    public void setIngoreErrors(Class<? extends Throwable>[] ingoreErrors) {
        super.setIngoreErrors(ingoreErrors);
        if (ingoreErrors != null && ingoreErrors.length > 0) {
            this.ingoreRules = new ArrayList<>(ingoreErrors.length);
            for (Class clazz : ingoreErrors) {
                AlarmRuleAttribute rule = new AlarmRuleAttribute(clazz);
                this.ingoreRules.add(rule);
            }
        }
    }

    @Override
    public void setAlarms(Class<? extends Throwable>[] alarms) {
        super.setAlarms(alarms);
        if (alarms != null && alarms.length > 0) {
            this.alarmRules = new ArrayList<>(alarms.length);
            for (Class clazz : alarms) {
                AlarmRuleAttribute rule = new AlarmRuleAttribute(clazz);
                alarmRules.add(rule);
            }
        }
    }

    @Override
    public void setError(Class<? extends Throwable>[] error) {
        super.setError(error);
        if (error != null && error.length > 0) {
            this.errorRules = new ArrayList<>(error.length);
            for (Class clazz : error) {
                AlarmRuleAttribute rule = new AlarmRuleAttribute(clazz);
                this.errorRules.add(rule);
            }
        }
    }
}
