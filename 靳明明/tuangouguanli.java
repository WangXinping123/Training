package com.jinmingming.business;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
public class tuangouguanli extends BaseTest{
	@BeforeMethod
	public void login(){
		//Login登录
		webtest.open("http://localhost:8036/index.php/Admin/Index/index#");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=vertify", "1234");//验证码已经屏蔽，输入任意四个值都可
		webtest.click("name=submit");
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D://ceshi//shixun//data//yingxiao//tuangou.xlsx","Sheet1");
	}
	
	@Test(dataProvider="excel")
	public void yingxiao(String title,String start_time,String end_time,String price,String goods_num,String virtual_num) throws InterruptedException{
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		Thread.sleep(2000);
		webtest.click("link=团购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//团购标题
		webtest.type("name=title", title);
		//开始时间
		webtest.click("name=start_time");
		WebElement s = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", s);//清空默认时间
		webtest.type("name=start_time", "start_time");
		//结束时间
		webtest.click("name=end_time");
		WebElement end = getDriver().findElement(By.xpath("//*[@id='layui-laydate2']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", end);//清空默认时间
		webtest.type("name=end_time", "end_time");
		//选择团购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[4]/dd/p/a"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//团购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参团数量
		webtest.type("name=goods_num",goods_num);
		//虚拟购买数
		webtest.type("name=virtual_num", virtual_num);
		//团购介绍
		//提交
		webtest.click("link=确认提交");
	}
}
