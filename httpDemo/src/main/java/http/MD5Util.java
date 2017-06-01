package http;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MD5Util {

    private static final String CHARSET = "UTF-8";

    public static String convertMD5(String content,String salt) {
        return convertMD5(content,CHARSET,salt);
    }

    public static String convertMD5(String content, String charset,String salt) {
        content = content + salt;
        MessageDigest md5 = null;
        StringBuffer hexValue = new StringBuffer();
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = content.getBytes(charset);
            byte[] md5Bytes = md5.digest(byteArray);

            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        return hexValue.toString();
    }
}
