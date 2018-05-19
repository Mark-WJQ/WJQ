package com.wjq.JSONTest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import lombok.Data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by wangjianqiang on 2017/8/7.
 */

@Data
public class JsonAnnotation {
    @JSONField(name = "Name")
    private String name;
    @JSONField(name = "SEX")
    private String sex;
    @JSONField(name = "Age")
    private int age;
    @JSONField(format = "yyyy-MM-dd")
    private Date  date;

    private Map<String,Object> attributes = new HashMap<String, Object>();



    private String classStr;


    public Map<String, Object> getAttributes() {
        return attributes;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClassStr() {
        return classStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }



    static ExtraProcessor processor = new ExtraProcessor() {
        public void processExtra(Object o, String key, Object value) {
            JsonAnnotation jsonAnnotation = (JsonAnnotation)o;
            jsonAnnotation.getAttributes().put(key,value);

        }
    };


    public static void main(String[] args) throws IOException {

        String jsStr = "[{\"name\":\"wang\",\"SEX\":\"女\",\"date\":\"2017-08-07 12:23:23\",\"kkkk\":\"ssss\"}]";
        JsonAnnotation ja = new JsonAnnotation();
        ja.age = 5;
        ja.setDate(new Date());
        System.out.println(ja.getDate());
        ja.setName("ssss");
        List<JsonAnnotation> lja = new ArrayList<JsonAnnotation>();
        lja.add(ja);
        lja.add(ja);
        Type type = new TypeReference<List<JsonAnnotation>>(){}.getType();
        List<JsonAnnotation> list = JSONObject.parseObject(jsStr,type);
        System.out.println(list);

        System.out.println("-------------------------------------");
        Object  o = JSONPath.eval(lja,"$[0].date");

        System.out.println(o);
        System.out.println(JSONPath.eval(ja,"$.Name"));
        System.out.println(JSONPath.paths(ja));

        System.out.println(JSONPath.size(ja,"$['Name','SEX']"));
        JSONPath.set(ja,"$.Age",16);
        System.out.println(ja.getAge());


        System.out.println(JSONPath.eval(lja,"$[:-1].Name"));

       Map<String,String> map = Collections.singletonMap("ddd","ddd");
      // map.put("aaa","sss");
        System.out.println(map);

        FileOutputStream fos = new FileOutputStream("/Users/wangjianqiang/test.txt");
        JSONObject.writeJSONString(fos,ja);

        System.out.println("=============处理多余字段===================");
        JsonAnnotation jj = JSONObject.parseObject("{\"name\":\"wang\",\"SEX\":\"女\",\"date\":\"2017-08-07 12:23:23\",\"kkkk\":\"ssss\",\"aaaaaaaa\":\"ffffff\"}",JsonAnnotation.class,processor);
        System.out.println(jj);


    }




}


class MyExtraProcessor implements ExtraProcessor,ExtraTypeProvider{

    public void processExtra(Object o, String key, Object value) {

    }

    public Type getExtraType(Object o, String key) {
        return null;
    }
}

