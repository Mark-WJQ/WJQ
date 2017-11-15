package p2.com.wjq;

import com.wjq.innerclass.P1Inner;
import p1.com.wjq.OuterP1;

/**
 * Created by wangjianqiang on 2017/10/29.
 */
public class ThirdClass extends P1Inner {

    OuterP1 getP1 (){
        System.out.println(i);
        return new Inner();
    }

    public static void main(String[] args) {

    }

}
