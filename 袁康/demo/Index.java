package com.webtest.demo;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.dataprovider.ExcelDataProvider;
@Listeners({ ApiListener.class})
public class Index extends Admin_Login{
	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("G:/testclass/data/goodsmage.xlsx", "Sheet5");
	}

	
	@Test
	public void userList(){
		webtest.click("xpath=//a[contains(text(), '首页')]");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='commfunc-con']/a[5]/i");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='index|User']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='添加会员']");
		webtest.type("name=nickname", "user001");
		webtest.type("name=password", "user001");
		webtest.type("name=mobile", "13933133167");
		webtest.type("name=email", "749822099@qq.com");
		webtest.click("xpath=//a[@id='submitBtn']");
		Assert.assertTrue(getDriver().getPageSource().contains("user001"));

		webtest.leaveFrame();
	}

}
