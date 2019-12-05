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
 * ��Ŀ���ƣ�TPSHOP �����ƣ�TestToPayAddAddress ��������
 * 
 * @author wangxinping ����ʱ�䣺2019��12��3�� ����9:21:01
 * @version
 */
// @Listeners(ApiListener.class)
public class TestToPayAddAddress extends BaseTest {
	@Test(priority = 0, description = "��¼")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("�˳�"));
	}

	@Test(priority = 5, description = "���빺�ﳵ")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/7.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));
		Thread.sleep(200);
	}

	@Test(priority = 10, description = "�򿪹��ﳵ�����ȥ���㣬�Ƿ���ת�ɹ�")
	public void testPaytotal() throws Exception {
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'ȥ����')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("���ﳵ"));
	}

	@Test(priority = 15, description = "������Ʒ��������ַ����ȷ�ĵ�ַ���ɹ���")
	public void testAddAddressPass() throws Exception {
		webtest.click("xpath=//a[contains(text(),'ȥ����')]");
		Thread.sleep(200);
		webtest.click("id=addNewAddress");
		List<WebElement> inputs = getDriver().findElements(By.className("invoice_tt"));
		inputs.get(0).sendKeys("wangxinping");
		inputs.get(1).sendKeys("13786609221");

		Select province = new Select(getDriver().findElement(By.id("province")));
		province.selectByVisibleText("�����");
		Thread.sleep(100);
		Select city = new Select(getDriver().findElement(By.id("city")));
		city.selectByVisibleText("��Ͻ��");
		Thread.sleep(50);
		Select district = new Select(getDriver().findElement(By.id("district")));
		district.selectByVisibleText("��ƽ��");

		inputs.get(2).sendKeys("�ӱ�ʦ����ѧ");
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

	@Test(priority = 20, dataProvider = "address", description = "������Ʒ��������ַ��������ֻ�����")
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
		city.selectByVisibleText("��Ͻ��");
		Thread.sleep(50);
		Select district = new Select(getDriver().findElement(By.id("district")));
		district.selectByVisibleText(dis);

		inputs.get(2).sendKeys(addressMore);
		inputs.get(3).sendKeys(code);
		webtest.click("id=address_submit");
		Assert.assertTrue(getDriver().getPageSource().contains("�ֻ������ʽ����"));
		webtest.click("xpath=//a[contains(text(),'ȡ��')]");
		Thread.sleep(150);
	}

	// ��� �����޸Ĺ��ﳵ ��ť
	@Test(priority = 25, description = "��� ���ع��ﳵ ��ť")
	public void test_ClickGoBackCart() throws Exception {
		webtest.click("link=�����޸Ĺ��ﳵ");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("ȫ����Ʒ��"));
		Thread.sleep(300);
	}

	@Test(priority = 30, description = "���ȥ���㣬�Ƿ���ת�ɹ�")
	public void testClickPaytotal() throws Exception {
		webtest.click("xpath=//a[contains(text(),'ȥ����')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("���ﳵ"));
	}

	@Test(priority = 35, description = "�޸� ��Ʊ ��λ ��Ʒ���")
	public void test_fix_ReceiptCompany() throws Exception {
		webtest.click("link=�޸�");
		Thread.sleep(50);
		webtest.click("id=type_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ʒ���"));
	}

	@Test(priority = 40, description = "�޸� ��Ʊ ���� ��Ʒ��ϸ")
	public void test_fix_ReceiptPerson() throws Exception {
		Assert.assertTrue(getDriver().getPageSource().contains("���ﳵ"));
		webtest.click("link=�޸�");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=detail_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ʒ��ϸ"));
	}
	
	@Test(priority = 41, description = "�޸� ��Ʊ ���� ��Ʒ���")
	public void test_fix_ReceiptPerson2() throws Exception {
		Assert.assertTrue(getDriver().getPageSource().contains("���ﳵ"));
		webtest.click("link=�޸�");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=type_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ʒ���"));
	}

	@Test(priority = 45, description = "�޸� ��Ʊ ���� ������Ʊ")
	public void test_fix_ReceiptNoPerson() throws Exception {
		webtest.click("link=�޸�");
		Thread.sleep(50);
		webtest.click("id=personage");
		webtest.click("id=no_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("������Ʊ"));
	}

	@Test(priority = 55, description = "�޸� ��Ʊ ��˾ ")
	public void test_fix_ReceiptCompany2() throws Exception {
		webtest.click("link=�޸�");
		Thread.sleep(50);
		webtest.click("id=detail_invoice");
		webtest.click("id=addinvoice");
		//webtest.type("xpath=//input[@id='invoice_title']", "�����ѱ��������޹�˾");
		//webtest.type("id=taxpayer", "914403003727509865");
		webtest.click("id=detail_invoice");
		webtest.click("id=invoiceBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ʒ��ϸ"));
	}

}
