package com.webtest.jinmingming.yingxiao.changyongcuxiao;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;

public class changyongcuxiao3 extends BaseTest{

	
	@Test
	public void yingxiao() throws InterruptedException, AWTException{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=优惠促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//促销活动名称
		webtest.type("name=title", "title");
		//促销活动类型
		webtest.click("name=直接打折");
		//折扣
		webtest.type("name=expression", "90");
		//限购数量
		webtest.type("name=buy_limit", "5");
		//开始时间
		webtest.click("name=start_time");
		WebElement s = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", s);//清空默认时间
		webtest.type("name=start_time", "2019-12-20 10:00:00");
		//结束时间
		webtest.click("name=end_time");
		WebElement end = getDriver().findElement(By.xpath("//*[@id='layui-laydate2']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", end);//清空默认时间
		webtest.type("name=end_time", "2019-12-23 10:00:00");
			
		//选择优惠商品
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);	
		Thread.sleep(2000);
		
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//商品描述
		
		getDriver().switchTo().frame("workspace");
		//宣传图片
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe2");//进文本框
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/img"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("xpath=/html/body/div/div/div[2]/ul/li[1]");
		
		
//		//确认提交
//		getDriver().switchTo().frame("workspace");
//		webtest.click("link=确认提交");
//		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
}
