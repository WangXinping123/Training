package wxp_ShoppingCart;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.demo.Front_login;
import com.webtest.utils.ReadProperties;

/**
 * 项目名称：TPSHOP 类名称：TestToPayAddAddress 类描述：
 * 
 * @author wangxinping 创建时间：2019年12月3日 上午9:21:01
 * @version
 */
//@Listeners(ApiListener.class)
public class TestToPayAddAddress extends BaseTest {
	// 登录
	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		baseLogin("13800138006", "123456");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("退出"));
	}

	@Test(priority = 5, description = "加入购物车")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/7.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("添加成功"));
		Thread.sleep(200);
	}

	@Test(priority = 10, description = "打开购物车，点击去结算，是否跳转成功")
	public void testPaytotal() throws Exception {
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("购物车"));
	}

	@Test(priority = 15, description = "结算商品，新增地址，正确的地址（成功）")
	public void testAddAddressPass() throws Exception {
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		webtest.click("id=addNewAddress");
		List<WebElement> inputs = getDriver().findElements(By.className("invoice_tt"));
		inputs.get(0).sendKeys("wangxinping");
		inputs.get(1).sendKeys("13786609221");
		
		webtest.selectByVisibleText("id=province", "天津市");
		webtest.selectByVisibleText("id=city", "市辖区");
		webtest.selectByVisibleText("id=district", "和平区");

		inputs.get(2).sendKeys("河北师范大学");
		inputs.get(3).sendKeys("064000");
		webtest.click("id=address_submit");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("wangxinping"));
		Thread.sleep(500);
	}

	@DataProvider(name = "address")
	public Object[][] getExcelData() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"address.xlsx", "Sheet1");
	}
	
	@Test(priority = 20, dataProvider = "address", description = "结算商品，新增地址，错误的手机号码")
	public void test_AddAddressFail(String name, String phoneNumber, String pro, String dis, String addressMore,
			String code) throws Exception {
		webtest.click("id=addNewAddress");
		List<WebElement> inputs = getDriver().findElements(By.className("invoice_tt"));
		inputs.get(0).sendKeys(name);
		inputs.get(1).sendKeys(phoneNumber);
		
		webtest.selectByVisibleText("id=province", pro);
		webtest.selectByVisibleText("id=city", "市辖区");
		webtest.selectByVisibleText("id=district", dis);
		
		inputs.get(2).sendKeys(addressMore);
		inputs.get(3).sendKeys(code);
		webtest.click("id=address_submit");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("手机号码格式有误"));
		Thread.sleep(100);
		webtest.click("class=btn-9");
		//webtest.click("xpath=//a[contains(text(),'取消')]");
		Thread.sleep(200);
	}
	
	// 点击 返回修改购物车 按钮
	@Test(priority = 25, description = "点击 返回购物车 按钮")
	public void test_ClickGoBackCart() throws Exception {
		webtest.click("link=返回修改购物车");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("全部商品数"));
		Thread.sleep(300);
	}

	@Test(priority = 30, description = "点击去结算，是否跳转成功")
	public void testClickPaytotal() throws Exception {
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("购物车"));
	}

	@Test(priority = 35, description = "修改 发票 单位 商品类别")
	public void test_fix_ReceiptCompany() throws Exception {
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=type_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品类别"));
	}
	
	@DataProvider(name = "receipt")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"receipt.xlsx", "Sheet1");
	}
	

	@Test(priority = 40, description = "修改 发票 个人 商品明细")
	public void test_fix_ReceiptPerson(String choice,String result) throws Exception {
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("购物车"));
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id="+choice);
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(result));
	}
	
//	@Test(priority = 41, description = "修改 发票 个人 商品类别")
//	public void test_fix_ReceiptPerson2() throws Exception {
//		AssertJUnit.assertTrue(getDriver().getPageSource().contains("购物车"));
//		webtest.click("link=修改");
//		Thread.sleep(50);
//		webtest.click("id=personage");
//		webtest.click("id=type_invoice");
//		webtest.click("id=invoiceBtn");
//		Thread.sleep(100);
//		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品类别"));
//	}
//
//	@Test(priority = 45, description = "修改 发票 个人 不开发票")
//	public void test_fix_ReceiptNoPerson() throws Exception {
//		webtest.click("link=修改");
//		Thread.sleep(50);
//		webtest.click("id=personage");
//		webtest.click("id=no_invoice");
//		webtest.click("id=invoiceBtn");
//		Thread.sleep(100);
//		AssertJUnit.assertTrue(getDriver().getPageSource().contains("不开发票"));
//	}

	@Test(priority = 55, description = "修改 发票 公司 ")
	public void test_fix_ReceiptCompany2() throws Exception {
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=detail_invoice");
		webtest.click("id=addinvoice");
		//webtest.type("xpath=//input[@id='invoice_title']", "深圳搜豹网络有限公司");
		//webtest.type("id=taxpayer", "914403003727509865");
		webtest.click("id=detail_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("商品明细"));
	}

}
