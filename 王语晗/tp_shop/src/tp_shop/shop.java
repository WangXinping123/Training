package tp_shop;


import java.lang.invoke.LambdaConversionException;

import org.apache.poi.hssf.record.cf.Threshold;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class shop extends BaseTest{
	String url="http://localhost:8036/Home/Index/index.html";
	@DataProvider(name = "tp_shop")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop.xlsx", "Sheet1");
	}

	@Test(priority=1,dataProvider="tp_shop",description="注册 手机号 成功")
	public void register1(String username,String verify_code,
			String password,String password2,String invite) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("link=注册");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2", password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(2000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("退出"));
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "tp_shop_mail")
	public Object[][] getExcelData1() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_mail.xlsx", "Sheet1");
	}
	
	@Test(priority=2,dataProvider="tp_shop_mail",description="注册 邮箱 成功")
	public void register2(String username,String verify_code,String password,String password2,String invite) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
				
		webtest.click("link=注册");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2",password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("安全退出"));
		Thread.sleep(1000);
	}
	
	@DataProvider(name = "tp_shop_wrong_tel")
	public Object[][] getExcelData3() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_tel.xlsx", "Sheet1");
	}
	
	@Test(priority=5,dataProvider="tp_shop_wrong_tel",description="注册错误手机号")
	public void wrongRegister(String username,String verify_code,String password,String password2,
			String invite,String result) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("link=注册");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2", password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
//		webtest.click("xpath=/html/body/div[1]/div/div/div/div[2]/a[2]");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isTextPresent(result));

	}
	
	@DataProvider(name = "tp_shop_wrong_mail")
	public Object[][] getExcelData4() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_mail.xlsx", "Sheet1");
	}
	
	@Test(priority=10,dataProvider="tp_shop_wrong_mail",description="注册错误邮箱")
	public void wrongRegister2(String username,String verify_code,
			String password,String password2,String invite,String result) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("link=注册");
		Thread.sleep(1000);
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", username);
		webtest.type("name=verify_code", verify_code);
		webtest.type("id=password", password);
		webtest.type("id=password2",password2);
		webtest.type("name=invite", invite);
		webtest.click("xpath=//*[@id='reg_form2']/div/div/div/div[6]/div/a");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isTextPresent(result));
	}
	
	@DataProvider(name = "tp_shop_login")
	public Object[][] getExcelData5() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_login.xlsx", "Sheet1");
	}
	
	@Test(priority=12,dataProvider="tp_shop_login")
	public void login(String username,String password,String verify_code) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		Thread.sleep(1000);
		webtest.click("link=登录");
		webtest.type("name=username", username);
		webtest.type("name=password", password);
		webtest.type("name=verify_code", verify_code);
		webtest.click("xpath=//*[@id='loginform']/div/div[6]/a");
		Thread.sleep(1000);
		Assert.assertTrue(getDriver().getPageSource().contains("退出"));
	}
	
	@DataProvider(name = "tp_shop_wrong_login")
	public Object[][] getExcelData6() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"tp_shop_wrong_login.xlsx", "Sheet1");
	}
	
	@Test(priority=15,dataProvider="tp_shop_wrong_login")
	public void wrongLogin(String username,String password,
			String verify_code,String result) throws InterruptedException{
		webtest.open(url);
		if (getDriver().getPageSource().contains("安全退出")) {
			// 退出登录
			webtest.click("xpath=//a[contains(text(),'安全退出')]");
			Thread.sleep(2000);
		}
		webtest.click("link=登录");
		webtest.type("name=username", username);
		webtest.type("name=password", password);
		webtest.type("name=verify_code", verify_code);
		webtest.click("xpath=//*[@id='loginform']/div/div[6]/a");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isTextPresent(result));
	}
	
	
	@Test(priority=20)
	public void deliver() throws InterruptedException{
		webtest.open(url);
		Thread.sleep(2000);
		webtest.click("link=登录");
		webtest.type("name=username", "13800138006");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1111");
		webtest.click("xpath=//*[@id='loginform']/div/div[6]/a");
		Thread.sleep(1000);
		//送货至
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[1]/b");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[1]/ul/li[1]/a/em");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[2]/ul/li[3]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[3]/ul/li[1]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[4]/ul/li[7]/a");
		Assert.assertTrue(webtest.isTextPresent("北京市"));
	}
	
	@Test(priority=21)
	public void possessionCenter1() throws InterruptedException{
		//资产中心-我的优惠券-兑换优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1兑换优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
		Assert.assertTrue(webtest.isTextPresent("优惠券码不存在"));
		Thread.sleep(5000);
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[3]/form/div[3]/div[1]");
		Thread.sleep(500);
	}
	String url2="http://localhost:8036/Home/user/index.html";
	@Test(priority=24)
	public void possessionCenter2() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-我的优惠券-领取更多优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-2领取更多优惠
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
		Assert.assertTrue(webtest.isTextPresent("全部商品分类"));
	}
	
	@Test(priority=25)
	public void possessionCenter3() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
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
		Assert.assertTrue(webtest.isTextPresent("账户余额"));
	}
	
	@Test(priority=26)
	public void possessionCenter4() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-账户余额-充值
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-2充值
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.type("name=account", "888");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
		Assert.assertTrue(webtest.isTextPresent("商业用途"));
	}
	
	@Test(priority=27)
	public void possessionCenter5() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-账户余额-充值记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-3充值记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a");
		Assert.assertTrue(webtest.isTextPresent("待支付"));
	}
	
	@Test(priority=28)
	public void possessionCenter6() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-账户余额-消费记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-4消费记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
		Assert.assertTrue(webtest.isTextPresent("下单消费"));
	}
	
	@Test(priority=30)
	public void possessionCenter7() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-账户余额-提现记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-5提现记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
		Assert.assertTrue(webtest.isTextPresent("审核通过"));
	}
	
	@Test(priority=34)
	public void possessionCenter8() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-我的积分-积分换购
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1积分换购
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
		Assert.assertTrue(webtest.isTextPresent("订单提交成功"));
	}
	
	@Test(priority=36)
	public void possessionCenter9() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-我的积分-积分明细
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-2积分明细
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[1]/a");
		Assert.assertTrue(webtest.isTextPresent("下单消费"));
	}
	
	@Test(priority=38)
	public void possessionCenter10() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-我的积分-积分累计
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-3积分累计
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
		Assert.assertTrue(webtest.isTextPresent("下单赠送积分"));
	}
	
	@Test(priority=40)
	public void possessionCenter11() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//资产中心-我的积分-积分消费
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-4积分消费
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
		Assert.assertTrue(webtest.isTextPresent("下单消费"));

	}
		
	@Test(priority=41)
	public void focusCenter1() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//关注中心-我的收藏-删除商品
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-1删除商品
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[1]/li[1]/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");
		Assert.assertTrue(webtest.isTextPresent("删除"));

	}
	
	@Test(priority=42)
	public void focusCenter2() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//关注中心-我的收藏-查看详情
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-2查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
		Assert.assertTrue(webtest.isTextPresent("全部商品分类"));

	}
	
	@Test(priority=43)
	public void focusCenter3() throws InterruptedException{
		webtest.open(url2);
		Thread.sleep(1000);
		//关注中心-我的足迹-查看详情
		//2.我的足迹
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//2-1查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ul/li[4]/a");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[4]/div/ul[1]/li/div[1]/div[1]/a/img");
		Assert.assertTrue(webtest.isTextPresent("全部商品分类"));
	}
	
}
