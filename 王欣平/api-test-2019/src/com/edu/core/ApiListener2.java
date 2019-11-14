package com.edu.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.Put;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.edu.utils.Log;
import com.edu.utils.ReadPro;

import bsh.This;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ApiListener2 extends TestListenerAdapter {

	public Map writeResultToMail() {
		Map context = new HashMap();
		ITestNGMethod method[] = this.getAllTestMethods();
		List failedList = this.getFailedTests();
		List passedList = this.getPassedTests();
		List failedList1 = new ArrayList();
		List passedList1 = new ArrayList();
		
		for (int j = 0; j < failedList.size(); j++) {
			ITestResult tr = (ITestResult) failedList.get(j);
			if (tr.getMethod().getDescription() != null) {
				tr.setAttribute("name", tr.getMethod().getDescription());
			} else {
				tr.setAttribute("name", "");
			}
			//context.put("passedname", tr.getName());
			failedList1.add(tr);
		}
		
		for (int j = 0; j < passedList.size(); j++) {
			ITestResult tr = (ITestResult) passedList.get(j);
			if (tr.getMethod().getDescription() != null) {
				tr.setAttribute("name", tr.getMethod().getDescription());
				
			} else {
				tr.setAttribute("name", "");
			}
			passedList1.add(tr);
		}
			
		context.put("date", new Date());
		context.put("failedList", failedList.size());
		context.put("passedList", passedList1.size());
		context.put("failed", failedList);
		context.put("passed", passedList);
		context.put("casesize", passedList.size() + failedList.size());
		context.put("failcasesize", failedList.size());
		/*
		 * try {
		 * 
		 * String content=mapToString(context); return content; } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } return null;
		 */
		return context;
	}

	public static String mapToString(Map<String, Object> para) {

		StringBuilder sBuilder = new StringBuilder();
		int size = para.size();
		for (Entry<String, Object> entry : para.entrySet()) {
			sBuilder.append(entry.getKey() + "=" + entry.getValue() + "\n");
		}
		return sBuilder.toString();
	}

	@Override
	public void onFinish(ITestContext testContext) {

		super.onFinish(testContext);
		System.out.println(getAllTestMethods().length);
		// String emailContent=this.writeResultToMail();
		Map context2 = this.writeResultToMail();
		String emailContent = this.mapToString(context2);
		System.out.println(emailContent);

		String emailTitle = ReadPro.getPropValue("mail_title") + "----" + this.getTime();
		String toMail = ReadPro.getPropValue("to_mail");
		try {
			MailUtil.sendEmail("2019/11/13",toMail, emailTitle, emailContent);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getTime() {
		java.util.Calendar c = java.util.Calendar.getInstance();
		java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		return f.format(c.getTime());
	}
	// 以下必须注释，截获信息
	// @Override
	// public void onTestSuccess(ITestResult tr) {
	// Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功");
	// }
	// @Override
	// public void onTestFailure(ITestResult tr) {
	//
	// Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败");
	// }

	/*public void freemarker() throws Exception {
		String dir = "E:\\AFileprogram\\api-test-2019";
		Configuration conf = new Configuration(Configuration.getVersion());
		// 加载模板文件(模板的路径)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 加载模板
		Template template = conf.getTemplate("WEB-INF/demo.ftl");
		// 定义数据
		Map context = new HashMap();
		this.writeResultToMail().get("failedList");
		
		context.put("failedList", this.writeResultToMail().get("failedList"));
		context.put("passedList", this.writeResultToMail().get("passedList"));
		context.put("casesize", this.writeResultToMail().get("casesize"));
		context.put("failcasesize", this.writeResultToMail().get("failcasesize"));

		// 定义输出
		Writer out = new FileWriter(dir + "/freemarker.html");
		// template.process(root, out);
		template.process(context, out);

		System.out.println("freemarker.html已生成");
		out.flush();
		out.close();
	}
*/
}
