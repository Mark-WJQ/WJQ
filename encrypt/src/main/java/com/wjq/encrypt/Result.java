package com.wjq.encrypt;

/**
 * 返回结果接口
 * @author wangjianqiang24
 * @date 2020/9/10
 */
public interface Result {

	/**
	 * 执行结果
	 * @return
	 */
	boolean getSuccess();

	/**
	 * 执行结果描述
	 * @return
	 */
	String getInfo();

	/**
	 * 获取结果 code
	 * @return
	 */
	String getCode();

}
