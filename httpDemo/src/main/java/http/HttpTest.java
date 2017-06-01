package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/1.
 */
public class HttpTest {

    private static Logger log = LoggerFactory.getLogger(HttpTest.class);
    private static final String CHARSET = "UTF-8";
    private static final int TIME_OUT = 60000;
    //private static final String salt = "c8353bdce7bb7371eec9bac721edf49b";
    private static final String salt = "676c4f4f3b910eb639de0dacde085f97";
   // private static final String channel = "MDTX";
    private static final String channel = "MDTX0001";







    public static void main(String[] args){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderno","MDTX2017052742700889233");
       //jsonObject.put("approveResult","success");
       /* jsonObject.put("approveResult","fail");
        jsonObject.put("errorCode","0001");
        jsonObject.put("errorDescription","逾期率变化");*/

      /*  jsonObject.put("payResult","fail");
        jsonObject.put("errorCode","0001");
        jsonObject.put("errorDescription","放款失败");
        jsonObject.put("errorDescription","任性");*/

        jsonObject.put("payResult","success");
        jsonObject.put("repayments","[{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-06-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":1,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-07-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":2,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-08-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":3,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-09-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":4,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-10-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":5,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-11-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":6,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-07-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":7,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-08-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":8,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-09-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":9,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-10-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":10,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0},{\"realAmount\":0,\"overdueAmount\":0,\"shouldDate\":\"2017-11-25\",\"remainAmount\":61.47,\"overdueDay\":0,\"periods\":11,\"repaymentStatus\":0,\"shouldAmount\":61.47,\"historyIsOverdue\":0}]");
       /* jsonObject.put("loanAmount","1275");
        jsonObject.put("loanDate","2017-03-09 18:43:19");
        jsonObject.put("orderno","93214890561991616");
        jsonObject.put("periods","1");
        jsonObject.put("periodsAmount","1500");
        jsonObject.put("status","2");
        jsonObject.put("token","86cc1ff6b7523754c47aa776b0664981");
        jsonObject.put("addTime","2017-03-09 18:43:19");
        jsonObject.put("cardNum","10000000000000");
        jsonObject.put("name","测试");
        jsonObject.put("phone","18885456987");
        List<JSONObject> js = new ArrayList<JSONObject>();
        js.add(jsonObject);*/
        String jsonData = JSONObject.toJSONString(jsonObject);

        System.out.println(jsonData);

        String sign =  MD5Util.convertMD5(jsonData,salt);
        System.out.println(sign);
        NameValuePair[] nameValuePairs = new NameValuePair[3];
        nameValuePairs[0] = new NameValuePair("sign",sign);
        nameValuePairs[1] = new NameValuePair("jsonData",jsonData);
        nameValuePairs[2] = new NameValuePair("channel",channel);
        String url = "";
       // System.out.println(postUrl(url,nameValuePairs));
    }


    //post请求
    public static String postUrl(String url, NameValuePair[] data) {
        HttpClient client = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
        PostMethod postMethod = null;
        String responseBody = null;
        BufferedReader br = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestBody(data);
            postMethod.getParams().setParameter(
                    HttpMethodParams.HTTP_CONTENT_CHARSET, CHARSET);

            client.getHttpConnectionManager().getParams()
                    .setConnectionTimeout(TIME_OUT);
            client.getHttpConnectionManager().getParams().setSoTimeout(TIME_OUT);
            int httpStatus = client.executeMethod(postMethod);
            if (httpStatus != HttpStatus.SC_OK) {
               log.info("错误信息",url);
            }
            log.info("请求url:{}-->返回状态码:{}",url,httpStatus);
            br = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream()));
            StringBuffer result = new StringBuffer();
            String line;
            while( (line = br.readLine()) != null){
                result.append(line);
            }
            responseBody = result.toString();
        } catch (Exception e) {
            log.error("postUrl请求url:{},错误信息:{}", e);
            e.printStackTrace();

        } finally {
            try {
                if(br != null)
                    br.close();
                if(postMethod != null)
                    postMethod.releaseConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;

    }




}
