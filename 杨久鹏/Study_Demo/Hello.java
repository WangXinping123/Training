package com.webtest.freemarker_demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.Test;
import com.webtest.core.ApiListener;
import com.webtest.utils.JavaMailUtils.MailSend;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Hello {

	@Test
	public static void printHello(Map<String, Object> map ,int pass, int fail) throws IOException, TemplateException, AddressException, MessagingException{
		Configuration configuration = new Configuration();
		configuration.setDirectoryForTemplateLoading(new File("F:\\Freemarker学习\\模板"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("hello.ftl");
		ApiListener listener =new ApiListener();
		
		Map<Object, Object> dataModel =new HashMap<>();
		dataModel.put("date", new Date());
		dataModel.put("failedList", map.get("failedList"));
		dataModel.put("passedList", map.get("passedList"));
		dataModel.put("casesize", map.get("casesize"));
		List<Object> failedList1=new ArrayList<Object>();
		List<Object> passedList1=new ArrayList<Object>();	
		for(int i=0;i<pass;i++)
			passedList1.add(map.get("passname"+i));
		for(int z=0;z<fail;z++)
			failedList1.add(map.get("failname"+z));
		dataModel.put("passname", passedList1);
		System.out.println(passedList1);
		System.out.println(failedList1);
		dataModel.put("failname", failedList1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime = sdf.format(new Date());
		
		Writer out = new FileWriter(new File("F:\\Freemarker学习\\生成报告" + "\\" + "test_"+nowDateTime+".html"));
		//将数据与模板合并
		template.process(dataModel, out);
		
		Mail_Test_HtmlContext.sendMail(ReadText.read());
		out.close();
		
	}
}
