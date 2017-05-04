package com.elink.hospitalhealthnurse.common.utils;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.UUID;

import org.activiti.engine.impl.util.json.JSONArray;

public class SmsUtils {
	
	public static final int TRY_TIMES = 3;
	public static final int TIME_OUT = 1000;
	
	
	public static boolean fetchToSendSMS(String mobile, String password,
            String[] friends, String message) {
        // 加上UUID的目的是防止这样的情况，在服务器上已经成功发送短信，却在返回结果过程中遇到错误，
        // 而导致客户端继续尝试请求，此时让服务器根据UUID分辨出该请求已经发送过，避免再次发送短信。
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < TRY_TIMES; i++) {
             int responseCode = 0;
            try {
                URL postUrl = new URL("https://fetionlib.appspot.com/restlet/fetion");
                HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
                connection.setConnectTimeout(TIME_OUT);
                connection.setReadTimeout(TIME_OUT);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setUseCaches(false);
                connection.setInstanceFollowRedirects(true);
                connection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
                connection.connect();
                DataOutputStream out = new DataOutputStream(connection
                        .getOutputStream());
                String content = "mobile=" + mobile + "&uuid=" + uuid
                        + "&password=" + password + "&friend=" + convertArrayToJSONString(friends)
                        + "&message=" + URLEncoder.encode(message, "utf-8");
                out.writeBytes(content);

                out.flush();
                out.close();

                responseCode = connection.getResponseCode();
                connection.disconnect();
                if (responseCode == 202)
                    return true;
                else
                    return false;
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        return false;
    }
	
	/***
	 * 将数组转换为json字符串
	 * @param friends
	 * @return
	 */
	public static String convertArrayToJSONString(String[]  friends){
		JSONArray json = new JSONArray();
		if(friends != null && friends.length > 0){
			for(String friend : friends){
				json.put(friend);
			}
		}	
		return json.toString();
	}
	
	// 16进制转二进制
	public static String hexString2binaryString(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(
							hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}
	// 二进制取反处理
	public static String binaryBack(String binary){
		if(binary == null || "".equals(binary)){
			return null;
		}
		String bString = "";
		for (int i = 0; i < binary.length(); i++) {
			char tmp = binary.charAt(i);
			if(tmp == '1'){
				bString += "0";
			}else if(tmp == '0'){
				bString += "1";
			}
		}
		return bString;
	}

	public static String binaryString2hexString(String bString) {
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}
	
	public static void main(String[] args) throws ParseException {
		String hexString = "aa";
		System.out.println(hexString);
		String binary = hexString2binaryString(hexString);
		System.out.println(binary); 
		String binaryBack = binaryBack(binary);
		System.out.println(binaryBack);
		String hex = binaryString2hexString(binaryBack);
		System.out.println(hex);  
	}
}
