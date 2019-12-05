package com.webtest.jinmingming.yingxiao.pingtuangou;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.jinmingming.Action;

public class pintuangou1 extends BaseTest{
	@Test
	public void fenxiangtuan(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		webtest.click("link=分享团");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
}
