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
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("����");
		    			Thread.sleep(1000);
		    			driver.quit();


		    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    			driver.get("https://http://localhost:8069/index.php");
		    			System.out.println("��ǰ��ҳ��ı����ǣ� "+ driver.getTitle());	
		    			Thread.sleep(1000);
		    			driver.quit();

		    			driver.manage().window().maximize();
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.tagName("_blank")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.xpath("/html/body/div[3]/div/div/dl[1]/dd/div[1]/div/div/a[1]")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("ȫ��ͨ3G+32G")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("�ٷ�����")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("����ɫ")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("1360-1700Ԫ")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("lazy")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("��������")).click();
		    			Thread.sleep(1000);
		    			driver.quit();


		    			driver.manage().window().maximize();
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.tagName("_blank")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("������")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("���������")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("������")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("���ȣ�15���ף��綯����ˢ 3�껻�� ����ά��")).click();
		    			Thread.sleep(1000);
		    	        driver.findElement(By.linkText("LAVOR")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("SPRINTER")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("��ɨ��ʽ")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("��ʽ")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("��еʽ��ײ")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("113cm")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("0mAh")).click();
		    			driver.findElement(By.className("lazy-list")).click();
		    			Thread.sleep(1000);
		    			driver.findElement(By.linkText("��������")).click();
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
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("���¿����ֻ�");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("a�ֻ�aaaaaa");
		    			Thread.sleep(3000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("�ֻ�aaaaaaa");
		    			Thread.sleep(3000);
		    			driver.quit();

		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("aaaaaaa�ֻ�");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("С��");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("��Ϊ");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("����");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("ƻ��");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("����");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("ñ��");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("�۾�");
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("T��");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("    ");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("   aa����aaa�ֻ�");
		    			Thread.sleep(3000);
		    			driver.quit();
		    			
		    			driver.get("https://http://localhost:8069/index.php");
		    			Thread.sleep(1000);
		    			driver.findElement(By.className("ecsc-search-button")).sendKeys("�۾��ֻ�");
		    			Thread.sleep(3000);
		    			driver.quit();
		    		}

		    		} 		    
	

