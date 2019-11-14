package com.edu.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.edu.utils.Log;
import com.edu.utils.ReadPro;

import freemarker.template.TemplateException;

import com.edu.core.Hello;

public class ApiListener extends TestListenerAdapter{

	
	public Map<String, Object> writeResultToMail() throws IOException, TemplateException
	{
		ITestNGMethod method[]=this.getAllTestMethods();
		Map context=new HashMap();
		List failedList=this.getFailedTests();
		List passedList=this.getPassedTests();
		List failedList1=new ArrayList();
		List passedList1=new ArrayList();		
		int i=0;
		for(int j=0;j<failedList.size();j++)
		{
			
			ITestResult tr=(ITestResult) failedList.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
			context.put("failname"+i, tr.getName());
			i++;
			failedList1.add(tr);
		}
		int z=0;
		for(int j=0;j<passedList.size();j++)
		{
			ITestResult tr=(ITestResult) passedList.get(j);
			if(tr.getMethod().getDescription()!=null)
			{
				tr.setAttribute("name", tr.getMethod().getDescription());
			}
			else
			{
				tr.setAttribute("name", "");
			}
			context.put("passname"+z, tr.getName());
			z++;
			passedList1.add(tr);
			//System.out.println(passedList1);
		}
		
    	context.put("date", new Date());
        context.put("failedList",failedList.size());   
        context.put("passedList",passedList1.size()); 
        context.put("casesize",passedList.size()+failedList.size()); 
        context.put("failcasesize",failedList.size());
        Hello hello =new Hello();
        hello.printHello(context,passedList1.size(),failedList.size());
        try {
			
        	//String content=mapToString(context);
			return context;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static String  mapToString(Map<String, Object> para) {
		
		StringBuilder  sBuilder =new StringBuilder();
		int size=para.size();
		for(Entry<String, Object> entry:para.entrySet()) {
			sBuilder.append(entry.getKey()+"="+entry.getValue()+"\n");
			
		}
		
	return  sBuilder.toString();
				
	}
	@Override
	public void onFinish(ITestContext testContext) {
	
		super.onFinish(testContext);
		System.out.println(getAllTestMethods().length);
		Map content=null;
		try {
			content = this.writeResultToMail();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String emailContent=mapToString(content);
		System.out.println(emailContent);
		
		String emailTitle=ReadPro.getPropValue("mail_title")+"----"+this.getTime();
		String toMail=ReadPro.getPropValue("to_mail");
		try {
			MailUtil.sendEmail("",toMail,emailTitle, emailContent);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	   public String getTime()
	    {
	    	java.util.Calendar c=java.util.Calendar.getInstance();    
	        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");    
	       	return  f.format(c.getTime());    
	    }
//	  @Override
//	  public void onTestSuccess(ITestResult tr) {
//		  System.out.println(tr.getInstance()+"-"+tr.getName()+"运行成功");
////		  Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功");
//		  
//	  }
//	  @Override
//	  public void onTestFailure(ITestResult tr) {
//		  System.out.println(tr.getInstance()+"-"+tr.getName()+"运行失败");
////		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败");
//		  
//	  }

}
