package demoyk;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

/**
 * 项目名称：TPSHOP 类名称：Setting 类描述： 后台设置相关测试
 * 
 * @author 袁康      
 * @version
 */
public class Setting extends Admin_Login{
	@BeforeMethod
	public void goSetting(){
		/*webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		//文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin123");
		webtest.click("xpath=//input[@type='button']");
		assertTrue(webtest.isTextPresent("admin"));*/
		webtest.leaveFrame();
		webtest.click("xpath=//a[contains(text(), '设置')]");
	}
	/*@AfterMethod
	public void outlogin() throws InterruptedException{
		webtest.mouseoverElement("xpath=//span[contains(text(), 'admin')]");
		webtest.click("xpath=//a[@class='login-out show-option']");
	}*/
	@DataProvider(name="areaData")
    public static Object[][]Words() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet1") ;
    }
	@DataProvider(name="mailData")
    public static Object[][]Words1() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet2") ;
    }
	@DataProvider(name="traData")
    public static Object[][]Words2() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet3") ;
    }
	@DataProvider(name="messageData")
    public static Object[][]Words3() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet4") ;
    }
	@DataProvider(name="userData")
    public static Object[][]Words4() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet5") ;
    }
	@DataProvider(name="systemData")
    public static Object[][]Words5() throws IOException{
		String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"setPage.xlsx", "Sheet6") ;
    }
	
