package com.wjq.encrypt;

import java.util.TreeMap;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author wangjianqiang24
 * @date 2020/9/10
 */
public class RequestUtils {

	private static final String SUCCESS = "success";
	private static final String CODE = "code";
	private static final String DESC = "desc";
	private static final String DATA = "data";
	private static final String ENCRYPTED = "encrypted";
	private static final String KEY = "key";
	private static final String TIMESTAMP = "timestamp";
	private static final String VERSION = "version";
	private static final String PARAMS = "params";
	private static final String METHOD = "method";
	private static final String SIGN = "sign";
	private static final String COMPRESSED = "compressed";
	private static final String REQUEST_ID = "requestId";
	private static final String APP_ID = "appId";


	private static Gson gson = new GsonBuilder().create();

	public static RequestParams parse(String requestBody) {
		RequestParams request = gson.fromJson(requestBody, RequestParams.class);
		return request;
	}

	/**
	 * 验签
	 * @param publicKey  公钥
	 * @param params 验签参数
	 * @return
	 */
	public static boolean verifySign(String publicKey,RequestParams params) {
		//use tree map to sort key
		TreeMap<String, Object> paramsMap = new TreeMap<>();
		paramsMap.put(APP_ID, params.getAppId());
		paramsMap.put(KEY, params.getKey());
		paramsMap.put(TIMESTAMP, params.getTimestamp());
		paramsMap.put(REQUEST_ID, params.getRequestId());
		paramsMap.put(COMPRESSED, params.isCompressed());
		paramsMap.put(METHOD, params.getMethod());
		paramsMap.put(PARAMS, params.getParams());
		paramsMap.put(VERSION, params.getVersion());
		paramsMap.put(ENCRYPTED,params.isEncrypted());
		String content = paramsMap.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
				.collect(Collectors.joining("&"));
		return RSAUtils.verifySignByPublicKey(content,SIGN , publicKey);
	}


	/**
	 * 加签
	 * @param privateKey 秘钥
	 * @param response 被加签数据
	 * @return
	 */
	public static void signByPrivateKey(String privateKey,Response response) {
		TreeMap<String, Object> map = new TreeMap<>();
		map.put(SUCCESS, response.getSuccess());
		map.put(CODE, response.getCode());
		if (response.getInfo() != null) {
			map.put(DESC, response.getInfo());
		}
		if (response.getData() != null) {
			map.put(DATA, response.getData());
		}
		if (response.getKey() != null) {
			map.put(KEY, response.getKey());
		}
		map.put(ENCRYPTED, response.isEncrypted());
		map.put(TIMESTAMP, response.getTimestamp());
		String content = map.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
		String sign = RSAUtils.signByPrivateKey(content,privateKey);
		response.setSign(sign);
	}
}
