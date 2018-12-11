import com.glassdoor.planout4j.planout.ops.random.PlanOutOpRandom;

import java.util.Map;

/**
 * Created by wangjianqiang on 2018/6/2.
 */
public class Test1 extends PlanOutOpRandom {
    protected Test1(Map args) {
        super(args);
    }

    protected Object simpleExecute() {
        return null;
    }
}

interface T1{

     int get();

}

