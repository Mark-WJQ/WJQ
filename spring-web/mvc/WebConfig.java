package com.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by wangjianqiang on 2018/11/24.
 */
@ComponentScan(includeFilters = {@ComponentScan.Filter(Controller.class)},useDefaultFilters = false)
public class WebConfig {
}
