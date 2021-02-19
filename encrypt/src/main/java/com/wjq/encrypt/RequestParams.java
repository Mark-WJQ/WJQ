package com.wjq.encrypt;

public class RequestParams {
	private String appId;
	// 最终业务字段
	private String bizParams;
	private String key;
	private String aesKey;
	// 原始字段
	private String params;
	private String requestId;
	private String method;
	private String sign;
	private String version;
	private boolean compressed;
	private long timestamp;
	private boolean encrypted;


	String getAppId() {
		return appId;
	}

	void setAppId(String appId) {
		this.appId = appId;
	}

	String getBizParams() {
		return bizParams;
	}

	void setBizParams(String bizParams) {
		this.bizParams = bizParams;
	}

	String getKey() {
		return key;
	}

	void setKey(String key) {
		this.key = key;
	}

	String getAesKey() {
		return aesKey;
	}

	void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	String getParams() {
		return params;
	}

	void setParams(String params) {
		this.params = params;
	}

	String getRequestId() {
		return requestId;
	}

	void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	String getMethod() {
		return method;
	}

	void setMethod(String method) {
		this.method = method;
	}

	String getSign() {
		return sign;
	}

	void setSign(String sign) {
		this.sign = sign;
	}

	String getVersion() {
		return version;
	}

	void setVersion(String version) {
		this.version = version;
	}

	boolean isCompressed() {
		return compressed;
	}

	void setCompressed(boolean compressed) {
		this.compressed = compressed;
	}

	long getTimestamp() {
		return timestamp;
	}

	void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	boolean isEncrypted() {
		return encrypted;
	}

	void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"appId\":\"")
				.append(appId).append('\"');
		sb.append(",\"bizParams\":\"")
				.append(bizParams).append('\"');
		sb.append(",\"key\":\"")
				.append(key).append('\"');
		sb.append(",\"aesKey\":\"")
				.append(aesKey).append('\"');
		sb.append(",\"params\":\"")
				.append(params).append('\"');
		sb.append(",\"requestId\":\"")
				.append(requestId).append('\"');
		sb.append(",\"method\":\"")
				.append(method).append('\"');
		sb.append(",\"sign\":\"")
				.append(sign).append('\"');
		sb.append(",\"version\":\"")
				.append(version).append('\"');
		sb.append(",\"compressed\":\"")
				.append(compressed).append('\"');
		sb.append(",\"timestamp\":")
				.append(timestamp);
		sb.append(",\"encrypted\":")
				.append(encrypted);
		sb.append("}");
		return sb.toString();
	}
}
