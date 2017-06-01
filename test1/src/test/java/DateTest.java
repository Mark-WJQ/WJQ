import com.wecash.wjq.enump.EnumTest;

import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Created by Administrator on 2016/12/26.
 */
public class DateTest {

    public static void main(String[] args){

        EnumMap<EnumTest,String> enumMap = new EnumMap<EnumTest, String>(EnumTest.class);

        for(WeekDayEnum day : EnumSet.range(WeekDayEnum.Mon, WeekDayEnum.Fri)) {
            System.out.println(day);
        }


        Date date = new Date(1482717585917L);
        System.out.println(date);
    }




}

enum WeekDayEnum { Mon, Tue, Wed, Thu, Fri, Sat, Sun }

