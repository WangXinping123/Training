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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÎÀÒÂ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
   						driver.quit();	

		    			System.setProperty("webdriver.gecko.driver","F:\\geckodriver-v0.26.0-win64\\geckodriver.exe"); 
		    	   		WebDriver driver = new FirefoxDriver();
 						driver.manage().window().maximize();
 						driver.get("http://localhost:8069");
	    				Thread.sleep(3000);
		    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    			System.out.println("µ±Ç°´ò¿ªÒ³ÃæµÄ±êÌâÊÇ£º "+ driver.getTitle());	
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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÊÖ»ú¿ã×Ó");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("¿ã×ÓÊÖ»ú");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»ú");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaaÊÖ»úaaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÊÖ»úaaaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;

		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaaaaÊÖ»ú");
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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("   aa¡¢¡¢aaaÊÖ»ú");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("Ð¡Ã×");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("»ªÎª");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÈýÐÇ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("Æ»¹û);
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÎÀÒÂ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("Ã±×Ó");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ÑÛ¾µ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("TÐô");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("Ç¹");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("ÏãÑÌ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("¹ÜÖÆµ¶¾ß");
		    	        driver.findElement(By.className("ecsc-search-button")).click();

		    			Thread.sleep(1000);
		    			driver.quit();
		    			

*/
		    		}

		    		} 		   
	

