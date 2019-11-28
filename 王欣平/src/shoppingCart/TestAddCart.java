package shoppingCart;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.remote.SlavePool;

import com.webtest.core.BaseTest;
import com.webtest.core.ApiListener;
import com.webtest.dataprovider.ExcelDataProvider;

@Listeners({ ApiListener.class })
public class TestAddCart extends BaseTest {

	public int i = 0;
	
	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		// 打开网页
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(1000);
		// 点击“登录”链接
		webtest.click("xpath=//a[@href='/index.php/Home/user/login.html']");

		webtest.type("name=username", "13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1111");
		webtest.click("name=sbtbutton");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("安全退出"));
	}

	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("E:/data/property.xlsx", "Sheet1");
	}

	@Test(description = "选择商品")
	public void test_choose() throws Exception {
		// 选择商品
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		webtest.click("xpath=//a[contains(text(),'返回商城首页')]");
		Thread.sleep(500);
		webtest.click("xpath=//a[contains(text(),'手机城')]");
		Thread.sleep(500);

		// 跳转到商品列表
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());

		WebElement ele = getDriver().findElement(By.xpath("//a[@href='/index.php/Home/Goods/goodsInfo/id/1.html']"));
		// 选择商品
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(500);
		// 跳转到商品详情页
		webtest.getWindow(2);
		System.out.println(webtest.getTitle());
		Thread.sleep(200);
	}

	@Test(description="打开商品详情")
	public void test_Open1() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Goods/goodsInfo/id/1.html");
		Thread.sleep(200);
	}
	
	// 多次添加同一商品不同属性
	@Test(dataProvider = "excel", dependsOnMethods="test_Open1",
			description = "登录，同一商品不同属性添加多次")
	public void test_03_AddCartDifferentProperty(String version, String color, String type)
			throws Exception{
		i++;// iframe id每次都加1
		// 选择版本
		webtest.click("xpath=//a[contains(text(),'" + version + "')]");
		// 选择颜色
		webtest.click("xpath=//a[contains(text(),'" + color + "')]");
		// 套餐类型
		webtest.click("xpath=//a[contains(text(),'" + type + "')]");
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(500);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + i));
		getDriver().switchTo().frame(frame);
		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}
	
	//加入购物车，点击 去购物车结算
	@Test
	public void test_04_chooseAccount(){
		String url="/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		
	}
	
	

}
