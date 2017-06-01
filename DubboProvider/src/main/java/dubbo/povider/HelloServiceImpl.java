package dubbo.povider;

import dubbo.common.HelloService;

/**
 * Created by Administrator on 2016/11/18.
 */
public class HelloServiceImpl implements HelloService {

    public void sayHello() {
        System.out.println("这里是provider" );
        System.out.println("hello provider");
    }
}
