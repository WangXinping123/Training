package com.webtest.freemarker_demo;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.testng.annotations.Test;

public class Mail_Test_HtmlContext {
	static String from = "testyang729@126.com";
	static String auth_code = "yang123";
	static String to = "987580132@qq.com";
	
	@Test 
	public static void sendMail(String read_text) throws AddressException, MessagingException, IOException{
		//1.创建Properties对象
		Properties prop = new Properties();
		prop.put("mail.transport.protocol", "smtp");//协议
		prop.put("mail.smtp.host", "smtp.126.com");//发件人邮箱
		prop.put("mail.smtp.auth", "true");
		//2.Session对象,设置发件箱，授权码
		Session session = Session.getInstance(prop,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(from, auth_code);
			}
		});
		//3.Message对象设置，发件人，收件人，主题，正文
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		//收件人
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//邮件主题
		message.setSubject("Hello JavaMail");
		//邮件正文
		//message.setContent((Demo_01.read()), "text/html;charset=gb2312");
		message.setContent((read_text), "text/html;charset=gb2312");

		//发送邮件
		

		//正文为HTML格式
//		Multipart mainPart = new MimeMultipart();
//		BodyPart html = new MimeBodyPart();
//		//设置Html内容
//		new MimeBodyPart().setContent(message,"text/html;charset=gb2312");
//		new MimeMultipart().addBodyPart(html);
//		Multipart mimeMultipart;
//		message.setContent(mainPart);
		Transport.send(message);
		//为邮件添加附件
		//4.使用Transport 发送
	}
}
