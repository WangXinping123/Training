package lixiaoyue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.demo.Front_login;
import com.webtest.demo.Login_Action;
import com.webtest.utils.ReadProperties;

public class Test_DingDan extends BaseTest {

	Front_login action;

	@BeforeMethod
	public void setup() {
		action = new Front_login(webtest);
	}

	// 登录
	@Test(priority = 0, description = "登录")
	public void Entry() throws InterruptedException {
		action.login("13800138006", "123456");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(webtest.isTextPresent("安全退出"));
		Thread.sleep(2000);
	}

	// 登录的情况下查看全部订单
	@Test(priority = 1, description = "查看我的订单")
	public void MyDd() throws InterruptedException {
		webtest.click("link=我的订单");
		AssertJUnit.assertTrue(webtest.isTextPresent("全部订单"));
	}

	// 添加订单（一会需要查询的订单）
	@Test(priority = 2, description = "添加订单（一会需要查询的订单）")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/Home/Goods/goodsInfo/id/262.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=去购物车结算");
		webtest.click("xpath=//*[@id='layui-layer1']/span/a");
		webtest.leaveFrame();
		webtest.click("link=去结算");
		webtest.click("id=submit_order");
	}

	@Test(priority = 3, description = "查询")
	public void CheckBy0() throws Exception {
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", "201909191108196628");
		WebElement e1 = getDriver().findElement(By.xpath("//*[@id='search_order']/input[2]"));
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();", e1);
		Thread.sleep(1000);
		// 断言
		Assert.assertTrue(getDriver().getPageSource().contains("订单编号："));
	}

	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "ChaXun.xlsx",
				"Sheet1");
	}

	@Test(priority = 4, dataProvider = "excel", description = "查询")
	public void CheckBy(String name, String message2) throws Exception {
		webtest.click("xpath=//*[@id='navitems5']/ul/li[1]/a");
		webtest.getWindow(0);
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", name);
		WebElement e1 = getDriver().findElement(By.xpath("//*[@id='search_order']/input[2]"));
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();", e1);
		Thread.sleep(1000);
		// 断言
		Assert.assertTrue(getDriver().getPageSource().contains("订单编号："));
	}

	// 再次购买一个
	@Test(priority = 5, description = "再次购买")
	public void BuyAgain() throws Exception {
		webtest.getWindow(1);
		webtest.click("link=全部订单");
		WebElement e5 = getDriver().findElement(By.linkText("再次购买"));
		JavascriptExecutor jse5 = (JavascriptExecutor) getDriver();
		jse5.executeScript("arguments[0].click();", e5);
		Thread.sleep(2000);
		webtest.click("link=去结算");
		webtest.click("id=submit_order");
		Assert.assertTrue(getDriver().getPageSource().contains("订单提交成功"));
	}

	// 查看订单详情
	@Test(priority = 6, description = "查看详情")
	public void LookDetail() throws Exception {
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		// 查看订单详情
		WebElement e4 = getDriver().findElement(By.linkText("查看详情"));
		JavascriptExecutor jse4 = (JavascriptExecutor) getDriver();
		jse4.executeScript("arguments[0].click();", e4);
		Thread.sleep(3000);
		Assert.assertTrue(getDriver().getPageSource().contains("感谢您在商城购物，欢迎您对本次交易及所购商品进行评价。"));
	}

	//
	// 立即付款
	@Test(priority = 7, description = "立即付款")
	public void Right() throws Exception {
		webtest.click("link=立即付款");
		Thread.sleep(2000);
		Assert.assertTrue(getDriver().getPageSource().contains("订单提交成功"));
	}

	//
	@Test(priority = 8, description = "选择付款方式0")
	public void BuyWay0() throws Exception {
		// webtest.open("http://localhost:8036/index.php?m=Home&c=Cart&a=cart4&order_sn=201912061538372315");
		webtest.click("xpath=//*[@id='cart4_form']/div/div/dl/dd/div/div[2]/ul/li[1]/div/label/img");
		webtest.click("link=确认支付方式");
		webtest.getWindow(1);
		Assert.assertTrue(getDriver().getPageSource().contains("商业用途务必购买正版,使用盗版将依法追究法律责任!!"));
	}

	@DataProvider(name = "excelaa")
	public Object[][] getExcelDadaa() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "Way.xlsx",
				"Sheet1");
	}

	// 选择付款方式
	@Test(priority = 9, dataProvider = "excelaa", description = "选择付款方式")
	public void BuyWay(String way) throws Exception {
		String url = "http://localhost:8036/Home/Goods/goodsInfo/id/262.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=去购物车结算");
		webtest.click("xpath=//*[@id='layui-layer1']/span/a");
		webtest.leaveFrame();
		webtest.click("link=去结算");
		webtest.click("id=submit_order");
		// webtest.open("http://localhost:8036/Home/Cart/cart4/order_id/1543.html");
		webtest.click("xpath=" + way);
		webtest.click("link=确认支付方式");
		Assert.assertTrue(getDriver().getPageSource().contains("商业用途务必购买正版,使用盗版将依法追究法律责任!!"));
	}

	@Test(priority = 10, description = "取消订单")
	public void Delectedddd() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=去购物车结算");
		webtest.leaveFrame();
		webtest.click("link=去结算");
		webtest.click("id=submit_order");
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		// 查看订单详情
		WebElement e4 = getDriver().findElement(By.linkText("查看详情"));
		JavascriptExecutor jse4 = (JavascriptExecutor) getDriver();
		jse4.executeScript("arguments[0].click();", e4);
		Thread.sleep(2000);
		webtest.click("link=取消订单");
		webtest.click("link=确定");
		webtest.click("xpath=//*[@id='layui-layer2']/div[3]/a");
		Assert.assertTrue(getDriver().getPageSource().contains("已取消"));
	}

	// 再次购买数量
	@Test(priority = 11, description = "再次购买改变数量")
	public void BuyAgain2() throws Exception {
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		WebElement e5 = getDriver().findElement(By.linkText("再次购买"));
		JavascriptExecutor jse5 = (JavascriptExecutor) getDriver();
		jse5.executeScript("arguments[0].click();", e5);
		webtest.getWindow(1);
		Thread.sleep(2000);
		webtest.click("link=-");
		webtest.click("link=去结算");
		webtest.click("id=submit_order");
		Assert.assertTrue(getDriver().getPageSource().contains("订单提交成功"));
	}

	//
	// 多选收藏
	@Test(priority = 12, description = "多选收藏")
	public void SaveObject() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("link=去购物车结算");
		webtest.leaveFrame();
		webtest.click("xpath=/html/body/div[4]/div/div/div/div[1]/div/a[2]");
		Assert.assertTrue(getDriver().getPageSource().contains("收藏"));
	}

	// 单选收藏
	@Test(priority = 13, description = "单选收藏")
	public void SaveOne() throws Exception {
		webtest.open("http://localhost:8036/home/Cart/index.html");
		WebElement e10 = getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/div/a[2]"));
		JavascriptExecutor jse10 = (JavascriptExecutor) getDriver();
		jse10.executeScript("arguments[0].click();", e10);

		webtest.click("xpath=//*[@id='edge_45']/div/div[1]/div[1]/i");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(webtest.isTextPresent("已添加至我的收藏"));
	}

	// 单选删除
	@Test(priority = 14, description = "单选删除")
	public void DelectOne() throws Exception {
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		webtest.click("link=再次购买");
		webtest.click("xpath=//*[@id='tpshop-cart']/div[2]/div/div/div[1]/i");
		webtest.click("xpath=//*[@id='edge_10']/div/div[1]/div[1]/i");
		webtest.click("link=删除");
		webtest.click("id=removeGoods");
	}
}
