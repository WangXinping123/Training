package shoppingCart;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;

/**
 * ��Ŀ���ƣ�TPSHOP   
 * �����ƣ�TestCartWithoutLogin   
 * �������� ����¼ʱ���鿴���ﳵ�����빺�ﳵ
 * @author wangxinping 
 * ����ʱ�䣺2019��11��29�� ����4:27:26   
 * @version  
 */

public class TestCartWithoutLogin extends BaseTest {

	@Test(priority=0,description = "����վ")
	public void testOpen() throws Exception {
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(2000);
	}

	// δ��¼���鿴���ﳵ
	@Test(priority=1,description = "δ��¼���鿴���ﳵ")
	public void test_01_ViewCart() throws Exception {
		
		if (getDriver().getPageSource().contains("��ȫ�˳�")) {
			// �˳���¼
			webtest.click("xpath=//a[contains(text(),'��ȫ�˳�')]");
			Thread.sleep(2000);
		}
		webtest.click("xpath=//a[@href='/index.php/Home/Cart/index.html']/div");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("��¼"));
		Thread.sleep(1000);
	}

	// δ��¼�����빺�ﳵ
	@Test(priority=2,description = "δ��¼�����빺�ﳵ")
	public void test_02_AddCart() throws Exception {
		if (getDriver().getPageSource().contains("��ȫ�˳�")) {
			// �˳���¼
			webtest.click("xpath=//a[contains(text(),'��ȫ�˳�')]");
			Thread.sleep(800);
		}
		webtest.click("xpath=//a[contains(text(),'�ֻ�')]");
		Thread.sleep(500);
		// ��ת�� �����б�
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		WebElement ele = getDriver().findElement(By.xpath("//a[@href='/index.php/Home/Goods/goodsInfo/id/1.html']"));
		// ѡ����Ʒ
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(2000);
		// ѡ��汾
		webtest.click("xpath=//a[contains(text(),'ȫ��ͨ4G+64G')]");
		// ѡ����ɫ
		webtest.click("xpath=//a[contains(text(),'����ɫ')]");
		// webtest.click(locator);
		// �ײ�����
		webtest.click("xpath=//a[contains(text(),'�ײͶ�')]");
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(500);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("��¼"));
		Thread.sleep(2000);
	}
	
	@Test(priority = 4, description = "��¼")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("�˳�"));
	}
	
	@Test(priority=5,description="������ﳵͼ��")
	public void test_01_viewCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'�����̳���ҳ')]");
		Thread.sleep(500);
		webtest.click("xpath=//span[contains(text(),'���ﳵ')]");
		Thread.sleep(200);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("ȫ����Ʒ"));
	}
	

}
