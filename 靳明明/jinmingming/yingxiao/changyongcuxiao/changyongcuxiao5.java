package com.webtest.jinmingming.yingxiao.changyongcuxiao;

import org.testng.annotations.Test;
import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;

public class changyongcuxiao5 extends BaseTest{
	
	@Test
	public void yushouguanli() throws Exception{
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//营销
		webtest.click("link=营销");
		webtest.click("link=预售管理");
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
	}
	
}
