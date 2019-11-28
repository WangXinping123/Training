package shoppingCart;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestShoppingCart extends BaseTest{
	@Test(priority = 0, description = "��¼")
	public void testLogin() throws Exception {
		// ����ҳ
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(1000);
		// �������¼������
		webtest.click("xpath=//a[@href='/index.php/Home/user/login.html']");

		webtest.type("name=username", "13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1111");
		webtest.click("name=sbtbutton");
		Thread.sleep(800);
		Assert.assertTrue(getDriver().getPageSource().contains("��ȫ�˳�"));
	}
	
	@Test()
	public void test_01_viewCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'�����̳���ҳ')]");
		Thread.sleep(500);
		webtest.click("xpath=//span[contains(text(),'���ﳵ')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("ȫ����Ʒ"));
	}
		
}
