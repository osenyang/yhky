package com.elink.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;


public class ArchivesPushUtils {
	
	protected static final String host = Global.getConfig("swap_host");//  "http://community.nug-hospital.com";	

	protected final JSONObject rootJson = new JSONObject();
	
	// The post path
	protected static final String postPath = Global.getConfig("swap_post_path");// "/admin/ws/healthArchives/submitHealthArchives";
	
	// http://community.nug-hospital.com/admin/ws/healthArchives/submitHealthArchives?birthDate=1951-01-15&height=178&tel=15272376455&idCard=653121195101150432&photo=http%3A%2F%2F123.56.42.172%3A81http%3A%2F%2F123.56.42.172%3A81%2FhealthArchives%2F2015%2F09%2Fcd8697893f78424cba844a261de6ecf2_small.jpg&village=110101008&province=110000&bloodType=A%E5%9E%8B&id=cb1bfd5445304948a7b6961694f0c745&nativePlace=130000&district=110101&maritalStatus=%E5%B7%B2%E5%A9%9A&fullNm=%E6%9E%97%E6%9D%B0&sex=%E7%94%B7&appMark=zhanjiang&address=%E5%AE%89%E5%B1%85%E8%8B%91&city=110100

	protected final String USER_AGENT = "Mozilla/5.0";
	
	protected HttpClient client = new DefaultHttpClient();	
	
	public boolean setKeyValue(String key, Object value) throws Exception {	
		rootJson.put(key, value);
		return true;
	}
	
	public boolean send() throws Exception {
        String url = host + postPath;
        String postBody = rootJson.toString();
        String sign = DigestUtils.md5Hex(("POST" + url + postBody).getBytes("utf8"));
        url = url + "?sign=" + sign;
        Iterator it = rootJson.keys();  
        while (it.hasNext()) {  
            String key = (String) it.next();  
            String value = rootJson.getString(key);
            url += "&"+key+"="+value;       
        }  
        
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
//        StringEntity se = new StringEntity(postBody, "UTF-8");
//        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = client.execute(post);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + status);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
        if (status == 200) {
            System.out.println("传送成功.");
        } else {
            System.out.println("传送失败!");
        }
        return true;
    }
	
}
