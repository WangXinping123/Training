package com.webtest.jinmingming.yingxiao.pingtuangou;

import org.testng.annotations.Test;

import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;

public class pintuangou2 extends BaseTest{
	@Test
	public void fenxiangtuan(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		webtest.click("link=佣金团");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
}
