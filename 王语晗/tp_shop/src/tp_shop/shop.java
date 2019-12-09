package tp_shop;

import java.lang.invoke.LambdaConversionException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class shop extends BaseTest{
	String url="http://localhost:9090/Home/Index/index.html";
	@DataProvider(name = "tp_shop")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop.xlsx", "Sheet1");
	}

	@Test(priority=1,dataProvider="tp_shop")
	public void register1(String username,String verify_code,String password,String password2,String invite) throws InterruptedException{
		//打开网页
		webtest.open(url);
				
		//手机注册
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2", password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[2]/a[2]");
		//Assert.assertTrue(getDriver().getPageSource().contains(username));
	}
	
	@DataProvider(name = "tp_shop_mail")
	public Object[][] getExcelData1() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_mail.xlsx", "Sheet1");
	}
	
	@Test(priority=1,dataProvider="tp_shop_mail")
	public void register2(String username,String verify_code,String password,String password2,String invite) throws InterruptedException{
		//打开网页
		webtest.open(url);
				
		//邮箱注册
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2",password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[2]/a[2]");
	}
	
	@DataProvider(name = "tp_shop_wrong_tel")
	public Object[][] getExcelData3() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_tel.xlsx", "Sheet1");
	}
	
	@Test(priority=1,dataProvider="tp_shop_wrong_tel")
	public void wrongRegister(String username,String verify_code,String password,String password2,String invite) throws InterruptedException{
		//打开网页
		webtest.open(url);
		
		//手机注册
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2", password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[2]/a[2]");
	}
	
	@DataProvider(name = "tp_shop_wrong_mail")
	public Object[][] getExcelData4() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_mail.xlsx", "Sheet1");
	}
	
	@Test(priority=1,dataProvider="tp_shop_wrong_mail")
	public void wrongRegister2(String username,String verify_code,String password,String password2,String invite) throws InterruptedException{
		//打开网页
		webtest.open(url);
				
		//邮箱注册
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2",password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[2]/a[2]");
	}
	
	@DataProvider(name = "tp_shop_login")
	public Object[][] getExcelData5() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_login.xlsx", "Sheet1");
	}
	
	@Test(priority=2,dataProvider="tp_shop_login")
	public void login(String username,String password,String verify_code) throws InterruptedException{
		//打开网页
		webtest.open(url);
		//登录
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", username);
		webtest.type("name=password", password);
		webtest.type("name=verify_code", verify_code);
		webtest.click("xpath=//*[@id='loginform']/div/div[6]/a");
	}
	
	@DataProvider(name = "tp_shop_wrong_login")
	public Object[][] getExcelData6() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_login.xlsx", "Sheet1");
	}
	
	@Test(priority=2,dataProvider="tp_shop_wrong_login")
	public void wrongLogin(String username,String password,String verify_code) throws InterruptedException{
		//打开网页
		webtest.open(url);
		//登录
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", username);
		webtest.type("name=password", password);
		webtest.type("name=verify_code", verify_code);
		webtest.click("xpath=//*[@id='loginform']/div/div[6]/a");
	}
	
	@Test(priority=3)
	public void deliver() throws InterruptedException{
		//送货至
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[1]/b");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[1]/ul/li[1]/a/em");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[2]/ul/li[3]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[3]/ul/li[1]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[4]/ul/li[7]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter1() throws InterruptedException{
		//资产中心-我的优惠券-兑换优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1兑换优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
	}
	
	@Test(priority=4)
	public void possessionCenter2() throws InterruptedException{
		//资产中心-我的优惠券-领取更多优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-2领取更多优惠
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
	}
	
	@Test(priority=4)
	public void possessionCenter3() throws InterruptedException{
		//资产中心-账户余额-提现
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-1提现（支付宝）
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/dl/dd[1]/label");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[2]/div[3]/a");
		webtest.type("id=pop_card", "13988888888");
		webtest.type("id=pop_name", "admin");
		webtest.click("xpath=//*[@id='add_card']");
		webtest.type("name=money", "888");
		webtest.type("name=paypwd", "123456");
		webtest.click("xpath=//*[@id='save_data']");
	}
	
	@Test(priority=4)
	public void possessionCenter4() throws InterruptedException{
		//资产中心-账户余额-充值
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-2充值
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.type("name=account", "888");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
	}
	
	@Test(priority=4)
	public void possessionCenter5() throws InterruptedException{
		//资产中心-账户余额-充值记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-3充值记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter6() throws InterruptedException{
		//资产中心-账户余额-消费记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-4消费记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter7() throws InterruptedException{
		//资产中心-账户余额-提现记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-5提现记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter8() throws InterruptedException{
		//资产中心-我的积分-积分换购
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1积分换购
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
	}
	
	@Test(priority=4)
	public void possessionCenter9() throws InterruptedException{
		//资产中心-我的积分-积分明细
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-2积分明细
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter10() throws InterruptedException{
		//资产中心-我的积分-积分累计
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-3积分累计
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter11() throws InterruptedException{
		//资产中心-我的积分-积分消费
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-4积分消费
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
	}
		
	@Test(priority=4)
	public void focusCenter1() throws InterruptedException{
		//关注中心-我的收藏-删除商品
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-1删除商品
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[1]/li[1]/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");
	}
	
	@Test(priority=4)
	public void focusCenter2() throws InterruptedException{
		//关注中心-我的收藏-查看详情
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-2查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
	}
	
	@Test(priority=4)
	public void focusCenter3() throws InterruptedException{
		//关注中心-我的足迹-查看详情
		//2.我的足迹
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//2-1查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ul/li[3]/a");
	}
	
}
