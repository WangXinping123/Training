package shoppingCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestShoppingCart extends BaseTest{
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
		Thread.sleep(800);
		Assert.assertTrue(getDriver().getPageSource().contains("安全退出"));
	}
	
	@Test()
	public void test_01_viewCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'返回商城首页')]");
		Thread.sleep(500);
		webtest.click("xpath=//span[contains(text(),'购物车')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("全部商品"));
	}
		
}
