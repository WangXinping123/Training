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

		    		   System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");
		    			WebDriver driver = new FirefoxDriver();
		    			driver.manage().window().maximize();
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("卫衣");
		    			Thread.sleep(1000);
		    			driver.quit();


		    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    			driver.get("https://http://localhost:8069/index.php");
		    			System.out.println("当前打开页面的标题是： "+ driver.getTitle());	
		    			Thread.sleep(1000);
		    			driver.quit();

		    			driver.manage().window().maximize();
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.tagName("_blank")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.xpath("/html/body/div[3]/div/div/dl[1]/dd/div[1]/div/div/a[1]")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("全网通3G+32G")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("官方标配")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("极光色")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("1360-1700元")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("lazy")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("立即购买")).click();
		    			Thread.sleep(1000);
		    			driver.quit();


		    			driver.manage().window().maximize();
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.tagName("_blank")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("电器城")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("生活电器电")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("吸尘器")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("银橙＋15件套＋电动除螨刷 3年换新 终身维修")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("LAVOR")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("SPRINTER")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("拖扫吸式")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("杆式")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("机械式碰撞")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("113cm")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("0mAh")).click();
		    			driver.findElement(By.className("lazy-list")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("立即购买")).click();
		    			Thread.sleep(1000);
		    			Thread.sleep(1000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    			Thread.sleep(3000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("卫衣裤子手机");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("a手机aaaaaa");
		    			Thread.sleep(3000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("手机aaaaaaa");
		    			Thread.sleep(3000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("aaaaaaa手机");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("小米");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("华为");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("三星");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("苹果");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("卫衣");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("帽子");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("眼镜");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("T恤");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("    ");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("   aa、、aaa手机");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("眼镜手机");
		    			Thread.sleep(3000);
		    			driver.quit();
		    		}

		    		} 		    
	

