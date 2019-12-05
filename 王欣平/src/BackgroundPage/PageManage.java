package BackgroundPage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

/**
 * ��Ŀ���ƣ�TPSHOP   
 * �����ƣ�PageManage   
 * �������� ҳ��������ز���
 * @author wangxinping 
 * ����ʱ�䣺2019��12��4�� ����2:48:00   
 * @version  
 */
public class PageManage extends BaseTest{

	@Test(priority=1,description="��̨��¼")
	public void test_Page(){
		BackgroundLogin();
		AssertJUnit.assertTrue(webtest.isTextPresent("admin"));
	}
	
	@Test(priority=5,description="ҳ��-ҳ�����-ģ��������")
	public void test_Click01() throws Exception{
		webtest.click("link=ҳ��");
		Thread.sleep(100);
		webtest.click("link=ģ��������");
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("��ҵ��������"));
	}
	
	@DataProvider(name = "industry")
	public Object[][] getExcelData1() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"industry.xlsx","Sheet1");
	}
	
	@Test(priority=12,dataProvider="industry",description="������ҵ")
	public void test_AddIndustry(String name,String order,String type) 
			throws Exception{
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();
		
		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(0).sendKeys(name);//����
		inputs.get(1).sendKeys(order);//����
		webtest.tapClick();
		Select belong = new Select(getDriver().findElement(By.id("parent_id")));
		belong.selectByVisibleText(type);
		webtest.click("id=submitBtn");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(name));
	}
	
	@Test(priority=15,description="ҳ��-ҳ�����-PC�˵�����")
	public void test_Click02() throws Exception{
		webtest.leaveFrame();
		Thread.sleep(200);
		webtest.click("link=PC�˵�����");
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("�Զ��嵼��������"));
	}
	
	@DataProvider(name = "link")
	public Object[][] getExcelData() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"linkdata.xlsx", "Sheet1");
	}
	
	@Test(priority=20,dataProvider="link",description="�����ײ�����")
	public void test_AddLinkBottom(String place,String content,String order) 
			throws Exception{
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();
		Thread.sleep(50);
		//System.out.println("****"+fbuttons.size());
		Select places = new Select(getDriver().findElement(By.id("position")));
		places.selectByValue(place);
		Select contents = new Select(getDriver().findElement(By.id("system_bottom")));
		contents.selectByVisibleText(content);
		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(2).sendKeys(order);//����
		
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(place));
	}
	@DataProvider(name = "link2")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"link.xlsx", "Sheet1");
	}
	
	@Test(priority=22,dataProvider="link2",description="�������� ����")
	public void test_AddLinkTop(String place,String content,String order) 
			throws Exception{
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();
		Thread.sleep(50);
	
		Select places = new Select(getDriver().findElement(By.id("position")));
		places.selectByValue(place);
		Select contents = new Select(getDriver().findElement(By.id("system_nav")));
		contents.selectByVisibleText(content);
		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(2).sendKeys(order);//����
		
		webtest.click("id=submitBtn");
		Thread.sleep(3000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(place));
	}
	
	
	@DataProvider(name = "manage")
	public Object[][] getExcelData3() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"manage.xlsx", "Sheet1");
	}
	
	@Test(priority=25,dataProvider="manage",description="ҳ�������ർ�����ĵ��")
	public void test_Click01(String linkName,String content) throws Exception{
		webtest.leaveFrame();
		webtest.click("link="+linkName);
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(content));
		webtest.leaveFrame();
		Thread.sleep(100);
	}	
}
