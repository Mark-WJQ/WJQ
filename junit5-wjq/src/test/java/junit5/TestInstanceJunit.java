package junit5;

import com.wjq.junit5.TestBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

//测试实例的创建
//@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@Execution(CONCURRENT)
public class TestInstanceJunit {



    private TestBean tb;

    @BeforeEach
    public void testbe(){

        tb = new TestBean();

    }



    @BeforeAll
    public static void testba(){
        System.out.println("------");
    }


    @Test
    public void t1(){
        System.out.println(this);
        System.out.println(tb);
        System.out.println(Thread.currentThread().getId());

    }



    @Test
    public void t2(){
        System.out.println(this);
        System.out.println(tb);
        System.out.println(Thread.currentThread().getId());
    }


}
