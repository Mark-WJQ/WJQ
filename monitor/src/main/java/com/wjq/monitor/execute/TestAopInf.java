package com.wjq.monitor.execute;

import com.wjq.monitor.annotation.Monitor;
import com.wjq.monitor.result.Result;

import java.util.Collection;

/**
 * @author wangjianqiang24
 * @date 2020/6/2
 */

public interface TestAopInf<T extends Collection> {
     @Monitor
     Result monitor(T t);

}
