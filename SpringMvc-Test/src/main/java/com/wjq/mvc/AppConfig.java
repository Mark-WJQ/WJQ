package com.wjq.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wangjianqiang on 2018/11/24.
 */

@ComponentScan(value = "com.wjq.mvc",excludeFilters = {@ComponentScan.Filter(value = {Controller.class})})
@EnableWebMvc
@Component
public class AppConfig implements WebMvcConfigurer{


}
