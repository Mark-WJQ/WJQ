package junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

public class TestFactoryJunit {


    //批量验证

    /**
     *
     * @return 必须是DynamicNode及其子类的可遍历类型，Collection，Stream,Iterable
     */
    @TestFactory
    public List<DynamicNode> test(){
        return Arrays.asList(DynamicTest.dynamicTest("test Factory",()->{
                Assertions.assertEquals(100,100);
        }));
    }
}
