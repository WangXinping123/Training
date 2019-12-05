package com.webtest.jinmingming.yingxiao.changyongcuxiao.qianggou;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class changyongcuxiao1 extends BaseTest{

	@DataProvider(name="datal")
	public Object[][] getExcelDada() throws Exception{
		return new ExcelDataProvider().getTestDataByExcel("D://ceshi//shixun//data//yingxiao//changyongcuxiao1//aaa.xlsx","Sheet1");
	}
	//正确
	@Test(dataProvider="datal") 
	public void yingxiao1(String title,String price,String goods_num,String buy_limit,String start_time) throws InterruptedException{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=抢购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=title", title);
		//选择抢购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='select_goods_button']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参加抢购数量
		webtest.type("name=goods_num",goods_num);
		//限购数量
		webtest.type("name=buy_limit", buy_limit);
		//开始时间
		webtest.type("name=start_time", start_time);
		Thread.sleep(2000);
		//抢购介绍
		//提交
		webtest.click("link=确认提交");	
//		assertTrue(webtest.isTextPresent(ass));
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
	
	//抢购标题为空
	@Test
	public void biaoti1() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=抢购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=title", "");
		Thread.sleep(2000);
		//选择抢购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='select_goods_button']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price","20");
		//参加抢购数量
		webtest.type("name=goods_num","20");
		//限购数量
		webtest.type("name=buy_limit", "10");
		//开始时间
		webtest.type("name=start_time", "2019-12-25-22:00:00");
		//抢购介绍
		//提交
		Thread.sleep(2000);
		webtest.click("link=确认提交");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
	//选择抢购商品为空
	@Test(dataProvider="datal")
	public void shangpin(String title,String price,String goods_num,String buy_limit,String start_time) throws InterruptedException{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=抢购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=title", title);
		//选择抢购商品
		
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参加抢购数量
		webtest.type("name=goods_num",goods_num);
		//限购数量
		webtest.type("name=buy_limit", buy_limit);
		//开始时间
		webtest.type("name=start_time", start_time);
		Thread.sleep(2000);
		//抢购介绍
		//提交
		webtest.click("link=确认提交");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
	//限时抢购价格为空
	@Test
	public void jiagekong() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=抢购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=title", "title0");
		//选择抢购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='select_goods_button']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price","");
		//参加抢购数量
		webtest.type("name=goods_num","20");
		//限购数量
		webtest.type("name=buy_limit", "10");
		//开始时间
		webtest.type("name=start_time", "2019-12-25-22:00:00");
		Thread.sleep(2000);
		//抢购介绍
		//提交
		webtest.click("link=确认提交");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
}
