package lixiaoyue;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class Test_DiZhi extends BaseTest{
Base_login action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Base_login(webtest);
	}

	//��¼
	@Test(priority = 0)
		 public void Entry() throws InterruptedException{
			action.login("15227564513", "123456");
			Thread.sleep(2000);
			assertTrue(webtest.isTextPresent("��ȫ�˳�"));
			Thread.sleep(2000);
		}
	//��ѯ���ĵ�ַ
	@Test(priority=1)
	public void DiZhi(){
		//�����ַҳ
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		//�鿴��ַ
		webtest.click("link=�����ַ");
		//������ַ
		webtest.click("xpath=//*[@id='ajax_address']/div[2]/ul/li[3]/div[1]");
	}
	//�����������
	@DataProvider(name="excel1")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/DiZhi.xlsx","Sheet1");
	}
	
	//������ַ
	@Test(priority=2,dataProvider="excel1")
	public void AddDiZhiSuccess(String user,String phone,String address,String message) throws InterruptedException{
		//��ӵ�ַ
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=�����ջ���ַ");
		webtest.type("xpath=//*[@id='address_form']/div[2]/div/div[2]/div[1]/div/input", user);
		webtest.type("xpath=//*[@id='address_form']/div[2]/div/div[2]/div[2]/div/input", phone);
		webtest.click("id=province");
		webtest.click("xpath=//*[@id='province']/option[4]");
		Thread.sleep(1000);
		webtest.click("id=city");
		webtest.click("xpath=//*[@id='city']/option[10]");
		Thread.sleep(1000);
		
		WebElement parentMenu=getDriver().findElement(By.id("district"));
		Actions builder=new Actions(getDriver());
		builder.moveToElement(parentMenu).perform(); 
		WebElement subMenu=getDriver().findElement(By.xpath("//*[@id='district']/option[7]"));
		subMenu.click();	
		Thread.sleep(1000);
		webtest.click("id=twon");
		webtest.click("xpath=//*[@id='twon']/option[4]");
		Thread.sleep(1000);
		webtest.type("name=address", address);
		webtest.click("id=address_submit");
		if(message.equals("����ʧ��")){
			webtest.click("id=address_dialog_close");
		}
		Assert.assertEquals(message,"�����ջ���ַ");
		//����Ϊ���ʱ�򣬹ر�������ַ��
		if(message.equals("����ʧ��")){
			webtest.click("id=address_dialog_close");
		}
	}
	
	
	
	@DataProvider(name="excel2")
	public Object[][] getExcelDada1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/FaPiao.xlsx","Sheet1");
	}
	//���ķ�Ʊ��Ϣ����λ��
	@Test(priority=3,dataProvider="excel2")
	public void Change(String num1,String num2,String message3){
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=�޸�");
		webtest.click("id=addinvoice");
		webtest.type("id=invoice_title", num1);
		webtest.type("id=taxpayer", num2);
		webtest.click("id=type_invoice");
		webtest.click("link=����");
		webtest.click("id=invoice_dialog_close");
		Assert.assertEquals(message3,"��������ȷ����˰��ʶ���");
	}
	
	//���ķ�Ʊ��Ϣ�����ˣ�
	@DataProvider(name="excel3")
	public Object[][] getExcelDada3() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/LeiBie.xlsx","Sheet1");
	}
	@Test(priority=4,dataProvider="excel3")
	public void Change2(String lei){
		webtest.open("http://localhost:8036/Home/Cart/cart2.html");
		webtest.click("link=�޸�");
		webtest.click("link="+lei);
		webtest.click("link=����");
		assertTrue(webtest.isTextPresent("��������ȷ����˰��ʶ���"));
	}
}
