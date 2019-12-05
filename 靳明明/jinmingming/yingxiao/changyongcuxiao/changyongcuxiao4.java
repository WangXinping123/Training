package com.webtest.jinmingming.yingxiao.changyongcuxiao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;

public class changyongcuxiao4 extends BaseTest{
	
	@Test
	public void dingdancuxiao() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=订单促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
//		getDriver().switchTo().defaultContent();//出文本框
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=name", "name");
		//促销活动类型
		webtest.click("id=prom_type");
		webtest.click("xpath=//*[@id='prom_type']/option[1]");//满额打折
		//需要满足的金额
		webtest.type("name=money","200");
		//折扣
		webtest.type("name=expression","90");
		//开始时间
		webtest.click("name=start_time");
		WebElement s = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", s);//清空默认时间
		webtest.type("name=start_time", "2019-11-25 22:00:00");
		//结束时间
		webtest.click("name=end_time");
		WebElement end = getDriver().findElement(By.xpath("//*[@id='layui-laydate2']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", end);//清空默认时间
		webtest.type("name=end_time", "2019-11-25 24:00:00");
		//提交
		webtest.click("link=确认提交");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
}
