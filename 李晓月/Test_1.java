package Dingdan;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.xml.soap.Text;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.demo.Login_Action;


public class Test_1 extends BaseTest{
	
	Base_login action;
//	NSDataProvider file;
	
	@BeforeMethod
	public void setup()
	{
		action=new Base_login(webtest);
//		file =new NSDataProvider("D:/SX/word.xlsx");
	}

	//��¼
	@Test(priority = 0)
		 public void Entry() throws InterruptedException{
			action.login("15227564513", "123456");
			Thread.sleep(2000);
			assertTrue(webtest.isTextPresent("��ȫ�˳�"));
			Thread.sleep(2000);
		}
	
	//��¼�������
	@Test(priority = 1)
	 public void MyDd() throws InterruptedException{
			webtest.click("link=�ҵĶ���");
			assertTrue(webtest.isTextPresent("ȫ������"));
	}	
	//δ��¼�������-��ת����¼ҳ��
	@Test(priority = 1)
	 public void MyDdN() throws InterruptedException{
			webtest.open("http://localhost:8036/Home/Index/index.html");
			webtest.click("link=�ҵĶ���");
			assertTrue(webtest.isTextPresent("ȫ������"));
		}	

	
	//�����������ݱ��D:/SX/word.xlsx
	//	@DataProvider(name="excel1")
	//	public Object[][] getExcelDada() throws IOException{
	//		return new ExcelDataProvider().getTestDataByExcel("D:/SX/word.xlsx","Sheet1");
	//	}

	@Test(priority=2)
		public void CheckById() throws Exception{
		
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", "201911131549318252");
		WebElement e1 = getDriver().findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/form/input[2]"));
		JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();", e1);
		assertTrue(webtest.isTextPresent("201911131549318252"));
	}

	
	//����������������D:/SX/name.xlsx
	//@DataProvider(name="excel2")
	//	public Object[][] getExcelDada() throws IOException{
	//		return new ExcelDataProvider().getTestDataByExcel("D:/SX/name.xlsx","Sheet1");
	//	}
	
	//���ݶ�����Ʒ����
	@Test(priority=3)
		public void CheckByName() throws Exception{

		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", "���޴�Ʒ�ļ���");
		WebElement e2 = getDriver().findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/form/input[2]"));
		JavascriptExecutor jse2=(JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", e2);
		assertTrue(webtest.isTextPresent("���޴�Ʒ�ļ���"));
	}

	
		//��ѯ�����ڵĴ�����Ϣ
	@Test(priority=4)
		public void Check() throws Exception{
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", "wertyuioasdfgh");
		WebElement e3 = getDriver().findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/form/input[2]"));
		JavascriptExecutor jse3=(JavascriptExecutor) getDriver();
		jse3.executeScript("arguments[0].click();", e3);
		assertTrue(webtest.isTextPresent("����û�ж���"));
	}
	
	//�鿴��������
	@Test(priority=5)
	public void LookDetail() throws Exception{
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
	//�鿴��������
		WebElement e4 = getDriver().findElement(By.linkText("�鿴����"));
		JavascriptExecutor jse4=(JavascriptExecutor) getDriver();
		jse4.executeScript("arguments[0].click();", e4);
		}
	
	//�ٴι���
	@Test(priority=6)
	public void BuyAgain(){
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		
		WebElement e5 = getDriver().findElement(By.linkText("�ٴι���"));
		JavascriptExecutor jse5=(JavascriptExecutor) getDriver();
		jse5.executeScript("arguments[0].click();", e5);
		//ȥ����			
		webtest.click("name=paytotal");
	}
		
}
