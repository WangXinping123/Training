package com.webtest.shouye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Test
public class Search  extends BaseTest{
	@Test(description="����")
  public void a() throws InterruptedException {
		webtest.open("http://localhost:8069");
		Thread.sleep(1000);
		webtest.type("className=ecsc-search-input","aaaaaaaa�ֻ�");
		webtest.click("className=ecsc-search-button");
		Thread.sleep(1000);
  }
	@Test(description="����2")
	  public void b() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","aaaa�ֻ�aaaa");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����3")
	  public void c() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�ֻ�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����4")
	  public void d() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","      ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	}
	@Test(description="����5")
	  public void e() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����6")
	  public void f() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ��ֻ�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����7")
	  public void g() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�ֻ��۾�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����8")
	  public void h() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�۾��ֻ�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����9")
	  public void i() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","ǹ֧");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����10")
	  public void j() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","����");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����11")
	  public void k() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","���Ƶ���");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����12")
	  public void l() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�ֻ��ֻ��۾��۾�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����13")
	  public void m() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�۾��ֻ��ֻ��۾��۾�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����14")
	  public void n() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","  ���������ֻ�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="����15")
	  public void mn() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","������   ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	
}

