package com.wjq.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by wangjianqiang on 2018/11/24.
 */
@ComponentScan(value = "com.wjq.mvc",includeFilters = {@ComponentScan.Filter(value = {Controller.class})},useDefaultFilters = false)
@Component
public class WebConfig {
}
