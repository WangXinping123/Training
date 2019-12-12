package yjp;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.demo.Front_login;

/**
 * 我的评价
 * 
 * @author yjp
 *
 */
public class Evaluation extends BaseTest {
	static public String url = "http://localhost:8036/";

	Login action;

	@BeforeClass(description = "登录")
	public void setup() throws Exception {
		action = new Login(webtest);
		webtest.open(url);
		Thread.sleep(2000);
		action.login("13800138006", "123456");

		webtest.click("link=我的评价");

	}

	@Test(priority = 1, description = "已评论区查看商品评论")
	public void seeEval() throws Exception {
		webtest.click("link=已评论");
		Thread.sleep(200);
		// webtest.click("xpath=//div[@class='order-alone-li']/table[1]/tbody/tr[2]/td[6]/div/p/a");
		assertTrue(webtest.isTextPresent("吉利汽车2019"));

	}

	@Test(priority = 3, description = "对待评论订单进行评论")
	public void eval() {
		webtest.click("link=待评论订单");
		webtest.click("xpath=//div[@class='order-alone-li']/table/tbody/tr[2]/td[6]/div/p/a");
		assertTrue(webtest.isTextPresent("评价订单"));
	}

}
