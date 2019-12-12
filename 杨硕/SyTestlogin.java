package com.webtest.shouye;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class SyTestlogin extends BaseTest{
  @Test (description="登入后首页跳转功能1")
  public void SYtest1() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'我的订单')]");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("全部订单 "));
  }
  @Test (description="登入后首页跳转功能2")
  public void SYtest2() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'我的收藏')]");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("商品收藏"));
  }
  @Test (description="登入后首页跳转功能3")
  public void SYtest3() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'我的浏览收藏')]");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("常见问题"));
  } 
  @Test (description="登入后首页跳转功能4")
  public void SYtest4() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=share-shopcar-index");
		Thread.sleep(200);
		assertTrue(webtest.isTextPresent("购物车空空的哦~，去看看心仪的商品吧~"));
  } 
  
}
