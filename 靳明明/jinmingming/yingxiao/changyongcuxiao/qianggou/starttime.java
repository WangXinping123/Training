package com.webtest.jinmingming.yingxiao.changyongcuxiao.qianggou;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;

public class starttime extends BaseTest{
	@DataProvider(name="datal")
	public Object[][] getExcelDada() throws Exception{
		return new TxtDataProvider().getTxtUser("D://ceshi//shixun//data//yingxiao//changyongcuxiao1//starttime//starttime.txt");
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
}
