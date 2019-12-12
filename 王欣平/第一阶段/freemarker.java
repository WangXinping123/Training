package com.edu.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.edu.core.ApiListener;
public class Hello {

	@Test
	public static void printHello(Map<String, Object> map ,int pass, int fail) throws IOException, TemplateException{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("WEB-INF/"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("hello.ftl");
		ApiListener listener =new ApiListener();
		
		Map dataModel =new HashMap<>();
		dataModel.put("date", new Date());
		dataModel.put("failedList", map.get("failedList"));
		dataModel.put("passedList", map.get("passedList"));
		dataModel.put("casesize", map.get("casesize"));
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();	
		for(int i=0;i<pass;i++)
			passedList1.add(map.get("passname"+i));
		for(int z=0;z<fail;z++)
			failedList1.add(map.get("failname"+z));
		dataModel.put("passname", passedList1);
		System.out.println(passedList1);
		System.out.println(failedList1);
		dataModel.put("failname", failedList1);
		Writer out = new FileWriter(new File("E:/Training/result/hello.html"));
		template.process(dataModel, out);
		
		out.close();
		
	}
}
