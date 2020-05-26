package com.test.wjq.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class TestJson {


    public static void main(String[] args) {


      ModelClass modelClass =  new ModelClass<Model>();
        System.out.println(modelClass.get());

    }




    static class Model{

        private Integer id;

        private String name;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Model{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    static class ModelClass<R>{


       public R get(){
           String str = "{'id':1,'name':'hahah'}";
            return JSON.parseObject(str,new  TypeReference<R>(){}.getType());
        }

    }



}
