package com.webtest.core;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailUtil2 {
	static int port = 25;
	static String server = "smtp.126.com";
	static String from = "王欣平";
	static String user = "w2295691295@126.com";
	static String password = "wxp123456";// 授权码

	public static void sendEmail(String content, String email, String subject, String body)
			throws UnsupportedEncodingException {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", server);
			props.put("mail.smtp.port", String.valueOf(port));
			props.put("mail.smtp.auth", "true");
			Transport transport = null;
			Session session = Session.getDefaultInstance(props, null);
			transport = session.getTransport("smtp");
			transport.connect(server, user, password);
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());

			InternetAddress fromAddress = new InternetAddress(user, from, "UTF-8");
			msg.setFrom(fromAddress);
			String emailList[] = email.split(",");
			InternetAddress[] toAddress = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++) {
				toAddress[i] = new InternetAddress(emailList[i]);
			}

			msg.addRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject, "UTF-8");
			msg.setContent(body, "text/html;charset=utf-8");

			Multipart multipart = new MimeMultipart();// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			BodyPart contentPart = new MimeBodyPart();// 设置邮件的文本内容
			contentPart.setText(content);
			multipart.addBodyPart(contentPart);
			// 添加附件
			BodyPart messageBodyPart = new MimeBodyPart();
			String filepath = "E:\\Training\\result\\hello.html";
			System.out.println("邮件附件地址：" + filepath);
			File file = new File(filepath);
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));// 添加附件的内容
			messageBodyPart.setFileName(MimeUtility.encodeText(file.getName(), "UTF-8", "B"));
			multipart.addBodyPart(messageBodyPart);

			msg.setContent(multipart);// 将multipart对象放到message中
			msg.saveChanges(); // 保存邮件
			transport.sendMessage(msg, msg.getAllRecipients());// 发送邮件

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws UnsupportedEncodingException {
		MailUtil2.sendEmail("测试内容如下", "test", "2019/11/14", "测试");
	}

}
