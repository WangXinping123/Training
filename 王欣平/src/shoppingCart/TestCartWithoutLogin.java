package shoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;

@Listeners({ApiListener.class})
public class TestCartWithoutLogin extends BaseTest {

	@Test(priority=0,description = "打开网站")
	public void testOpen() throws Exception {
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(2000);
	}

	// 未登录，查看购物车
	@Test(description = "未登录，查看购物车")
	public void test_01_ViewCart() throws Exception {
		
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("xpath=//a[@href='/index.php/Home/Cart/index.html']/div");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("登录"));
		Thread.sleep(1000);
	}

	// 未登录，加入购物车
	@Test(description = "未登录，加入购物车")
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

		Assert.assertTrue(getDriver().getPageSource().contains("登录"));

		/*WebElement frame = getDriver().findElement(By.id("layui-layer-iframe1"));
		getDriver().switchTo().frame(frame);
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(500);
		getDriver().switchTo().defaultContent();*/
		Thread.sleep(2000);
	}

}
