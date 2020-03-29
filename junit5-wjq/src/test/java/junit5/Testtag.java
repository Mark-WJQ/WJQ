package junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Tags({@Tag("g1"),@Tag("g2")})
public class Testtag {

    @Tag("gg")
    @Test
    public void t1(){
        System.out.println("----------------");
    }


    @Tag("g1")
    @Test
    public void t2(){
        System.out.println("---------------1-");
    }


}
