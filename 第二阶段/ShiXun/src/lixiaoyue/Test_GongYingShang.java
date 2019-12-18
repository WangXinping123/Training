//23个

package lixiaoyue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.utils.ReadProperties;
/**
 * 项目名称：TPSHOP 类名称：Test_GongYingShang 类描述： 后台供应商相关测试
 * 
 * @author 李晓月     
 * @version
 */
public class Test_GongYingShang extends BaseTest{
	Base_login action;
	@BeforeMethod
	public void setup()
	{
		action=new Base_login(webtest);
	}

	//登录
	@Test(priority = 0)
		 public void Entry() throws InterruptedException{
			action.login2("admin", "123456");
			Thread.sleep(2000);
			WebElement e1 = getDriver().findElement(By.className("novice-guide-close"));
			JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
			jse1.executeScript("arguments[0].click();", e1);	
			webtest.click("link=供应商");
		}
	
//添加供应商	
	@DataProvider(name="txt")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser(ReadProperties.getPropertyValue("data_path")+"ZZ.txt");
	}
	@Test(priority=1,dataProvider="txt")	
	public void GetPot(String num1,String name,String description,String person,String phone,String address,String province,String city,String place,String user_name,String password,String message,String truth) throws Exception{
		System.out.println(num1);
		getDriver().switchTo().frame("workspace");
		webtest.click("xpath=/html/body/div[3]/div[3]/div[1]/div[2]/a/div/span");
		webtest.type("name=suppliers_account", num1);
		webtest.type("name=user_name", user_name);
		webtest.type("name=password", password);
		webtest.type("name=suppliers_name", name);
		webtest.type("name=suppliers_desc",description);
		webtest.type("name=suppliers_contacts", person);
		webtest.type("name=suppliers_phone", phone);
		webtest.click("id=province");
		webtest.click("xpath="+province);
		webtest.click("id=city");
		webtest.click("xpath="+city);
		webtest.click("id=district");
		webtest.click("xpath="+place);
		webtest.type("name=supplier_address", address);	
		webtest.click("link=确认提交");
		webtest.typeAndClear("name=suppliers_account", "");
		webtest.typeAndClear("name=user_name", "");
		webtest.typeAndClear("name=password", "");
		webtest.typeAndClear("name=suppliers_name", "");
		webtest.typeAndClear("name=suppliers_desc","");
		webtest.typeAndClear("name=suppliers_contacts", "");
		webtest.typeAndClear("name=suppliers_phone", "");
		webtest.typeAndClear("name=supplier_address","");	
		//出文本框
		getDriver().switchTo().defaultContent();
		AssertJUnit.assertEquals(message,truth);
	}
	
	//产看待审核商品
	@Test(priority = 2)
	public void Commodity(){
		webtest.click("link=供应商");
		webtest.click("link=待审核商品");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品管理"));
	}	
	//点击查看商品列表
	@Test(priority = 3)
	public void List2(){
		webtest.click("link=供应商");
		webtest.click("link=商品列表");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品管理"));
	}	
	//点击查看订单列表
	@Test(priority = 4)
	public void Order(){
		webtest.click("link=供应商");
		webtest.click("link=订单列表");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品订单"));
	}	
	//查看退款单
	@Test(priority = 5)
	public void Refund() throws InterruptedException{
		webtest.click("link=供应商");
		webtest.click("link=退款单");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("已付款并取消单列表"));
		getDriver().switchTo().defaultContent();
	}
	//点击查看退换货
	@Test(priority = 6)
	public void Goods() throws InterruptedException{
		//供应商（查看退换货）
		webtest.click("link=供应商");
		webtest.click("link=退换货");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("退货退款管理"));
		getDriver().switchTo().defaultContent();
	}	
		//查看发票列表
	@Test(priority = 7)
	public void List() throws InterruptedException{
		webtest.click("link=供应商");
		webtest.click("link=发票列表");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商业用途必须购买正版,使用盗版将追究法律责任"));
		getDriver().switchTo().defaultContent();
	}
	//点击体现申请
	@Test(priority = 8)
	public void Apply() throws InterruptedException{
		webtest.click("link=供应商");
		webtest.click("link=提现申请");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("提现申请管理"));
		getDriver().switchTo().defaultContent();
	}
	//点击查看转款列表
	@Test(priority = 9)
	public void Transfer() throws InterruptedException{
		webtest.click("link=供应商");
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.click("link=转款列表");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("供应商汇款记录"));
		getDriver().switchTo().defaultContent();
	}
	//点击查看结算记录
	@Test(priority = 10)
	public void Settlement() throws Exception{
		webtest.click("link=供应商");
//		Thread.sleep(2000);	
		webtest.tapDown();
		webtest.tapDown();
		webtest.click("link=结算记录");
		getDriver().switchTo().frame("workspace");
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("供应商结算管理"));
		getDriver().switchTo().defaultContent();
	}	
}
