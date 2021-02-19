package com.wjq.encrypt;

/**
 * 返回参数
 */
public class Response implements Result {

	private boolean success;
	private String code;
	private String info;
	private boolean encrypted;
	private String data;
	private String key;
	private long timestamp;
	private String sign;

	void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 执行结果
	 * @return
	 */
	@Override
	public boolean getSuccess() {
		return success;
	}

	/**
	 * 执行结果描述
	 * @return
	 */
	@Override
	public String getInfo() {
		return info;
	}

	public String getCode() {
		return code;
	}

	void setCode(String code) {
		this.code = code;
	}


	void setInfo(String info) {
		this.info = info;
	}

	boolean isEncrypted() {
		return encrypted;
	}

	void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

	String getData() {
		return data;
	}

	void setData(String data) {
		this.data = data;
	}

	String getKey() {
		return key;
	}

	void setKey(String key) {
		this.key = key;
	}

	long getTimestamp() {
		return timestamp;
	}

	void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	String getSign() {
		return sign;
	}

	void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"success\":")
				.append(success);
		sb.append(",\"code\":")
				.append(code);
		sb.append(",\"desc\":\"")
				.append(info).append('\"');
		sb.append(",\"encrypted\":")
				.append(encrypted);
		sb.append(",\"data\":\"")
				.append(data).append('\"');
		sb.append(",\"key\":\"")
				.append(key).append('\"');
		sb.append(",\"timestamp\":")
				.append(timestamp);
		sb.append(",\"sign\":\"")
				.append(sign).append('\"');
		sb.append("}");
		return sb.toString();
	}
}
