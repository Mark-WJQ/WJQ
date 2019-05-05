package com.test.wjq;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/17.
 */
public class test {

    private static final String NODE_SMS_PLACEHOLDER_CONDITION = "condition";
    private static final String PLACEHOLDER_LEFT_BORDER_REGEX = "\\{";
    private static final String PLACEHOLDER_RIGHT_BORDER_REGEX = "\\}";


    private String getExecuteSql(String condition, Map<String, Object> keyValueParams) {
        String sql = condition;
        Matcher m = Pattern.compile(PLACEHOLDER_LEFT_BORDER_REGEX + "(.*?)" + PLACEHOLDER_RIGHT_BORDER_REGEX).matcher(sql);
        while (m.find()) {
            String name = m.group(1);
            Object realValue = keyValueParams.get(name.trim());
            sql = sql.replaceFirst(PLACEHOLDER_LEFT_BORDER_REGEX + name + PLACEHOLDER_RIGHT_BORDER_REGEX, realValue == null ? "" : realValue.toString());
        }
        return sql;
    }

    public static  <T> void testMethod(Integer s){
        System.out.println((T)s);
    }

    public static void main(String[] args){
       /*test service = new test();
        String sql = "select *　from mcc where id = {id} and name = {name}";
        Map keyMap = new HashMap();
        keyMap.put("id","1000");
        keyMap.put("name","1000");
        System.out.println(service.getExecuteSql(sql,keyMap));*/
        //testMethod(1);
      //System.out.println(new Integer(1) != 1);
       // HttpRequest.post("").trustAllCerts();

    }



}
class repayment{

    int a;
    int b;
    repayment(int a,int b){
        this.a = a;
        this.b = b;
    };
}
