package com.webtest.jinmingming.yingxiao.youhiujuan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.jinmingming.Action;

public class youhiujuan1 extends BaseTest{
	
	@Test
	public void youhiujuan() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement a = getDriver().findElement(By.xpath("/html/body/div/div[3]/div/ul/a[1]/li"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", a);
		Thread.sleep(2000);
		//添加优惠劵
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div"));
		jse.executeScript("arguments[0].click();", e);
////		getDriver().switchTo().defaultContent();//出文本框
		Thread.sleep(2000);
		//数据
		//优惠劵名称
		webtest.type("name=name","优惠劵1");
		//优惠劵面额
		webtest.type("name=money", "100");
		//消费金额
		webtest.type("name=condition","200");
		//发放数量
		webtest.type("name=createnum", "10");
		//发放类型
		webtest.click("xpath=//*[@id='handleposition']/div/dl[5]/dd/label[2]");
		//时间
		webtest.type("name=send_start_time", "2019-11-27 22:00:00");//发放起始时间
		webtest.type("name=send_end_time", "2019-11-28 22:00:00");//发放结束时间
		Thread.sleep(2000);
		webtest.type("name=user_start_time", "2019-11-29 10:00:00");//使用起始日期
		webtest.type("name=user_end_time", "2019-11-29 12:00:00");//使用结束时间
		webtest.click("link=确认提交");
	}
}
