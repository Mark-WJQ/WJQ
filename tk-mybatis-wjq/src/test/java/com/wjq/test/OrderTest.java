package com.wjq.test;

import com.wjq.order.service.impl.TestTableService;
import com.wjq.tk.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangjianqiang on 2019/1/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationConfig.class})
public class OrderTest {

    @Autowired
    TestTableService testTableService;
    @Test
    public void test(){

        testTableService.update();

}



}
