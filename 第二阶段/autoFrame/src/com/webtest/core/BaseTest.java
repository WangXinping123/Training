package com.webtest.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen 初始化浏览器
 */

public class BaseTest {

	public static WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
		if (driverType.equalsIgnoreCase("firefox")) {
			String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();

			Log.info("Using Firefox");
		} else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver", chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
		} else {
			return null;
		}
		return driver;
	}

	/**
	 * 
	 * 初始化浏览器
	 * 
	 */

	@BeforeClass
	public void doBeforeClass() throws Exception {
		driverType = ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	}

	 @AfterClass
	 public void doAfterMethod() {
	 if(this.driver != null){
	 this.driver.quit();
	 }
	 Log.info("Quitted Browser");
	 }

	public WebDriver getDriver() {
		return driver;
	}

	public static void baseLogin(String user,String pwd) throws Exception{
		// 打开网页
		webtest.open("http://localhost:8036/Home/Index/index.html");
		Thread.sleep(2000);
		// 点击“登录”链接
		webtest.click("xpath=//a[contains(text(),'登录')]");
		Thread.sleep(1000);
		webtest.type("name=username", user);
		webtest.type("name=password", pwd);
		webtest.type("name=verify_code", "1111");
		webtest.click("name=sbtbutton");
	}
}
