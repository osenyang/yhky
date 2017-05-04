package com.elink.push;

import com.elink.push.android.AndroidListcast;
import com.elink.push.android.AndroidUnicast;

public class UmPushUtils {
	private String appkey = null;
	private String appMasterSecret = null;
	private String timestamp = null;
	
	public UmPushUtils(String key, String secret) {
		try {
			appkey = key;
			appMasterSecret = secret;
			timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/***
	 * 单播
	 * @throws Exception
	 */
	public void sendAndroidNurseReserveUnicast(String deviceTokens,String title,String text) throws Exception {
		AndroidUnicast unicast = new AndroidUnicast();
		unicast.setAppMasterSecret(appMasterSecret);
		unicast.setPredefinedKeyValue("appkey", this.appkey);
		unicast.setPredefinedKeyValue("timestamp", this.timestamp);
		// TODO Set your device token
		unicast.setPredefinedKeyValue("device_tokens", deviceTokens);
		unicast.setPredefinedKeyValue("ticker", "Android单播推送消息");
		unicast.setPredefinedKeyValue("title", title);
		unicast.setPredefinedKeyValue("text",   text);
		unicast.setPredefinedKeyValue("builder_id","1");//		
		unicast.setPredefinedKeyValue("after_open", "go_activity");
		unicast.setPredefinedKeyValue("activity", "com.elinkdeyuan.neighbornurse.ui.activity.userinfo.NurseRecordActivity");
		unicast.setPredefinedKeyValue("display_type", "notification");
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		unicast.setPredefinedKeyValue("production_mode", "true");
		// Set customized fields
		//unicast.setExtraField("test", "helloworld");
		unicast.send();
	}
	
	/****
	 * 列播
	 * @param deviceTokens
	 * @param title
	 * @param text
	 * @throws Exception
	 */
	public void sendAndroidListcast(String deviceTokens,String title,String text,String id) throws Exception {
		AndroidListcast unicast = new AndroidListcast();
		unicast.setAppMasterSecret(appMasterSecret);
		unicast.setPredefinedKeyValue("appkey", this.appkey);
		unicast.setPredefinedKeyValue("timestamp", this.timestamp);
		// TODO Set your device token
		unicast.setPredefinedKeyValue("device_tokens", deviceTokens);
		unicast.setPredefinedKeyValue("ticker", "Android列播推送消息");
		unicast.setPredefinedKeyValue("title", title);
		unicast.setPredefinedKeyValue("text",   text);
		unicast.setPredefinedKeyValue("builder_id","1");//		
		unicast.setPredefinedKeyValue("after_open", "go_activity");
		unicast.setPredefinedKeyValue("activity", "com.elinkdeyuan.neighbornurse.ui.activity.userinfo.NurseRecordActivity");
		unicast.setPredefinedKeyValue("display_type", "notification");
		unicast.setPredefinedKeyValue("production_mode", "true");
		unicast.setPredefinedKeyValue("key1", id);
		unicast.send();
	}

}
