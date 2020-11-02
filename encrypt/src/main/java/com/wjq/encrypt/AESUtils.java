package com.wjq.encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AES加解密工具
 */
public class AESUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(AESUtils.class);
  public static final String KEY_ALGORITHM = "AES";
  public static final String ENCODING = "utf-8";

  /**
   * 生成AES key
   * @return
   */
  public static String generateAESKey() {
    KeyGenerator keyGenerator = null;
    try {
      keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
    keyGenerator.init(128);
    SecretKey key = keyGenerator.generateKey();
    byte[] keyExternal = key.getEncoded();
    return Base64.encodeBase64String(keyExternal);
  }

  /**
   * 加密
   * @param content 被加密内容
   * @param key aes 密钥
   * @return
   */
  public static String encrypt(String content, String key) {
    try {
      byte[] bytesKey = Base64.decodeBase64(key);
      SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
      Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
      byte[] byteContent = content.getBytes(ENCODING);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);// 初始化
      byte[] result = cipher.doFinal(byteContent);// 加密
      return Base64.encodeBase64String(result);
    } catch (Exception e) {
      LOGGER.error("encrypt error", e);
    }
    return null;
  }

  /**
   * 解密
   * @param content 被解密内容
   * @param key aes 密钥
   * @return
   */
  public static String decrypt(String content, String key) {
    try {
      byte[] bytesKey = Base64.decodeBase64(key);
      SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
      Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
      cipher.init(Cipher.DECRYPT_MODE, secretKey);// 初始化
      byte[] result = cipher.doFinal(Base64.decodeBase64(content));// 解密
      return new String(result);
    } catch (Exception e) {
      LOGGER.error("decrypt error", e);
    }
    return null;
  }
}
