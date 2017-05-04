package com.elink.hospitalhealthnurse.common.utils.sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/**
 * Mob手机发送验证码及验证码检查的工具类
 * 
 * @Description:
 * @author :刘灵星
 * @date ： 2015-7-17 上午11:31:08
 */
public class SmsUtil {

	
	/****
	 * 根据验证接口URL及参数，返回验证结果，传递的参数为 :
	 *  appkey string 应用appkey 必填 
     *  phone string 电话号码 必填(不带区号电话号码 eg.13121222212) 
     *  zone string 区号 必填(纯数字区号 eg.86) 
     *  code string 需要验证的验证码 必填 
	 * @param address
	 * @param params
	 * @return 
	 *  200 短信验证成功 
		512 服务器拒绝访问，或者拒绝操作 
		513 求Appkey不存在或被禁用。 
		514 权限不足 
		515 服务器内部错误 
		517 缺少必要的请求参数 
		518 请求中用户的手机号格式不正确（包括手机的区号） 
		519 请求发送验证码次数超出限制 
		520 无效验证码。 
		526 余额不足 

	 */
	public static String requestData(String address, String params) {
		HttpURLConnection conn = null;
		try {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(X509Certificate[] certs,	String authType) {
				}
				public void checkServerTrusted(X509Certificate[] certs,	String authType) {
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());

			// ip host verify
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					return urlHostName.equals(session.getPeerHost());
				}
			};

			// set ip host verify
			HttpsURLConnection.setDefaultHostnameVerifier(hv);

			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");// POST
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(3000);
			// set params ;post params
			if (params != null) {
				conn.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(
						conn.getOutputStream());
				out.write(params.getBytes(Charset.forName("UTF-8")));
				out.flush();
				out.close();
			}
			conn.connect();
			// get result
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				String result = parsRtn(conn.getInputStream());
				return result;
			} else {
				System.out.println(conn.getResponseCode() + " "	+ conn.getResponseMessage());				
			}
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			if (conn != null)
				conn.disconnect();
		}
		return null;
	}

	/**
	 * 获取返回数据
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	private static String parsRtn(InputStream is) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		boolean first = true;
		while ((line = reader.readLine()) != null) {
			if (first) {
				first = false;
			} else {
				buffer.append("\n");
			}
			buffer.append(line);
		}
		return buffer.toString();
	}
}
