package com.edu.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.edu.utils.DbHelper;
import com.edu.utils.Log;
import com.edu.utils.ReadPro;
import com.edu.core.WebDriverEngine;

public class BaseTest {
	public  WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	public DbHelper db ;
	
	@BeforeMethod
	public void setUp()	throws Exception {
		db=DbHelper.getInstance();
		System.out.println("初始化数据库");
		
  }

	@AfterMethod
	public void tearDown() throws Exception {
		
		db.close();
	}
	
	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadPro.getPropValue("gecko_driver");
			String firefox_path = ReadPro.getPropValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadPro.getPropValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}

		
		return driver;

	
	}


	/**
	 * 
	 *初始化浏览器
	 * 
	 */


	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType=ReadPro.getPropValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	
	
	
	}


//	@AfterSuite
//	public void doAfterMethod() {
//		if(this.driver != null){
//			this.driver.quit();
//			}
//		Log.info("Quitted Browser");
//	}
//	

	

	
	public WebDriver getDriver() {
        return driver;
    }



}
