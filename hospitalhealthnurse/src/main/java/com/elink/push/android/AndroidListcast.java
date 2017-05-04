package com.elink.push.android;

import com.elink.push.AndroidNotification;
/***
 * 列播
 * @author 刘灵星
 */
public class AndroidListcast extends AndroidNotification {
	public AndroidListcast() {
		try {
			this.setPredefinedKeyValue("type", "listcast");	
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}
