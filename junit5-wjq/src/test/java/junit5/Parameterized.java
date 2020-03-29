package junit5;

import com.wjq.junit5.TestBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class Parameterized {

    @ParameterizedTest
    @ValueSource(strings = {"ddd","dddd"})
    public void parameter(String t1){

        Assertions.assertEquals("ddd",t1);
    }


   public static final TestBean t1 = new TestBean();

    @ParameterizedTest
    @ValueSource(classes = {TestBean.class,String.class})
    public void parameter(Class t1){

        System.out.println(t1.getCanonicalName());
    }


    @RepeatedTest(3)
    public void testRepeat(){
        System.out.println("--------");
    }

}
