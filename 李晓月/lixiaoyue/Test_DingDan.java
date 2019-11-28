package lixiaoyue;

import static org.testng.Assert.assertTrue;

import java.awt.Window;
import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.xml.soap.Text;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.demo.Login_Action;



public class Test_DingDan extends BaseTest{
	
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
	
	//��¼�������
	@Test(priority = 1)
	 public void MyDd() throws InterruptedException{
			webtest.click("link=�ҵĶ���");
			assertTrue(webtest.isTextPresent("ȫ������"));
	}	
	//δ��¼�������-��ת����¼ҳ��
//	@Test(priority = 1)
//	 public void MyDdN() throws InterruptedException{
//			webtest.open("http://localhost:8036/Home/Index/index.html");
//			webtest.click("link=�ҵĶ���");
//			assertTrue(webtest.isTextPresent("ȫ������"));
//		}	

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:/SX/ChaXun.xlsx","Sheet1");
	}
	@Test(priority=2,dataProvider="excel")
		public void CheckBy(String name,String message2) throws Exception{
		webtest.getWindow(1);
		System.out.println(webtest.getTitle());
		webtest.type("id=search_key", name);
		WebElement e1 = getDriver().findElement(By.xpath("//*[@id='search_order']/input[2]"));
		JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();", e1);
		Assert.assertEquals(message2,"���빺�ﳵ");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='navitems5']/ul/li[1]/a");
		webtest.getWindow(0);
	}
	
//	//�鿴��������
	@Test(priority=5)
	public void LookDetail() throws Exception{
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
//	//�鿴��������
		WebElement e4 = getDriver().findElement(By.linkText("�鿴����"));
		JavascriptExecutor jse4=(JavascriptExecutor) getDriver();
		jse4.executeScript("arguments[0].click();", e4);
		}
	
	//�ٴι���
	@Test(priority=6,description="�ٴι���")
	public void BuyAgain() throws Exception{    
		webtest.open("http://localhost:8036/Home/Order/order_list.html");
		WebElement e5 = getDriver().findElement(By.linkText("�ٴι���"));
		JavascriptExecutor jse5=(JavascriptExecutor) getDriver();
		jse5.executeScript("arguments[0].click();", e5);

		webtest.getWindow(1);
		Thread.sleep(2000);
		WebElement e6 = getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[2]/div[1]/a"));
		JavascriptExecutor jse6=(JavascriptExecutor) getDriver();
		jse6.executeScript("arguments[0].click();", e6);
	}
		
	
	//�ٴι���
		@Test(priority=7,description="�ٴι���ı�����")
		public void BuyAgain2() throws Exception{    
			webtest.open("http://localhost:8036/Home/Order/order_list.html");
			WebElement e5 = getDriver().findElement(By.linkText("�ٴι���"));
			JavascriptExecutor jse5=(JavascriptExecutor) getDriver();
			jse5.executeScript("arguments[0].click();", e5);

			webtest.getWindow(1);
			Thread.sleep(2000);
			webtest.click("link=-");
			WebElement e6 = getDriver().findElement(By.linkText("ȥ����"));
			JavascriptExecutor jse6=(JavascriptExecutor) getDriver();
			jse6.executeScript("arguments[0].click();", e6);
		}
		
		//��ѡ�ղ�
		@Test(priority=8,description="��ѡ�ղ�")
		public void SaveObject() throws Exception{
			webtest.open("http://localhost:8036/home/Cart/index.html");
			webtest.click("link=�Ƶ��ҵ��ղ�");
		}
				
		//��ѡ�ղ�
		@Test(priority=9,description="��ѡ�ղ�")
		public void SaveOne() throws Exception{
			webtest.open("http://localhost:8036/home/Cart/index.html");
			WebElement e10 = getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/div/a[2]"));
			JavascriptExecutor jse10=(JavascriptExecutor) getDriver();
			jse10.executeScript("arguments[0].click();", e10);					
		}
		
		//ȫѡɾ��
		@Test(priority=10,description="ȫѡɾ��")
		public void DelectAll() throws Exception {
			//������Ҫ��Ӷ���ٴι���
			webtest.open("http://localhost:8036/Home/Order/order_list.html");
			WebElement e7 = getDriver().findElement(By.linkText("�ٴι���"));
			JavascriptExecutor jse7=(JavascriptExecutor) getDriver();
			for(int i=0;i<4;i++){
				jse7.executeScript("arguments[0].click();", e7);
			}
			Thread.sleep(2000);
////			//Ĭ��Ϊȫѡɾ��
			WebElement e8 = getDriver().findElement(By.linkText("ɾ��ѡ�е���Ʒ"));
			JavascriptExecutor jse8=(JavascriptExecutor) getDriver();
			jse8.executeScript("arguments[0].click();", e8);
			
			
			WebElement e9 = getDriver().findElement(By.id("removeGoods"));
			JavascriptExecutor jse9=(JavascriptExecutor) getDriver();
			jse9.executeScript("arguments[0].click();", e9);	
		}
		
		//��ѡɾ��
		@Test(priority=11,description="��ѡɾ��")
		public void DelectOne() throws Exception {
			webtest.open("http://localhost:8036/Home/Order/order_list.html");	
			webtest.click("link=�ٴι���");
			webtest.click("xpath=//*[@id='tpshop-cart']/div[2]/div/div/div[1]/i");
			webtest.click("xpath=//*[@id='edge_10']/div/div[1]/div[1]/i");
			webtest.click("link=ɾ��");	
			webtest.click("id=removeGoods");
		}

		
}
