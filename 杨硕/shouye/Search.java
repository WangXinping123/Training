package com.webtest.shouye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

@Test
public class Search  extends BaseTest{
	@Test(description="朴沫")
  public void a() throws InterruptedException {
		webtest.open("http://localhost:8069");
		Thread.sleep(1000);
		webtest.type("className=ecsc-search-input","aaaaaaaa返字");
		webtest.click("className=ecsc-search-button");
		Thread.sleep(1000);
  }
	@Test(description="朴沫2")
	  public void b() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","aaaa返字aaaa");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫3")
	  public void c() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","返字");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫4")
	  public void d() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","      ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	}
	@Test(description="朴沫5")
	  public void e() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫6")
	  public void f() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字返字");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫7")
	  public void g() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","返字凛承");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫8")
	  public void h() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","凛承返字");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫9")
	  public void i() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","嚢屶");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫10")
	  public void j() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","�穡�");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫11")
	  public void k() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","砿崙偽醤");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫12")
	  public void l() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","返字返字凛承凛承");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫13")
	  public void m() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","凛承返字返字凛承凛承");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫14")
	  public void n() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","  ��������返字");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	@Test(description="朴沫15")
	  public void mn() throws InterruptedException {
			webtest.open("http://localhost:8069");
			Thread.sleep(1000);
			webtest.type("className=ecsc-search-input","������   ");
			webtest.click("className=ecsc-search-button");
			Thread.sleep(1000);
	  }
	
}

