import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/**
 * Created by wangjianqiang on 2017/11/15.
 */
public class DubboTest {


    @Test
    public void test(){
       List<String> list = mock((new ArrayList<String>()).getClass());

        Mockito.when(list.get(0)).thenReturn("hello");

        System.out.println(list.get(0));

        //Assert.assertEquals(list.get(0),"hello1");
        //校验之前mock对象之前执行过的方法
        Mockito.verify(list,times(1)).get(0);

    }


    @Test
    public void t1(){


    }


}