//	@Test(priority=1,dataProvider = "areaData")
//	public void setArea(String name){
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		//点击地区配送
//		webtest.click("xpath=//a[@data-param='region|Tools']");
//		webtest.enterFrame("workspace");
//		
//		int before=webtest.findnum("xpath=//*[@id='list']/div[3]/div[1]/div[1]/h5");
//
//		//点击新增数据
//		webtest.click("xpath=//div[@title='新增数据']");
//		webtest.type("name=name", name);
//		webtest.click("xpath=//form[@id='add_region_form']/div/div/a");
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[@data-param='region|Tools']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=//*[@id='list']/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before+1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=2)
//	public void delArea(){
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		//点击地区配送
//		webtest.click("xpath=//a[@data-param='region|Tools']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=//*[@id='list']/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//*[@id='row130']/td[2]/div/a");
//		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
//		
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[@data-param='region|Tools']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=//*[@id='list']/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before-1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=3,dataProvider = "mailData")
//	public void addmail(String sms_sign,String sms_tpl_code,String send_scene) throws InterruptedException{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		//点击短信模板
//		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		//点击新增模板
//		webtest.click("xpath=//div[@title='新增模板']");
//		webtest.type("name=sms_sign", sms_sign);
//		webtest.type("name=sms_tpl_code", sms_tpl_code);
//		webtest.selectByVisibleText("name=send_scene", send_scene);
//		Thread.sleep(500);
//		webtest.click("xpath=//textarea[@id='tpl_content']");
//		Thread.sleep(500);
//		webtest.click("xpath=//a[@id='submitBtn']");
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before+1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=4)
//	public void delmail(){
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		//点击短信模板
//		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[7]/div/a[1]");
//		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before-1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=5,dataProvider = "traData")
//	public void addTra(String template_name,String funit,String fmoney,String cunit,String cmoney) throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		webtest.click("xpath=//a[@data-param='index|Freight']");
//		webtest.enterFrame("workspace");
//		//点击新增模板
//		webtest.click("xpath=//div[@title='新增运费模板']");
//		webtest.type("name=template_name", template_name);
//		webtest.click("xpath=//*[@id='handleposition']/div/dl[2]/dd/input[1]");
//		webtest.click("xpath=//*[@id='handleposition']/div/dl[3]/dd/input[2]");
//		webtest.type("name=first_unit[]", funit);
//		webtest.type("name=first_money[]", fmoney);
//		webtest.type("name=continue_unit[]",cunit);
//		webtest.type("name=continue_money[]", cmoney);
//		webtest.click("xpath=//*[@id='handleposition']/div/div[2]/a");
//		webtest.leaveFrame();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='index|Freight']");
//		webtest.enterFrame("workspace");
//		SoftAssert sa = new SoftAssert();
//		
//		sa.assertEquals(getDriver().getPageSource().contains(template_name),true);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
	@Test(priority=6,dataProvider = "messageData")
	public void messageList(String username,String email,String password,String role_id) throws Exception{
		webtest.click("xpath=//a[contains(text(), '设置')]");
		Thread.sleep(2000);
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		Thread.sleep(2000);
		webtest.click("xpath=//a[@data-param='index|Admin']");
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
		webtest.click("xpath=//div[@title='添加管理员']");
		webtest.type("name=user_name", username);
		webtest.type("name=email",email);
		webtest.type("name=password", password);
		webtest.selectByVisibleText("name=role_id", role_id);
		webtest.click("xpath=//a[@id='submitBtn']");
		webtest.leaveFrame();
		webtest.click("link=插件设置");
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		Thread.sleep(2000);
		webtest.click("xpath=//a[@data-param='index|Admin']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
	}
//	@Test(priority=7)
//	public void delList() throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		Thread.sleep(2000);
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='index|Admin']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[2]/td[7]/div/a[2]");
//		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
//		
//		webtest.leaveFrame();
//		webtest.click("link=插件设置");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='index|Admin']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before-1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=8,dataProvider = "userData")
//	public void userMasg(String roleName,String roleDesc) throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='role|Admin']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//div[@title='添加角色']");
//		webtest.type("name=data[role_name]", roleName);
//		webtest.type("name=data[role_desc]", roleDesc);
//		webtest.click("xpath=//*[@id='cls_full']");
//		webtest.click("xpath=//a[@id='submitBtn']");
//		webtest.leaveFrame();
//		webtest.click("link=插件设置");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(3000);
//		webtest.click("xpath=//a[@data-param='role|Admin']");
//		Thread.sleep(2000);
//		
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before+1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//	}
//	@Test(priority=9)
//	public void delUser() throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		Thread.sleep(2000);
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='role|Admin']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[5]/div/a[2]");
//		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
//		webtest.leaveFrame();
//		webtest.click("link=插件设置");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='role|Admin']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before-1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//		
//	}
//	@Test(priority=10)
//	public void userMasgNosys() throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		Thread.sleep(2000);
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='role|Admin']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//div[@title='添加角色']");
//		webtest.type("name=data[role_name]", "管理员");
//		webtest.type("name=data[role_desc]", "这是个管理员");
//		webtest.click("xpath=//a[@id='submitBtn']");
//		webtest.leaveFrame();
//		webtest.click("link=插件设置");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(3000);
//		webtest.click("xpath=//a[@data-param='index|SmsTemplate']");
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before+1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//		
//	}
//	
//	@Test(priority=11,dataProvider = "systemData")
//	public void system(String name,String group,String controller) throws Exception{
//		webtest.click("xpath=//a[contains(text(), '设置')]");
//		Thread.sleep(2000);
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(2000);
//		webtest.click("xpath=//a[@data-param='right_list|System']");
//		webtest.enterFrame("workspace");
//		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//		webtest.click("xpath=//div[@title='添加权限']");
//		webtest.type("name=name", name);
//		webtest.selectByVisibleText("name=group",  group);
//		webtest.selectByVisibleText("id=controller",  controller);
//		webtest.click("xpath=//*[@id='adminHandle']/div/dl[4]/dd/ul/li[1]/label/input");
//		webtest.click("xpath=//a[@id='submitBtn']");
//		webtest.leaveFrame();
//		webtest.click("xpath=//a[@data-param='right_list|System']");
//		webtest.click("link=插件设置");
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		webtest.tapDown();
//		Thread.sleep(3000);
//		webtest.enterFrame("workspace");
//		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//		
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(before+1,after);
//		sa.assertAll();
//		webtest.leaveFrame();
//		
//	}
//	@Test(priority=12)
//		public void systemNot() throws Exception{
//			//不选择权限
//			webtest.click("xpath=//a[contains(text(), '设置')]");
//			Thread.sleep(2000);
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			Thread.sleep(2000);
//			webtest.click("xpath=//a[@data-param='right_list|System']");
//			webtest.enterFrame("workspace");
//			int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//			webtest.click("xpath=//div[@title='添加权限']");
//			webtest.type("name=name", "管理员");
//			webtest.selectByVisibleText("name=group", "商品中心");
//			webtest.selectByVisibleText("id=controller", "Admin");
//			webtest.click("xpath=//a[@id='submitBtn']");
//			webtest.leaveFrame();
//			webtest.click("link=插件设置");
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			Thread.sleep(3000);
//			webtest.click("xpath=//a[@data-param='right_list|System']");
//			webtest.enterFrame("workspace");
//			int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//			
//			SoftAssert sa = new SoftAssert();
//			sa.assertEquals(before+1,after);
//			sa.assertAll();
//			webtest.leaveFrame();
//			
//		}
//		@Test(priority=13)
//		public void delRole() throws Exception{
//			webtest.click("xpath=//a[contains(text(), '设置')]");
//			Thread.sleep(2000);
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			Thread.sleep(2000);
//			webtest.click("xpath=//a[@data-param='right_list|System']");
//			webtest.enterFrame("workspace");
//			int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//
//			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[6]/div/a[2]");
//			webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
//			
//			webtest.leaveFrame();
//			webtest.click("link=插件设置");
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			webtest.tapDown();
//			Thread.sleep(2000);
//			webtest.click("xpath=//a[@data-param='right_list|Systemp  ']");
//			webtest.enterFrame("workspace");
//			int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
//			
//			SoftAssert sa = new SoftAssert();
//			sa.assertEquals(before-1,after);
//			sa.assertAll();
//			webtest.leaveFrame();
//		}
}
