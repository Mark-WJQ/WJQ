package com.wjq.encrypt;


import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RSA 操作工具
 */
public class RSAUtils {

	private static Logger log = LoggerFactory.getLogger(RSAUtils.class);

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
	public static final String ENCODING = "utf-8";
	public static final String X509 = "X.509";

	/**
	 * 获取公钥
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String key) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	/**
	 * 获取私钥
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String key) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(key.getBytes(ENCODING));
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}

	/**
	 * RSA私钥签名
	 *
	 * @param content    待签名数据
	 * @param privateKey 私钥
	 * @return 签名值
	 */
	public static String signByPrivateKey(String content, String privateKey) {
		try {
			PrivateKey priKey = getPrivateKey(privateKey);
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(priKey);
			signature.update(content.getBytes(ENCODING));
			byte[] signed = signature.sign();
			return new String(Base64.encodeBase64URLSafe(signed), ENCODING);
		}
		catch (Exception e) {
			log.warn("sign error, content: {}, priKey: {}", new Object[] {content, privateKey});
			log.error("sign error", e);
		}
		return null;
	}

	/**
	 * 公钥验签
	 * @param content 被前面内容
	 * @param sign 签名
	 * @param publicKey 公钥
	 * @return
	 */
	public static boolean verifySignByPublicKey(String content, String sign, String publicKey) {
		try {
			PublicKey pubKey = getPublicKey(publicKey);

			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initVerify(pubKey);
			signature.update(content.getBytes(ENCODING));

			return signature.verify(Base64.decodeBase64(sign.getBytes(ENCODING)));

		}
		catch (Exception e) {
			log.warn("sign error, content: {}, sign: {}, pubKey: {}", new Object[] {content, sign, publicKey});
			log.error("sign error", e);
		}
		return false;
	}


	/**
	 * 公钥加密
	 * @param plainText 被加密内容
	 * @param publicKey 公钥
	 * @return
	 */
	public static String encryptByPublicKey(String plainText, String publicKey) {
		try {
			PublicKey pubKey = getPublicKey(publicKey);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			byte[] enBytes = cipher.doFinal(plainText.getBytes(ENCODING));
			return Base64.encodeBase64String(enBytes);
		}
		catch (Exception e) {
			log.error("encrypt error", e);
		}
		return null;
	}

	/**
	 * 私钥加密
	 * @param enStr 加密内容
	 * @param privateKey 私钥
	 * @return
	 */
	public static String decryptByPrivateKey(String enStr, String privateKey) {
		try {
			PrivateKey priKey = getPrivateKey(privateKey);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			byte[] deBytes = cipher.doFinal(Base64.decodeBase64(enStr));
			return new String(deBytes);
		}
		catch (Exception e) {
			log.error("decrypt error", e);
		}
		return null;
	}

}
