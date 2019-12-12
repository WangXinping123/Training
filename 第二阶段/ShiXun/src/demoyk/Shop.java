package demoyk;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;
//@Listeners({ ApiListener.class})
public class Shop extends Admin_Login{
	
	@BeforeMethod
	public void goSetting(){
		/*webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		//文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin123");
		webtest.click("xpath=//input[@type='button']");
		assertTrue(webtest.isTextPresent("admin"));*/
		webtest.leaveFrame();
		webtest.click("xpath=//a[contains(text(), '商城')]");
	}
	/*@AfterMethod
	public void outlogin() throws InterruptedException{
		webtest.mouseoverElement("xpath=//span[contains(text(), 'admin')]");
		webtest.click("xpath=//a[contains(text(), '退出系统')]");
	}*/
	
	@DataProvider(name="goodsData")
    public static Object[][]Words() throws IOException{
		 String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"goodsmage.xlsx", "Sheet1") ;
    }
	@DataProvider(name="labeData")
    public static Object[][]Words1() throws IOException{
		 String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"goodsmage.xlsx", "Sheet2") ;
    }
	@DataProvider(name="listData")
    public static Object[][]Words2() throws IOException{
		 String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"goodsmage.xlsx", "Sheet3") ;
    }
	@DataProvider(name="typeData")
    public static Object[][]Words3() throws IOException{
		 String data_path =ReadProperties.getPropertyValue("data_path");
        return new ExcelDataProvider().getTestDataByExcel(data_path+"goodsmage.xlsx", "Sheet4") ;
    }
	@Test(priority=1,dataProvider = "goodsData")
	public void goodsMage(String goods_name,String cat_id,String cat_id_2,String cat_id_3, String shop_price,String market_price){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='goodsList|Goods']");
		//进入商品管理的frame
		webtest.enterFrame("workspace");
		//获取文本
		int before=webtest.findnum("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[5]/div");
		///点击添加商品
		webtest.click("xpath=//div[@title='添加商品']");
		//添加商品信息
		webtest.type("name=goods_name", goods_name);
		webtest.selectByVisibleText("name=cat_id", cat_id);
		webtest.selectByVisibleText("name=cat_id_2", cat_id_2);
		webtest.selectByVisibleText("name=cat_id_3", cat_id_3);
		webtest.type("name=shop_price", shop_price);
		webtest.type("name=market_price", market_price);
		webtest.click("xpath=//label[@id='is_free_shipping_label_1']");
		webtest.click("xpath=//a[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='goodsList|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[5]/div");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
	}
	@Test (priority=2)
	public void delGoods() throws InterruptedException
	{
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='goodsList|Goods']");
		//进入商品管理的frame
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[5]/div");
		
		webtest.mouseoverElement("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[2]/div/span/em");
		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[2]/div/span/ul/li[4]/a");
		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
		
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='goodsList|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[5]/div");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before-1,after);
		sa.assertAll();
		webtest.leaveFrame();
	}
	@Test(priority=3,dataProvider = "labeData")
	public void goodsLabe(String label_name){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='goods_label|Goods']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='添加商品']");
		webtest.type("name=label_name", label_name);
		webtest.click("xpath=//a[@id='submitBtn']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='goods_label|Goods']");
		webtest.enterFrame("workspace");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(getDriver().getPageSource().contains(label_name),true);
		sa.assertAll();
		webtest.leaveFrame();
	}
	@Test(priority=4)
	public void delLabe() throws InterruptedException{
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='goods_label|Goods']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[3]/div/a[2]");
		webtest.click("xpath=//div[@id='layui-layer1']/div[3]/a[1]");
	}
	@Test(priority=5,dataProvider = "listData")
	public void brandList(String name ,String parent_cat_id ,String cat_id){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='brandList|Goods']");
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
		
		webtest.click("xpath=//div[@title='新增品牌']");
		webtest.type("name=name", name);
		webtest.selectByVisibleText("name=parent_cat_id", parent_cat_id);
		webtest.selectByVisibleText("name=cat_id", cat_id);
		webtest.click("xpath=//a[@id='submitBtn']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='brandList|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
	
	}
	@Test(priority=6)
	public void branddel(){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='brandList|Goods']");
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");

		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[8]/div/a[1]");
		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='brandList|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
	}
	@Test(priority=7,dataProvider = "typeData")
	public void goodsType(String name){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='type_list|Goods']");
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");
		
		webtest.click("xpath=//div[@title='新增商品模型']");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.type("name=name", name);
		webtest.click("xpath=//a[@id='submit']");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='type_list|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
		
		
	}
	@Test(priority=8)
	public void typeDel(){
		webtest.click("xpath=//a[contains(text(), '商城')]");
		webtest.click("xpath=//a[@data-param='type_list|Goods']");
		webtest.enterFrame("workspace");
		int before=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");

		webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[4]/div/a[2]");
		webtest.click("xpath=//*[@id='layui-layer1']/div[3]/a[1]");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='type_list|Goods']");
		webtest.enterFrame("workspace");
		int after=webtest.findnum("xpath=/html/body/div[3]/div[3]/div[1]/div[1]/h5");	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(before+1,after);
		sa.assertAll();
		webtest.leaveFrame();
	}
}
