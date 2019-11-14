package com.edu.core;

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

import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarker {
	@Test
	public static void createHTML() throws Exception{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("WEB-INF/"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("demo.ftl");
		ApiListener2 listener =new ApiListener2();
		
		Map map=listener.writeResultToMail();
		
		System.out.println(map.toString());
		
		/*Map context =new HashMap<>();
		List<Object> list = new ArrayList<>();
		list.add(map.get("failedList"));
		list.add(map.get("passedList"));
		list.add(map.get("casesize"));
		context.put("failedList", map.get("failedList"));
		context.put("passedList", map.get("passedList"));
		context.put("casesize", map.get("casesize"));
		context.put("data",list);*/
		
		//获取当前时间
		Date d = new Date(); 

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHHmmss");
		String dateNowStr = sdf.format(d); 
		// 定义输出
		Writer out = new FileWriter("E:\\Training\\result\\" +
				dateNowStr+ "freemarker.html");
		// template.process(root, out);
		//template.process(context, out);
		template.process(map, out);

		System.out.println("转换成功");
		out.flush();
		out.close();
		
	}

}
