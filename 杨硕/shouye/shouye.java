package com.webtest.shouye;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import java.io.File;
	import java.util.concurrent.TimeUnit;

		 
		public class shouye {
		    public static void main(String[] args) throws Exception {

		    		    System.setProperty("webdriver.gecko.driver","F:\\geckodriver-v0.26.0-win64\\geckodriver.exe"); 
		    			WebDriver driver = new FirefoxDriver();
	  				/*	driver.manage().window().maximize();
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(3000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("寮丗");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
   						driver.quit();	

		    			System.setProperty("webdriver.gecko.driver","F:\\geckodriver-v0.26.0-win64\\geckodriver.exe"); 
		    	   		WebDriver driver = new FirefoxDriver();
 						driver.manage().window().maximize();
 						driver.get("http://localhost:8069");
	    				Thread.sleep(3000);
		    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    			System.out.println("輝念嬉蝕匈中議炎籾頁�� "+ driver.getTitle());	
		    			Thread.sleep(1000);
		    			driver.quit();
		    			*/

*/
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
/*
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("返字帥徨");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("帥徨返字");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaa返字aaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("返字aaaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;

		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaaaa返字");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("      ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			river.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("   aa、、aaa返字");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("弌致");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("鯖葎");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("眉佛");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("道惚);
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("寮丗");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("単徨");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("凛承");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("T偐");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("嚢");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("�穡�");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("砿崙偽醤");
		    	        driver.findElement(By.className("ecsc-search-button")).click();

		    			Thread.sleep(1000);
		    			driver.quit();
		    			

*/
		    		}

		    		} 		   
	

