package shoppingCart;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 项目名称：TPSHOP 
 * 类名称：TestCart01 
 * 类描述：点击去购物车结算，删除/收藏商品
 * 		   添加商品，验证购物车内是否有这个商品
 * @author wangxinping 
 * 创建时间：2019年11月29日 下午4:44:52
 * @version
 */
public class TestCart01 extends BaseTest {

	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("退出"));
	}

	// 加入购物车，点击 去购物车结算
	@Test(priority=1,description="加入购物车后")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));
		
		Thread.sleep(200);
	}
	
	@Test(priority=2,description="点击去购物车结算，是否跳转成功")
	public void testSkipToCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'去购物车结算')]");
		Thread.sleep(500);
		webtest.leaveFrame();
		Assert.assertTrue(getDriver().getPageSource().contains("全部商品数"));
	}

	@Test(priority=3,description = "单个商品添加到我的收藏")
	public void testMoveCollectItemButton() throws Exception {
		List<WebElement> c = getDriver().findElements(By.linkText("移到我的收藏"));
		c.get(0).click();
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("已添加至我的收藏"));
		Thread.sleep(500);
	}
	
	@Test(priority=4,description = "删除单个商品（点击商品右侧的删除）")
	public void testDeleteItemButton() throws Exception {
		//String url = "http://localhost:8036/index.php/Home/Cart/index.html";
		//webtest.open(url);
		List<WebElement> d = getDriver().findElements(By.linkText("删除"));
		d.get(0).click();
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("删除商品"));
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		WebElement element= getDriver().findElement(By.id("removeGoods"));
		js.executeScript("arguments[0].click();", element);
	}
	

	@Test(priority=5,description="加入购物车后，点击去购物车结算，购物车内是否有我添加的商品")
	public void test_CartContainsMyGoods() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/16.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));
		webtest.click("xpath=//a[contains(text(),'去购物车结算')]");
		Thread.sleep(500);
		webtest.leaveFrame();
		Thread.sleep(800);
		Assert.assertTrue(getDriver().getPageSource().contains("华为耳机原装手机"));
	}
	
	@Test(priority=6,description="打开购物车，部分商品 移到我的收藏")
	public void testMoveCollectPartSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'移到我的收藏')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("收藏"));
	}
	@Test(priority=8,description="打开购物车，批量删除商品")
	public void testDeletePartSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'删除选中的商品')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("删除商品"));
	}
	
	
	@Test(priority=9,description="打开购物车，选择部分商品，点击去结算")
	public void testPaytotalNoSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("没有选中商品"));
	}	
	

}
