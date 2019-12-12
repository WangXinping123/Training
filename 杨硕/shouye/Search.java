package com.webtest.shouye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Test
public class Search  extends BaseTest{
	@Test(description="ËÑË÷")
  public void a() throws InterruptedException {
		webtest.open("http://localhost:8069");
		Thread.sleep(1000);
		webtest.type("className=ecsc-search-input","aaaaaaaaÊÖ»ú");
		webtest.click("className=ecsc-search-button");
		Thread.sleep(1000);
  }
	@Test(description="ËÑË÷2")
	  public void b() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","aaaaÊÖ»úaaaa");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷3")
	  public void c() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÊÖ»ú");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷4")
	  public void d() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","      ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	}
	@Test(description="ËÑË÷5")
	  public void e() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷6")
	  public void f() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»úÊÖ»ú");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷7")
	  public void g() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÊÖ»úÑÛ¾µ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷8")
	  public void h() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÑÛ¾µÊÖ»ú");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷9")
	  public void i() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","Ç¹Ö§");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷10")
	  public void j() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÏãÑÌ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷11")
	  public void k() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","¹ÜÖÆµ¶¾ß");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷12")
	  public void l() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÊÖ»úÊÖ»úÑÛ¾µÑÛ¾µ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷13")
	  public void m() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ÑÛ¾µÊÖ»úÊÖ»úÑÛ¾µÑÛ¾µ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷14")
	  public void n() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","  £¬£¬£¬£¬ÊÖ»ú");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="ËÑË÷15")
	  public void mn() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","£¬£¬£¬   ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	
}

