package com.webtest.yjp;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 我的评价
 * @author yjp
 *
 */
public class Evaluation extends BaseTest{
	static public String url="http://localhost:8036/";
	
	Login action;
	
	@BeforeClass(description="登录")
	public void setup()
	{
		action=new Login(webtest);
		webtest.open(url);
		action.login("13800138006 ", "123456");
		webtest.click("link=我的评价");

	}
	
	@Test(description="已评论区查看商品评论")
	public void seeEval(){
//		webtest.click("link=已评论");
//		webtest.click("xpath=//table[contains(text(),'201911261359351951')]/");
		webtest.click("xpath=//div[@class='order-alone-li']/table[1]/tr[2]/td[6]/div/p/a");
		assertTrue(webtest.isTextPresent("评价订单"));
	}
//	
//	@Test(description="对待评论订单进行评论")
//	public void eval(){
//		
//	}

}
