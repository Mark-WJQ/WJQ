package com.wecash.wjq.controller;

import com.alibaba.fastjson.JSON;
import com.wecash.wjq.service.UserService;
import com.wecash.wjq.service.serviceImpl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/11/17.
 */

@Controller
@RequestMapping("/firstClass")
public class FirstClass {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/firstMethod",method = RequestMethod.POST)
    @ResponseBody
    public String firstMethod(@RequestParam("userName") String userNAme){
        Long id = userService.getIdByName(userNAme);

            return JSON.toJSONString(id);
    }
}
