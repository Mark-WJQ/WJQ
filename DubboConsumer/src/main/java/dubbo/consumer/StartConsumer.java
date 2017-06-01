package dubbo.consumer;

import dubbo.common.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/11/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/dubbo-consumer.xml")
public class StartConsumer {

    public HelloService getHelloService() {
        return helloService;
    }

    @Autowired
    HelloService helloService;

    @Test
    public void  test(){

        System.out.println("dubbo-consumer启动");
        helloService.sayHello();

    }
}
