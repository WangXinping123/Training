package shoppingCart;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

@Listeners({ ApiListener.class })
public class TestAddCartNumber extends BaseTest{
	public int a=0;
	
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
		Thread.sleep(3000);
		Assert.assertTrue(getDriver().getPageSource().contains("安全退出"));
	}
	
	@Test(priority=1,description="打开商品详情25")
	public void test_Open2() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Goods/goodsInfo/id/25.html");
		Thread.sleep(200);
	}
	

	@Test(priority=5,description = "点击一次商品数量右侧的+号",dependsOnMethods="test_Open2")
	public void test_04_addGoodsNuByButton1() throws Exception {
		//action.moveByOffset(100, 200).release()
		a++;// iframe id每次都加1
		// 选择数量
		webtest.click("xpath=//div[@class=minus-plus]/a[@class=add]");
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(5000);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}
		
	
	@Test(priority=10,description = "点击多次商品数量右侧的+号")
	public void test_05_addGoodsNuByButton2() throws Exception {
		System.out.println(webtest.getTitle());
		//action.moveByOffset(100, 200).release()
		a++;// iframe id每次都加1
		int m;
		for(m=0;m<5;m++){
			webtest.click("class=add");
		}		
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(500);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}
	
	@Test(priority=15,description = "点击商品数量左侧的-号")
	public void test_06_addGoodsNuByButton2() throws Exception {
		System.out.println(webtest.getTitle());
		a++;// iframe id每次都加1
		int m;
		for(m=0;m<5;m++){
			webtest.click("class=mins");
		}
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(500);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}	
	
	// 登录，添加商品数量为-1
	@Test(priority=20,description = "选择商品数量: -1 失败")
	public void test_08_addGoodsNumFail01() throws Exception {
		a++;// iframe id每次都加1
		// 选择数量	
		webtest.type("id=number", "-1");	
		webtest.tapClick();
		//webtest.tapClick();

		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(1000);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("添加失败"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
	}

	// 登录，添加商品数量为 0
	@Test(priority=25, description = "选择商品数量 0  失败")
	public void test_10_addGoodsNumFail02() throws Exception {
		a++;// iframe id每次都加1
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		// 选择数量
		webtest.type("id=number", "-1");	
		webtest.tapClick();
		//webtest.tapClick();
		
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(2000);

		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("添加失败"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
	}

	// 登录，添加商品数量为 库存数+1
	@Test(priority=30,description = "选择商品数量  库存数+1 失败")
	public void test_12_addGoodsNumFail03() throws Exception {
		a++;// iframe id每次都加1
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
		// 选择数量
		webtest.type("id=number", "100");	
		webtest.tapClick();
		
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("商品库存不足"));
		
		webtest.click("xpath=//a[contains(text(),'确定')]");
		Thread.sleep(200);
	}
}
