package lixiaoyue;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Test_DiZhi extends BaseTest{
Base_login action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Base_login(webtest);
	}

	//登录
	@Test(priority = 0)
		 public void Entry() throws InterruptedException{
			action.login("15227564513", "123456");
			Thread.sleep(2000);
			assertTrue(webtest.isTextPresent("安全退出"));
			Thread.sleep(2000);
		}
	//查询更改地址
	@Test(priority=1)
	public void DiZhi(){
		//进入地址页
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		//查看地址
		webtest.click("link=更多地址");
		//更换地址
		webtest.click("xpath=//*[@id='ajax_address']/div[2]/ul/li[3]/div[1]");
	}
	//添加数据驱动
	@DataProvider(name="excel1")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/DiZhi.xlsx","Sheet1");
	}
	
	//新增地址
	@Test(priority=2,dataProvider="excel1")
	public void AddDiZhiSuccess(String user,String phone,String address,String message) throws InterruptedException{
		//添加地址
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=新增收货地址");
		webtest.type("xpath=//*[@id='address_form']/div[2]/div/div[2]/div[1]/div/input", user);
		webtest.type("xpath=//*[@id='address_form']/div[2]/div/div[2]/div[2]/div/input", phone);
		webtest.click("id=province");
		webtest.click("xpath=//*[@id='province']/option[4]");
		Thread.sleep(1000);
		webtest.click("id=city");
		webtest.click("xpath=//*[@id='city']/option[10]");
		Thread.sleep(1000);
		
		WebElement parentMenu=getDriver().findElement(By.id("district"));
		Actions builder=new Actions(getDriver());
		builder.moveToElement(parentMenu).perform(); 
		WebElement subMenu=getDriver().findElement(By.xpath("//*[@id='district']/option[7]"));
		subMenu.click();	
		Thread.sleep(1000);
		webtest.click("id=twon");
		webtest.click("xpath=//*[@id='twon']/option[4]");
		Thread.sleep(1000);
		webtest.type("name=address", address);
		webtest.click("id=address_submit");
		if(message.equals("操作失败")){
			webtest.click("id=address_dialog_close");
		}
		Assert.assertEquals(message,"新增收货地址");
		//断言为错的时候，关闭新增地址框
		if(message.equals("操作失败")){
			webtest.click("id=address_dialog_close");
		}
	}
	
	
	
	@DataProvider(name="excel2")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/FaPiao.xlsx","Sheet1");
	}
	//更改发票信息（单位）
	@Test(priority=3,dataProvider="excel2")
	public void Change(String num1,String num2,String message3){
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=修改");
		webtest.click("id=addinvoice");
		webtest.type("id=invoice_title", num1);
		webtest.type("id=taxpayer", num2);
		webtest.click("id=type_invoice");
		webtest.click("link=保存");
		webtest.click("id=invoice_dialog_close");
		Assert.assertEquals(message3,"请输入正确的纳税人识别号");
	}
	
	//更改发票信息（个人）
	@DataProvider(name="excel3")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/LeiBie.xlsx","Sheet1");
	}
	@Test(priority=4,dataProvider="excel3")
	public void Change2(String lei){
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=修改");
		webtest.click("link="+lei);
		webtest.click("link=保存");
		assertTrue(webtest.isTextPresent("请输入正确的纳税人识别号"));
	}
}
