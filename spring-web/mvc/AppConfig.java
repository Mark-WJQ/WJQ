package com.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wangjianqiang on 2018/11/24.
 */
@EnableWebMvc
@ComponentScan(excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class AppConfig implements WebMvcConfigurer {
}
