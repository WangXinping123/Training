package shoppingCart;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

/**
 * 项目名称：TPSHOP 类名称：TestToPayAddAddress 类描述：
 * 
 * @author wangxinping 创建时间：2019年12月3日 上午9:21:01
 * @version
 */
// @Listeners(ApiListener.class)
public class TestToPayAddAddress extends BaseTest {
	@Test(priority = 0, description = "登录")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("退出"));
	}

	@Test(priority = 5, description = "加入购物车")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/7.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'加入购物车')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("添加成功"));
		Thread.sleep(200);
	}

	@Test(priority = 10, description = "打开购物车，点击去结算，是否跳转成功")
	public void testPaytotal() throws Exception {
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("购物车"));
	}

	@Test(priority = 15, description = "结算商品，新增地址，正确的地址（成功）")
	public void testAddAddressPass() throws Exception {
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		webtest.click("id=addNewAddress");
		List<WebElement> inputs = getDriver().findElements(By.className("invoice_tt"));
		inputs.get(0).sendKeys("wangxinping");
		inputs.get(1).sendKeys("13786609221");

		Select province = new Select(getDriver().findElement(By.id("province")));
		province.selectByVisibleText("天津市");
		Thread.sleep(100);
		Select city = new Select(getDriver().findElement(By.id("city")));
		city.selectByVisibleText("市辖区");
		Thread.sleep(50);
		Select district = new Select(getDriver().findElement(By.id("district")));
		district.selectByVisibleText("和平区");

		inputs.get(2).sendKeys("河北师范大学");
		inputs.get(3).sendKeys("064000");
		webtest.click("id=address_submit");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("wangxinping"));
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

		Select province = new Select(getDriver().findElement(By.id("province")));
		province.selectByVisibleText(pro);
		Thread.sleep(150);
		Select city = new Select(getDriver().findElement(By.id("city")));
		city.selectByVisibleText("市辖区");
		Thread.sleep(50);
		Select district = new Select(getDriver().findElement(By.id("district")));
		district.selectByVisibleText(dis);

		inputs.get(2).sendKeys(addressMore);
		inputs.get(3).sendKeys(code);
		webtest.click("id=address_submit");
		Assert.assertTrue(getDriver().getPageSource().contains("手机号码格式有误"));
		webtest.click("xpath=//a[contains(text(),'取消')]");
		Thread.sleep(150);
	}

	// 点击 返回修改购物车 按钮
	@Test(priority = 25, description = "点击 返回购物车 按钮")
	public void test_ClickGoBackCart() throws Exception {
		webtest.click("link=返回修改购物车");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("全部商品数"));
		Thread.sleep(300);
	}

	@Test(priority = 30, description = "点击去结算，是否跳转成功")
	public void testClickPaytotal() throws Exception {
		webtest.click("xpath=//a[contains(text(),'去结算')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("购物车"));
	}

	@Test(priority = 35, description = "修改 发票 单位 商品类别")
	public void test_fix_ReceiptCompany() throws Exception {
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=type_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("商品类别"));
	}

	@Test(priority = 40, description = "修改 发票 个人 商品明细")
	public void test_fix_ReceiptPerson() throws Exception {
		Assert.assertTrue(getDriver().getPageSource().contains("购物车"));
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=detail_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("商品明细"));
	}
	
	@Test(priority = 41, description = "修改 发票 个人 商品类别")
	public void test_fix_ReceiptPerson2() throws Exception {
		Assert.assertTrue(getDriver().getPageSource().contains("购物车"));
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=type_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("商品类别"));
	}

	@Test(priority = 45, description = "修改 发票 个人 不开发票")
	public void test_fix_ReceiptNoPerson() throws Exception {
		webtest.click("link=修改");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=no_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("不开发票"));
	}

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
		Assert.assertTrue(getDriver().getPageSource().contains("商品明细"));
	}

}
