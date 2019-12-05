package shoppingCart;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.remote.SlavePool;

import com.webtest.core.BaseTest;
import com.webtest.core.ApiListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;


/**
 * 项目名称：TPSHOP   
 * 类名称：TestAddCart   
 * 类描述： 多次添加不同属性的相同商品
 * @author wangxinping 
 * 创建时间：2019年11月29日 下午4:26:14   
 * @version  
 */
public class TestAddCart extends BaseTest {

	public int i = 0;
	public int a = 0;

	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("退出"));
	}

	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"property.xlsx", "Sheet1");
	}

	@Test(priority=2,description = "打开商品详情")
	public void test_Open1() throws Exception {
		webtest.open("http://localhost:8036/index.php/Home/Goods/goodsInfo/id/1.html");
		Thread.sleep(800);
	}

	// 多次添加同一商品不同属性
	@Test(priority=3,dataProvider = "excel", description = "登录，同一商品不同属性添加多次")
	public void test_03_AddCartDifferentProperty(String version, String color, String type) throws Exception {
		i++;// iframe id每次都加1
		// 选择版本
		webtest.click("xpath=//a[contains(text(),'" + version + "')]");
		// 选择颜色
		webtest.click("xpath=//a[contains(text(),'" + color + "')]");
		// 套餐类型
		webtest.click("xpath=//a[contains(text(),'" + type + "')]");
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe" + i);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加成功"));
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(100);
		webtest.leaveFrame();
		Thread.sleep(1000);
	}
	
	@Test(priority = 5, description = "打开商品详情25")
	public void test_Open2() throws Exception {
		webtest.open("http://localhost:8036/index.php/Home/Goods/goodsInfo/id/25.html");
		Thread.sleep(200);
	}

	@Test(priority = 7, description = "点击一次商品数量右侧的+号", dependsOnMethods = "test_Open2")
	public void test_04_addGoodsNuByButton1() throws Exception {
		// action.moveByOffset(100, 200).release()
		a++;// iframe id每次都加1
		// 选择数量
		webtest.click("xpath=//div[@class=minus-plus]/a[@class=add]");
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe" + a);

		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加成功"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(1000);
	}

	@Test(priority = 10, description = "点击多次商品数量右侧的+号")
	public void test_05_addGoodsNuByButton3() throws Exception {
		System.out.println(webtest.getTitle());
		// action.moveByOffset(100, 200).release()
		a++;// iframe id每次都加1
		int m;
		for (m = 0; m < 5; m++) {
			webtest.click("class=add");
		}
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe" + a);

		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加成功"));

		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(1000);
	}

	@Test(priority = 15, description = "点击商品数量左侧的-号")
	public void test_06_addGoodsNuByButton2() throws Exception {
		System.out.println(webtest.getTitle());
		a++;// iframe id每次都加1
		int m;
		for (m = 0; m < 5; m++) {
			webtest.click("class=mins");
		}
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe" + a);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加成功"));
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(1000);
	}

	// 登录，添加商品数量为-1
	@Test(priority = 20, description = "选择商品数量: -1 失败")
	public void test_08_addGoodsNumFail01() throws Exception {
		a++;// iframe id每次都加1
		// 选择数量
		webtest.type("id=number", "-1");
		webtest.tapClick();
		// webtest.tapClick();
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe" + a);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加失败"));
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(2000);
	}

	// 登录，添加商品数量为 0
	@Test(priority = 25, description = "选择商品数量 0  失败")
	public void test_10_addGoodsNumFail02() throws Exception {
		a++;// iframe id每次都加1
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(2000);
		// 选择数量
		webtest.type("id=number", "-1");
		webtest.tapClick();
		// webtest.tapClick();
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(2000);
		webtest.enterFrame("layui-layer-iframe" + a);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加失败"));
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(2000);
	}

	// 登录，添加商品数量为 库存数+1
	@Test(priority = 30, description = "选择商品数量  库存数+1 失败")
	public void test_12_addGoodsNumFail03() throws Exception {
		a++;// iframe id每次都加1
		webtest.click("xpath=//a[contains(text(),'继续购物')]");
		Thread.sleep(200);
		webtest.leaveFrame();
		Thread.sleep(1000);
		// 选择数量
		webtest.type("id=number", "100");
		webtest.tapClick();
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品库存不足"));
		webtest.click("xpath=//a[contains(text(),'确定')]");
		Thread.sleep(200);
	}

}
