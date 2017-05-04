package com.elink.hospitalhealthnurse.common.utils.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	String userName = null;
	String password = null;

	public MyAuthenticator() {
	}

	public MyAuthenticator(String username, String password) {
		this.userName = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}

	public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.exmail.qq.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("liulingxing@elinkdeyuan.com"); // 自己的邮箱
		mailInfo.setPassword("llx@800921");// 自己的邮箱密码，用于验证

		mailInfo.setFromAddress("liulingxing@elinkdeyuan.com"); // /自己的邮箱
		mailInfo.setToAddress("369582154@qq.com"); // /对方的邮箱
		mailInfo.setSubject("设置邮箱标题");
		mailInfo.setContent("设置邮箱内容");

		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);// 发送文体格式
		sms.sendHtmlMail(mailInfo);// 发送html格式
	}
}