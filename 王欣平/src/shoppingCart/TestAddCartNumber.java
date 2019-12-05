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
	
	@Test(priority = 0, description = "��¼")
	public void testLogin() throws Exception {
		// ����ҳ
		webtest.open("http://localhost:8036/index.php");
		Thread.sleep(1000);
		// �������¼������
		webtest.click("xpath=//a[@href='/index.php/Home/user/login.html']");

		webtest.type("name=username", "13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1111");
		webtest.click("name=sbtbutton");
		Thread.sleep(3000);
		Assert.assertTrue(getDriver().getPageSource().contains("��ȫ�˳�"));
	}
	
	@Test(priority=1,description="����Ʒ����25")
	public void test_Open2() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Goods/goodsInfo/id/25.html");
		Thread.sleep(200);
	}
	

	@Test(priority=5,description = "���һ����Ʒ�����Ҳ��+��",dependsOnMethods="test_Open2")
	public void test_04_addGoodsNuByButton1() throws Exception {
		//action.moveByOffset(100, 200).release()
		a++;// iframe idÿ�ζ���1
		// ѡ������
		webtest.click("xpath=//div[@class=minus-plus]/a[@class=add]");
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(5000);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));

		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}
		
	
	@Test(priority=10,description = "��������Ʒ�����Ҳ��+��")
	public void test_05_addGoodsNuByButton2() throws Exception {
		System.out.println(webtest.getTitle());
		//action.moveByOffset(100, 200).release()
		a++;// iframe idÿ�ζ���1
		int m;
		for(m=0;m<5;m++){
			webtest.click("class=add");
		}		
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(500);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));

		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}
	
	@Test(priority=15,description = "�����Ʒ��������-��")
	public void test_06_addGoodsNuByButton2() throws Exception {
		System.out.println(webtest.getTitle());
		a++;// iframe idÿ�ζ���1
		int m;
		for(m=0;m<5;m++){
			webtest.click("class=mins");
		}
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(500);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));

		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
	}	
	
	// ��¼�������Ʒ����Ϊ-1
	@Test(priority=20,description = "ѡ����Ʒ����: -1 ʧ��")
	public void test_08_addGoodsNumFail01() throws Exception {
		a++;// iframe idÿ�ζ���1
		// ѡ������	
		webtest.type("id=number", "-1");	
		webtest.tapClick();
		//webtest.tapClick();

		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(1000);
		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("���ʧ��"));

		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
	}

	// ��¼�������Ʒ����Ϊ 0
	@Test(priority=25, description = "ѡ����Ʒ���� 0  ʧ��")
	public void test_10_addGoodsNumFail02() throws Exception {
		a++;// iframe idÿ�ζ���1
		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
		// ѡ������
		webtest.type("id=number", "-1");	
		webtest.tapClick();
		//webtest.tapClick();
		
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(2000);

		WebElement frame = getDriver().findElement(By.id("layui-layer-iframe" + a));
		getDriver().switchTo().frame(frame);

		Assert.assertTrue(getDriver().getPageSource().contains("���ʧ��"));

		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(2000);
	}

	// ��¼�������Ʒ����Ϊ �����+1
	@Test(priority=30,description = "ѡ����Ʒ����  �����+1 ʧ��")
	public void test_12_addGoodsNumFail03() throws Exception {
		a++;// iframe idÿ�ζ���1
		webtest.click("xpath=//a[contains(text(),'��������')]");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();
		Thread.sleep(1000);
		// ѡ������
		webtest.type("id=number", "100");	
		webtest.tapClick();
		
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ʒ��治��"));
		
		webtest.click("xpath=//a[contains(text(),'ȷ��')]");
		Thread.sleep(200);
	}
}
