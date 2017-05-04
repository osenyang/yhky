package com.elink.hospitalhealthnurse.common.utils;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.elink.easemob.server.common.HTTPMethod;

/**
 * 调用第三方接口
 * @author eLink
 *
 */
public class HttpClient {

	/**
	 * 调用三方接口
	 * @param url
	 * @param dataBody
	 * @param method
	 * @return
	 */
	public static JSONObject httpClient(String url,List<NameValuePair> params,String method){
		JSONObject obj = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
        try {  
        	if(method.equals(HTTPMethod.METHOD_POST)){
        		 HttpPost httpPost = new HttpPost(url);  
                 System.out.println("executing request " + httpPost.getURI());  
                 httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                 response = httpclient.execute(httpPost);  
        	}else if(method.equals(HTTPMethod.METHOD_GET)){
	            HttpGet httpget = new HttpGet(url);  
	            System.out.println("executing request " + httpget.getURI());  
	            response = httpclient.execute(httpget);  
        	}
            try {  
                // 获取响应实体    
                HttpEntity entity = response.getEntity();  
                // 打印响应状态    
                System.out.println(response.getStatusLine()+" length:"+entity.getContentLength());  
                if (entity != null) {  
                    // 打印响应内容    
                    String str = EntityUtils.toString(entity, "UTF-8");
                    System.out.println(str);
					obj = new JSONObject(str);
                }  
                System.out.println("------------------------------------");  
            } catch (JSONException e) {
				e.printStackTrace();
            } finally {  
                response.close();  
            }
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return obj;
	}
	
}
