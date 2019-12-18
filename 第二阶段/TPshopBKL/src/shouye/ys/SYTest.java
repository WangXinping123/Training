package shouye.ys;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
/**
 * 项目名称：TPshopBKL   
 * 前台首页：（搜索，跳转，链接等），商品评价，退货 
 * @author 杨硕 
 */
public class SYTest extends BaseTest {
	@Test(description = "首页跳转测试未登入1")
	public void SYtest1() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'手机城')]");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'电器城')]");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'团购')]");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'首页')]");
		assertTrue(webtest.isTextPresent("手机城"));
	}

	@Test(description = "首页跳转功能未登入2")
	public void SYtest2() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'登录')]");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("账户登录"));
	}

	@Test(description = "首页跳转功能未登入3")
	public void SYtest3() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(2000);
		webtest.click("class=c-n fl");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("购物车内暂时没有商品，登录后将显示您之前加入的商品 "));
	}

	@Test(description = "首页跳转功能未登入4")
	public void SYtest4() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'我的订单')]");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("账户登入 "));
	}

	@Test(description = "首页跳转功能未登入5")
	public void SYtest5() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=carousel-control left-btn t-all");
		Thread.sleep(200);
		webtest.click("class=carousel-control left-btn t-all");
		Thread.sleep(200);
		webtest.click("class=carousel-control left-btn t-all");
		Thread.sleep(200);
		webtest.click("class=carousel-control right-btn t-all");
		Thread.sleep(200);
		webtest.click("class=carousel-control right-btn t-all");
		Thread.sleep(200);
		webtest.click("class=carousel-control right-btn t-all");
		assertTrue(webtest.isTextPresent("全部商品分类 "));
	}

	@Test(description = "首页跳转功能未登入6")
	public void SYtest6() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=sbar-hover-txt");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("微信账号"));
	}

	@Test(description = "首页跳转功能未登入7")
	public void SYtest7() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=nav-dh");
		webtest.click("xpath=//a[contains(text(),'兑换中心')]");
		assertTrue(webtest.isTextPresent("积分商城"));
	}

	@Test(description = "首页跳转功能未登入8")
	public void SYtest8() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=nav-dh");
		webtest.click("xpath=//a[contains(text(),'淘宝网')]");
		assertTrue(webtest.isTextPresent("中国大陆手机逛淘宝"));
	}

	@Test(description = "首页跳转功能未登入9")
	public void SYtest9() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=floor-goods-item");
		assertTrue(webtest.isTextPresent("立即购买中国大陆手机逛淘宝"));
	}

	@Test(description = "首页跳转功能未登入10")
	public void SYtest10() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=nav-more-btn");
		assertTrue(webtest.isTextPresent("全部商品分类"));
	}

}
