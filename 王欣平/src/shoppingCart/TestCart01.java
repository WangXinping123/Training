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
 * ��Ŀ���ƣ�TPSHOP 
 * �����ƣ�TestCart01 
 * �����������ȥ���ﳵ���㣬ɾ��/�ղ���Ʒ
 * 		   �����Ʒ����֤���ﳵ���Ƿ��������Ʒ
 * @author wangxinping 
 * ����ʱ�䣺2019��11��29�� ����4:44:52
 * @version
 */
public class TestCart01 extends BaseTest {

	@Test(priority = 0, description = "��¼")
	public void testLogin() throws Exception {
		LoginMethod();
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("�˳�"));
	}

	// ���빺�ﳵ����� ȥ���ﳵ����
	@Test(priority=1,description="���빺�ﳵ��")
	public void test_AddGood01() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/5.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));
		
		Thread.sleep(200);
	}
	
	@Test(priority=2,description="���ȥ���ﳵ���㣬�Ƿ���ת�ɹ�")
	public void testSkipToCart()throws Exception{
		webtest.click("xpath=//a[contains(text(),'ȥ���ﳵ����')]");
		Thread.sleep(500);
		webtest.leaveFrame();
		Assert.assertTrue(getDriver().getPageSource().contains("ȫ����Ʒ��"));
	}

	@Test(priority=3,description = "������Ʒ��ӵ��ҵ��ղ�")
	public void testMoveCollectItemButton() throws Exception {
		List<WebElement> c = getDriver().findElements(By.linkText("�Ƶ��ҵ��ղ�"));
		c.get(0).click();
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains("��������ҵ��ղ�"));
		Thread.sleep(500);
	}
	
	@Test(priority=4,description = "ɾ��������Ʒ�������Ʒ�Ҳ��ɾ����")
	public void testDeleteItemButton() throws Exception {
		//String url = "http://localhost:8036/index.php/Home/Cart/index.html";
		//webtest.open(url);
		List<WebElement> d = getDriver().findElements(By.linkText("ɾ��"));
		d.get(0).click();
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("ɾ����Ʒ"));
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		WebElement element= getDriver().findElement(By.id("removeGoods"));
		js.executeScript("arguments[0].click();", element);
	}
	

	@Test(priority=5,description="���빺�ﳵ�󣬵��ȥ���ﳵ���㣬���ﳵ���Ƿ�������ӵ���Ʒ")
	public void test_CartContainsMyGoods() throws Exception {
		String url = "http://localhost:8036/index.php/Home/Goods/goodsInfo/id/16.html";
		webtest.open(url);
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'���빺�ﳵ')]");
		Thread.sleep(200);
		webtest.enterFrame("layui-layer-iframe1");
		Assert.assertTrue(getDriver().getPageSource().contains("��ӳɹ�"));
		webtest.click("xpath=//a[contains(text(),'ȥ���ﳵ����')]");
		Thread.sleep(500);
		webtest.leaveFrame();
		Thread.sleep(800);
		Assert.assertTrue(getDriver().getPageSource().contains("��Ϊ����ԭװ�ֻ�"));
	}
	
	@Test(priority=6,description="�򿪹��ﳵ��������Ʒ �Ƶ��ҵ��ղ�")
	public void testMoveCollectPartSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'�Ƶ��ҵ��ղ�')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("�ղ�"));
	}
	@Test(priority=8,description="�򿪹��ﳵ������ɾ����Ʒ")
	public void testDeletePartSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'ɾ��ѡ�е���Ʒ')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("ɾ����Ʒ"));
	}
	
	
	@Test(priority=9,description="�򿪹��ﳵ��ѡ�񲿷���Ʒ�����ȥ����")
	public void testPaytotalNoSelectGoods() throws Exception{
		webtest.open("http://localhost:8036/index.php/Home/Cart/index.html");
		Thread.sleep(300);
		webtest.click("xpath=//a[contains(text(),'ȥ����')]");
		Thread.sleep(200);
		Assert.assertTrue(getDriver().getPageSource().contains("û��ѡ����Ʒ"));
	}	
	

}
