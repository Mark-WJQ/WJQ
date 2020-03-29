package junit5;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestNested {

    @Test
    public void t1(){

    }


    //嵌套测试
    @Nested
    class TN1{


        @Test
        public void t2(){
            System.out.println("-----------");
        }





    }

}
