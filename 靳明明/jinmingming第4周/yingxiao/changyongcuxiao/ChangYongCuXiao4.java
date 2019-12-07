package com.webtest.jinmingming.yingxiao.changyongcuxiao;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;

public class ChangYongCuXiao4 extends BaseTest{
	int i=0;
	@BeforeClass
	public void aaa(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
	}
	@DataProvider(name="data1")
	public Object[][] getExcelDada() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/dingdancuxiao/shuju.txt");
	}
	@Test(dataProvider="data1",priority=0)
	public void dingdancuxiao(String name,String money,String num) throws Exception{
		webtest.click("link=订单促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=name", name);
		//需要满足的金额
		webtest.type("name=money",money);
		//折扣
		webtest.type("name=expression",num);
		//提交
		webtest.click("link=确认提交");
		Thread.sleep(200);
		i++;
		SoftAssert soft =new SoftAssert();
		if(i==1){
			AssertJUnit.assertTrue(webtest.isTextPresent("共4条记录"));
		}else{
			AssertJUnit.assertTrue(!(webtest.isTextPresent("共4条记录")));
		}
		if(webtest.isTextPresent("共4条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框 
		soft.assertAll();
	}	
	//时间
	@DataProvider(name="data2")
	public Object[][] getDada() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/dingdancuxiao/shijian.txt");
	}
	@Test(dataProvider="data2",priority=1)
	public void Time(String name,String money,String num,String start_time,String end_time) throws Exception{
		webtest.click("link=订单促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=name", name);
		//需要满足的金额
		webtest.type("name=money",money);
		//折扣
		webtest.type("name=expression",num);
		//开始时间
		webtest.click("name=start_time");
		WebElement s = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", s);//清空默认时间
		webtest.type("name=start_time", start_time);
		//结束时间
		webtest.click("name=end_time");
		WebElement end = getDriver().findElement(By.xpath("//*[@id='layui-laydate2']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", end);//清空默认时间
		webtest.type("name=end_time", end_time);
		//提交
		webtest.click("link=确认提交");
		Thread.sleep(200);
		i++;
		SoftAssert soft =new SoftAssert();
		AssertJUnit.assertTrue(!(webtest.isTextPresent("共4条记录")));
		if(webtest.isTextPresent("共4条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框 
		soft.assertAll();
	}
}
