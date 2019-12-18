package yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.demo.Front_login;
/**
 * 杨久鹏
 * 安全设置
 */
public class SecuritySet extends BaseTest {
	
	static public String url = "http://localhost:8036/";
	SoftAssert soft = new SoftAssert();

	Login action;

	@BeforeClass(description = "登录")
	public void setup() throws Exception {
		action = new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");

		for (int i = 1; i < 5; i++) {
			webtest.downClick();
		}
		webtest.click("link=安全设置");

	}

	@Test(description = "更改登录密码成功")
	public void changePsw_Success() throws InterruptedException {
		webtest.click("link=安全设置");
		webtest.click("xpath=//div[@class='safe_list_set']/ul[1]/li[3]/a");
		// for(int i=1;i<5;i++){
		// webtest.downClick();
		// }
		// webtest.mouseOffset();
		// webtest.click("name=old_password");
		webtest.typeAndClear("id=old_password", "123456");// could not be
															// scrolled into
															// view
		webtest.typeAndClear("name=new_password", "123456");
		webtest.typeAndClear("name=confirm_password", "123456");
		webtest.click("xpath=//input[@value='保存']");
		soft.assertTrue(webtest.isElementPresent("新密码不能和旧密码相同"));
		soft.assertAll();
	}

	@Test(description = "更改手机验证失败，新手机号位数不足")
	public void phoneCheck_Fail1() {
		webtest.click("link=安全设置");
		webtest.click("link=已验证(点击修改)");
		webtest.typeAndClear("name=code", "'1=1");// SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.typeAndClear("name=mobile", "110");
		webtest.typeAndClear("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("新手机格式错误"));
	}

	@Test(description = "更改手机验证失败，新手机号输入为中文")
	public void phoneCheck() {
		webtest.click("link=安全设置");
		webtest.click("link=已验证(点击修改)");
		webtest.typeAndClear("name=code", "'1=1");// SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.typeAndClear("name=mobile", "测试");
		webtest.typeAndClear("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("新手机格式错误"));
	}

	@Test(description = "修改支付密码，获取验证码")
	public void GetVerifCode() throws InterruptedException {
		webtest.click("link=安全设置");
		webtest.click("xpath=//div[@class='safe_list_set']/ul[2]/li[3]/a");
		webtest.click("xpath=//input[@value='获取验证码']");
		Thread.sleep(1000);
		soft.assertTrue(webtest.isTextPresent("短信验证码功能关闭, 无需校验验证码"));
		webtest.click("link=确定");
		soft.assertAll();

	}

	@Test(description = "修改支付密码，验证码错误")
	public void ModifyPswVerifCode_Fail() {
		for (int i = 1; i < 5; i++) {
			webtest.downClick();
		}
		webtest.click("link=安全设置");
		webtest.click("xpath=//div[@class='safe_list_set']/ul[2]/li[3]/a");
		webtest.typeAndClear("name=tpcode", "11");
		webtest.click("xpath=//input[@value='下一步']");
		assertTrue(webtest.isTextPresent("修改失败"));
	}

	@Test(description = "修改支付密码成功")
	public void ModifyPassword_Success() {
		webtest.click("link=安全设置");
		webtest.click("xpath=//div[@class='safe_list_set']/ul[2]/li[3]/a");
		webtest.typeAndClear("name=tpcode", "'1=1");// SQL注入
		webtest.click("xpath=//input[@value='下一步']");
		webtest.typeAndClear("name=new_password", "123456");
		webtest.typeAndClear("name=confirm_password", "123456");
		webtest.click("xpath=//input[@value='下一步']");
		assertTrue(webtest.isTextPresent("修改失败"));
	}

	@Test(description = "邮箱验证成功")
	public void mailtest() {
		webtest.click("link=安全设置");
		webtest.click("link=未验证(点击验证)");
		webtest.typeAndClear("name=email", "987580132@qq.com");
		webtest.typeAndClear("name=code", "1111");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isTextPresent("非法操作"));
	}

}
