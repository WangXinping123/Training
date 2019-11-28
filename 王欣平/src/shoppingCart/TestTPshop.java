package shoppingCart;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

import com.google.common.base.Throwables;
import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

//@Listeners({ApiListener.class})
public class TestTPshop extends BaseTest {
	public int i=0;
	
	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		// 打开网页
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(5000);
		// 点击“登录”链接
		webtest.click("xpath=//a[@href='/index.php/Home/user/login.html']");

		webtest.type("name=username", "13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1111");
		webtest.click("name=sbtbutton");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("安全退出"));
	}

	

}
