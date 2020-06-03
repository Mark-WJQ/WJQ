package com.wjq.monitor.execute;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wangjianqiang24
 * @date 2020/6/2
 */
@SpringBootTest(classes = {TestAop.class})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
public class TestAopTest {

    @Autowired
    private TestAop testAop;

    @Test
    public void monitor() {

        testAop.t1();
    }
}