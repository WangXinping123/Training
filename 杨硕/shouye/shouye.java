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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("����");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
   						driver.quit();	

		    			System.setProperty("webdriver.gecko.driver","F:\\geckodriver-v0.26.0-win64\\geckodriver.exe"); 
		    	   		WebDriver driver = new FirefoxDriver();
 						driver.manage().window().maximize();
 						driver.get("http://localhost:8069");
	    				Thread.sleep(3000);
		    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    			System.out.println("��ǰ��ҳ��ı����ǣ� "+ driver.getTitle());	
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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("�ֻ�����");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("�����ֻ�");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("�ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ�");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaa�ֻ�aaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("�ֻ�aaaaaaa");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
;

		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("aaaaaaa�ֻ�");
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
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("   aa����aaa�ֻ�");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("С��");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("��Ϊ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("����");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ƻ��);
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("����");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("ñ��");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("�۾�");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000); 
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("T��");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.quit();
		    			
		    			driver.get("http://localhost:8069");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("ǹ");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    	        Thread.sleep(1000);
		    	        driver.findElement(By.className("ecsc-search-input")).sendKeys("����");
		    	        driver.findElement(By.className("ecsc-search-button")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-input")).sendKeys("���Ƶ���");
		    	        driver.findElement(By.className("ecsc-search-button")).click();

		    			Thread.sleep(1000);
		    			driver.quit();
		    			

*/
		    		}

		    		} 		   
	

