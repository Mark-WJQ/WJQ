package com.wjq.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangjianqiang on 2018/11/24.
 */
@RestController
@RequestMapping("/test")
public class TestController {


    static Queue<DeferredResult> queue = new LinkedList<>();

    @RequestMapping("/hello")
    @ResponseBody
    @Autowired
    public String hello(){

        DeferredResult<String> deferredResult = new DeferredResult<>();
        queue.add(deferredResult);

        return "hello world=====";
    }



    @RequestMapping("/world")
    @ResponseBody
    public String world(){

        queue.poll().setResult("hahahhahahah");
        return "hello world=================";
    }

}
