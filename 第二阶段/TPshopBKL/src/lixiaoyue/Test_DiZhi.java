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
import com.webtest.demo.Front_login;
import com.webtest.utils.ReadProperties;

public class Test_DiZhi extends BaseTest{
	
Front_login action;

@BeforeMethod
public void setup()
{
	action=new Front_login(webtest);
}

//登录
@Test(priority = 0,description="登录")
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
//
	
	@Test(priority=2,description="加入购物车后")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=去购物车结算");
		webtest.leaveFrame();
		webtest.click("link=去结算");
		}
	@Test(priority=3)
	public void Change0() throws InterruptedException{
//		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=修改");
		webtest.click("link=普通发票");
		webtest.click("id=addinvoice");
		webtest.typeAndClear("id=invoice_title", "hehehe");
		webtest.typeAndClear("id=taxpayer", "hehehe");
		webtest.click("id=type_invoice");
		webtest.click("link=保存");
		Assert.assertTrue(getDriver().getPageSource().contains("请输入正确的纳税人识别号"));
	}
	
	@DataProvider(name="excel2")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path")+"FaPiao.xlsx","Sheet1");
	}
	//更改发票信息（单位）
	@Test(priority=4,dataProvider="excel2")
	public void Change(String num1,String num2,String message3) throws InterruptedException{
//		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("id=invoice_dialog_close");
		webtest.click("link=修改");
		webtest.click("link=普通发票");
		webtest.click("id=addinvoice");
		webtest.typeAndClear("id=invoice_title", num1);
		webtest.typeAndClear("id=taxpayer", num2);
		webtest.click("id=type_invoice");
		webtest.click("link=保存");
		Assert.assertTrue(getDriver().getPageSource().contains("请输入正确的纳税人识别号"));
	}
//	
	@Test(priority=5)
	public void Change1() throws InterruptedException{
		webtest.click("id=invoice_dialog_close");
		webtest.click("link=修改");
		webtest.click("link=普通发票");
		webtest.click("id=personage");
		webtest.click("link=detail_invoice");
		webtest.click("link=保存");
		Assert.assertTrue(getDriver().getPageSource().contains("保存成功"));
	}
	
	
	//更改发票信息（个人）
	@DataProvider(name="excel3")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path")+"LeiBie.xlsx","Sheet1");
	}
	@Test(priority=5,dataProvider="excel3")
	public void Change2(String lei,String message4) throws InterruptedException{
		webtest.click("link=修改");
		webtest.click("link=普通发票");
		webtest.click("id=personage");
		webtest.click("link="+lei);
		webtest.click("link=保存");
		Assert.assertTrue(getDriver().getPageSource().contains("保存成功"));
	}
	
}
