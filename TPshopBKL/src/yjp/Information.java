package yjp;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.mail.handlers.image_gif;
import com.webtest.core.ApiListener;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.demo.Front_login;

@Listeners(ApiListener.class)
/**
 * 个人信息
 * 
 * @author yjp
 *
 */
public class Information extends BaseTest {
	static public String url = "http://localhost:8036/";

	Login action;

	@BeforeClass(description = "登录")
	public void setup() throws Exception {
		action = new Login(webtest);
		webtest.open(url);
		action.login("13800138006", "123456");

		webtest.click("link=个人信息");

	}

	@DataProvider(name = "name")
	public Object[][] getExcelDada_Name() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/information.xlsx", "Sheet1");
	}

	@Test(description = "修改个人信息,昵称", dataProvider = "name")
	public void modify_Name(String image_url, String nickname, String sex, String birthday, String dataAssert)
			throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		webtest.click("link=个人信息");
		webtest.ModifyElementPro("//input[@id='head_pic']", "arguments[0].setAttribute('type','file');");
		webtest.typeAndClear("xpath=//input[@id='head_pic']", image_url);

		Thread.sleep(2000);
		webtest.typeAndClear("name=nickname", nickname);
		webtest.click("xpath=//input[name='sex',value='" + sex + "']");
		webtest.typeAndClear("name=birthday", birthday);
		webtest.click("xpath=//input[@value='确认保存']");
		soft.assertTrue(webtest.isTextPresent(dataAssert));

		Thread.sleep(5000);
		soft.assertAll();
	}

	@DataProvider(name = "birthday")
	public Object[][] getExcelDada_Birthday() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/information.xlsx", "Sheet2");
	}

	@Test(description = "修改个人信息,生日", dataProvider = "birthday")
	public void modify_Birthday(String image_url, String nickname, String sex, String birthday, String dataAssert)
			throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		webtest.click("link=个人信息");
		webtest.ModifyElementPro("//input[@id='head_pic']", "arguments[0].setAttribute('type','file');");
		webtest.typeAndClear("xpath=//input[@id='head_pic']", image_url);
		Thread.sleep(2000);
		webtest.typeAndClear("name=nickname", nickname);
		webtest.click("xpath=//input[name='sex',value='" + sex + "']");
		webtest.typeAndClear("name=birthday", birthday);
		webtest.click("xpath=//input[@value='确认保存']");
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		Thread.sleep(5000);
		soft.assertAll();

	}

	@DataProvider(name = "img")
	public Object[][] getExcelDada_Img() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data-yjp/information.xlsx", "Sheet3");
	}

	@Test(description = "上传非图片文件", dataProvider = "img")
	public void modify_Img(String image_url, String nickname, String sex, String birthday, String dataAssert)
			throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		webtest.click("link=个人信息");
		webtest.ModifyElementPro("//input[@id='head_pic']", "arguments[0].setAttribute('type','file');");
		webtest.typeAndClear("xpath=//input[@id='head_pic']", image_url);
		Thread.sleep(2000);
		webtest.typeAndClear("name=nickname", nickname);
		webtest.click("xpath=//input[name='sex',value='" + sex + "']");
		webtest.typeAndClear("name=birthday", birthday);
		webtest.click("xpath=//input[@value='确认保存']");
		soft.assertTrue(webtest.isTextPresent(dataAssert));
		Thread.sleep(5000);
		soft.assertAll();

	}

	@Test(description = "更换绑定手机成功")
	public void Bind_Phone() {
		webtest.click("link=更换绑定");
		webtest.typeAndClear("name=code", "'1=1");// SQL注入方式绕过验证
		webtest.click("xpath=//button[contains(text(),'下一步')]");
		webtest.typeAndClear("name=mobile", "13800138006");
		webtest.typeAndClear("name=code", "'1=1");
		webtest.click("xpath=//button[contains(text(),'确定修改')]");
		assertTrue(webtest.isTextPresent("修改成功"));
	}

	@Test(description = "绑定邮箱成功")
	public void modify_Success() {
		webtest.click("link=未绑定");
		webtest.typeAndClear("name=email", "987580132@qq.com");
		webtest.typeAndClear("name=code", "'1=1");
		webtest.click("xpath=//button[@type='submit']");
		assertTrue(webtest.isTextPresent("绑定成功"));
	}

	@Test(description = "跳转到安全设置")
	public void goToSecurity() {
		webtest.click("link=个人信息");
		webtest.click("link=安全设置");
		assertTrue(webtest.isTextPresent("互联网账号存在被盗风险，建议您定期更改密码以及保护账户安全。"));
	}

}
