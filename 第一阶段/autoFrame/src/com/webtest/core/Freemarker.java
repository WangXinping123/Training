package com.webtest.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.util.StringBuilderWriter;
import org.testng.annotations.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import com.webtest.core.ApiListener;
public class Freemarker {

	@Test
	public static String writeFreemarker(Map<String, Object> map) throws IOException, TemplateException{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("WEB-INF/"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("report.ftl");
		ApiListener listener =new ApiListener();
		
		Map dataModel =new HashMap<>();
		dataModel.put("date", new Date());
		dataModel.put("passedList", map.get("passedList"));
		dataModel.put("failedList", map.get("failedList"));
		
		dataModel.put("failcasesize", map.get("failcasesize"));
		dataModel.put("passcasesize", map.get("passcasesize"));
		dataModel.put("casesize", map.get("casesize"));

		StringWriter out = new StringWriter();
		//Writer out = new FileWriter(new File("E:/Training/result/hello.html"));
		template.process(dataModel, out);
		//out.close();	
		return out.toString();
				
	}
}
