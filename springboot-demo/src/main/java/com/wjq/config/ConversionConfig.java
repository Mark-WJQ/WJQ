package com.wjq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author wangjianqiang24
 * @date 2020/10/9
 */
@ConfigurationProperties(prefix = "conver")
public class ConversionConfig {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
