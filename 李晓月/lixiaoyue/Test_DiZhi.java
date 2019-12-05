//11个

package lixiaoyue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

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
			AssertJUnit.assertTrue(webtest.isTextPresent("安全退出"));
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

	@DataProvider(name="excel2")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path")+"FaPiao.xlsx","Sheet1");
	}
	//更改发票信息（单位）
	@Test(priority=3,dataProvider="excel2")
	public void Change(String num1,String num2,String message3){
//		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=修改");
		webtest.click("id=addinvoice");
		webtest.type("id=invoice_title", num1);
		webtest.type("id=taxpayer", num2);
		webtest.click("id=type_invoice");
		webtest.click("link=保存");
		webtest.click("id=invoice_dialog_close");
		AssertJUnit.assertEquals(message3,"请输入正确的纳税人识别号");
	}
	
	//更改发票信息（个人）
	@DataProvider(name="excel3")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path")+"LeiBie.xlsx","Sheet1");
	}
	@Test(priority=4,dataProvider="excel3")
	public void Change2(String lei,String message4) throws InterruptedException{
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		Thread.sleep(2000);
		webtest.click("link=修改");
		webtest.click("link="+lei);
		webtest.click("link=保存");
		//AssertJUnit.assertTrue(webtest.isTextPresent("保存成功"));
		AssertJUnit.assertEquals(message4,"保存成功");
	}
	//全选删除
	@Test(priority=5,description="全选删除")
	public void DelectAll() throws Exception {
		//首先需要添加多个再次购买
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		WebElement e7 = getDriver().findElement(By.linkText("再次购买"));
		JavascriptExecutor jse7=(JavascriptExecutor) getDriver();
		for(int i=0;i<4;i++){
			jse7.executeScript("arguments[0].click();", e7);
		}
		Thread.sleep(2000);
////		//默认为全选删除
		WebElement e8 = getDriver().findElement(By.linkText("删除选中的商品"));
		JavascriptExecutor jse8=(JavascriptExecutor) getDriver();
		jse8.executeScript("arguments[0].click();", e8);
		
		
		WebElement e9 = getDriver().findElement(By.id("removeGoods"));
		JavascriptExecutor jse9=(JavascriptExecutor) getDriver();
		jse9.executeScript("arguments[0].click();", e9);
		
		Assert.assertTrue(getDriver().getPageSource().contains("去购物"));
	}
	
}
