package lixiaoyue;

import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.xml.soap.Text;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.demo.Login_Action;



public class Test_DingDan extends BaseTest{
	
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
	
	//登录的情况下
	@Test(priority = 1)
	 public void MyDd() throws InterruptedException{
			webtest.click("link=我的订单");
			assertTrue(webtest.isTextPresent("全部订单"));
	}	
	//未登录的情况下-跳转到登录页面
//	@Test(priority = 1)
//	 public void MyDdN() throws InterruptedException{
//			webtest.open("http://localhost:8036/Home/Index/index.html");
//			webtest.click("link=我的订单");
//			assertTrue(webtest.isTextPresent("全部订单"));
//		}	

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/ChaXun.xlsx","Sheet1");
	}
	@Test(priority=2,dataProvider="excel")
		public void CheckBy(String name,String message2) throws Exception{
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", name);
		WebElement e1 = getDriver().findElement(By.xpath("//*[@id='search_order']/input[2]"));
		JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();", e1);
		Assert.assertEquals(message2,"加入购物车");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='navitems5']/ul/li[1]/a");
		webtest.getWindow(0);
	}
	
//	//查看订单详情
	@Test(priority=5)
	public void LookDetail() throws Exception{
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
//	//查看订单详情
		WebElement e4 = getDriver().findElement(By.linkText("查看详情"));
		JavascriptExecutor jse4=(JavascriptExecutor) getDriver();
		jse4.executeScript("arguments[0].click();", e4);
		}
	
	//再次购买
	@Test(priority=6,description="再次购买")
	public void BuyAgain() throws Exception{    
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		WebElement e5 = getDriver().findElement(By.linkText("再次购买"));
		JavascriptExecutor jse5=(JavascriptExecutor) getDriver();
		jse5.executeScript("arguments[0].click();", e5);

		webtest.getWindow(1);
		Thread.sleep(2000);
		WebElement e6 = getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[2]/div[1]/a"));
		JavascriptExecutor jse6=(JavascriptExecutor) getDriver();
		jse6.executeScript("arguments[0].click();", e6);
	}
		
	
	//再次购买
		@Test(priority=7,description="再次购买改变数量")
		public void BuyAgain2() throws Exception{    
			webtest.open("http://localhost:8036/Home/Order/order_list.html");
			WebElement e5 = getDriver().findElement(By.linkText("再次购买"));
			JavascriptExecutor jse5=(JavascriptExecutor) getDriver();
			jse5.executeScript("arguments[0].click();", e5);

			webtest.getWindow(1);
			Thread.sleep(2000);
			webtest.click("link=-");
			WebElement e6 = getDriver().findElement(By.linkText("去结算"));
			JavascriptExecutor jse6=(JavascriptExecutor) getDriver();
			jse6.executeScript("arguments[0].click();", e6);
		}
		
		//多选收藏
		@Test(priority=8,description="多选收藏")
		public void SaveObject() throws Exception{
			webtest.open("http://localhost:8036/home/Cart/index.html");
			webtest.click("link=移到我的收藏");
		}
				
		//单选收藏
		@Test(priority=9,description="单选收藏")
		public void SaveOne() throws Exception{
			webtest.open("http://localhost:8036/home/Cart/index.html");
			WebElement e10 = getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/div/a[2]"));
			JavascriptExecutor jse10=(JavascriptExecutor) getDriver();
			jse10.executeScript("arguments[0].click();", e10);					
		}
		
		//全选删除
		@Test(priority=10,description="全选删除")
		public void DelectAll() throws Exception {
			//首先需要添加多个再次购买
			webtest.open("http://localhost:8036/Home/Order/order_list.html");
			WebElement e7 = getDriver().findElement(By.linkText("再次购买"));
			JavascriptExecutor jse7=(JavascriptExecutor) getDriver();
			for(int i=0;i<4;i++){
				jse7.executeScript("arguments[0].click();", e7);
			}
			Thread.sleep(2000);
////			//默认为全选删除
			WebElement e8 = getDriver().findElement(By.linkText("删除选中的商品"));
			JavascriptExecutor jse8=(JavascriptExecutor) getDriver();
			jse8.executeScript("arguments[0].click();", e8);
			
			
			WebElement e9 = getDriver().findElement(By.id("removeGoods"));
			JavascriptExecutor jse9=(JavascriptExecutor) getDriver();
			jse9.executeScript("arguments[0].click();", e9);	
		}
		
		//单选删除
		@Test(priority=11,description="单选删除")
		public void DelectOne() throws Exception {
			webtest.open("http://localhost:8036/Home/Order/order_list.html");	
			webtest.click("link=再次购买");
			webtest.click("xpath=//*[@id='tpshop-cart']/div[2]/div/div/div[1]/i");
			webtest.click("xpath=//*[@id='edge_10']/div/div[1]/div[1]/i");
			webtest.click("link=删除");	
			webtest.click("id=removeGoods");
		}

		
}
