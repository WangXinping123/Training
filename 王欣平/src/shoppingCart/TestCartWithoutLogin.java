package shoppingCart;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;

/**
 * 项目名称：TPSHOP   
 * 类名称：TestCartWithoutLogin   
 * 类描述： 不登录时，查看购物车，加入购物车
 * @author wangxinping 
 * 创建时间：2019年11月29日 下午4:27:26   
 * @version  
 */

public class TestCartWithoutLogin extends BaseTest {

	@Test(priority=0,description = "打开网站")
	public void testOpen() throws Exception {
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(2000);
	}

	// 未登录，查看购物车
	@Test(priority=1,description = "未登录，查看购物车")
	public void test_01_ViewCart() throws Exception {
		
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("xpath=//a[@href='/index.php/Home/Cart/index.html']/div");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("登录"));
		Thread.sleep(1000);
	}

	// 未登录，加入购物车
	@Test(priority=2,description = "未登录，加入购物车")
	public void test_02_AddCart() throws Exception {
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(800);
		}
		webtest.click("xpath=//a[contains(text(),'手机')]");
		Thread.sleep(500);
		// 跳转到 搜索列表
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		WebElement ele = getDriver().findElement(By.xpath("//a[@href='/index.php/Home/Goods/goodsInfo/id/1.html']"));
		// 选择商品
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(2000);
		// 选择版本
		webtest.click("xpath=//a[contains(text(),'全网通4G+64G')]");
		// 选择颜色
		webtest.click("xpath=//a[contains(text(),'极光色')]");
		// webtest.click(locator);
		// 套餐类型
		webtest.click("xpath=//a[contains(text(),'套餐二')]");
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(500);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("登录"));
		Thread.sleep(2000);
	}
	
	@Test(priority = 4, description = "登录")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("退出"));
	}
	
	@Test(priority=5,description="点击购物车图标")
	public void test_01_viewCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'返回商城首页')]");
		Thread.sleep(500);
		webtest.click("xpath=//span[contains(text(),'购物车')]");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("全部商品"));
	}
	

}
