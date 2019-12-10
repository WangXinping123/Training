package yjp;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.demo.Front_login;

public class Notice extends BaseTest {
	/**
	 * 消息通知
	 */
	static public String url = "http://localhost:8036/";

	Login action;

	@BeforeClass(description = "登录")
	public void setup() throws Exception {
		action = new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");

		for (int i = 1; i < 5; i++) {
			webtest.downClick();
		}
		webtest.click("link=消息通知");

	}

	@Test(description = "删除一条通知消息", priority = 1)
	public void delOne() {

		webtest.click("link=/Home/User/message_notice/type/2.html");
		webtest.click("xpath=//ul[@class='logist_lists']/li[1]/div[2]/div[1]/a");
		webtest.click("link=是");
	}

	@Test(description = "选择一条通知消息，点击查看详情", priority = 2)
	public void details() {
		webtest.click("xpath=//ul[@class='logist_lists']/li[1]/div[2]/div[3]/a");
		assertTrue(webtest.isElementPresent("订单详情"));
	}

	// @Test(description="全选删除",priority=3)
	public void delAll() {
		// webtest.click("消息通知");
		webtest.click("link=/Home/User/message_notice/type/2.html");
		webtest.click("xpath=//input[@id='checkAll']");
		webtest.click("xpath=//div[@class='mesg_tit']/a");
		webtest.click("link=是");
	}

}
