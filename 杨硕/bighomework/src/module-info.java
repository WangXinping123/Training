module bighomework {
	package com.testngDemo;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class DemoTestng {
	    @BeforeClass
	    public void setup()
	    {
	        System.out.println("begin test");
	    }
	    @Test
	    public void test1()
	    {
	        System.out.println("at test1");
	    }
	    @Test
	    public void test2()
	    {
	        System.out.println("at test2");
	    }
	    @Test
	    public void test3()
	    {
	        System.out.println("at test3");
	    }
	    @AfterClass
	    public void teardown()
	    {
	        System.out.println("end test");
	    }

	}

}
ublic static void main(String[] args) throws InterruptedException {
	
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
		driver.findElement(By.tagtName("_blank")).click();
		Thread.sleep(1000);
		driver.findElement(By.xPath("/html/body/div[3]/div/div/dl[1]/dd/div[1]/div/div/a[1]")).click();
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
		driver.findElement(By.tagtName("_blank")).click();
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

		

	}

	}