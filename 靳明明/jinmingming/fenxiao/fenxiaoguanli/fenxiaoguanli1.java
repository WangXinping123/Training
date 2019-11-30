package com.webtest.jinmingming.fenxiao.fenxiaoguanli;

import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.jinmingming.Action;

public class fenxiaoguanli1 extends BaseTest{
	@Test
	public void fenxiaoshangpin(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//分销
		webtest.click("link=分销");
		webtest.click("link=分销商品");
		//退出系统
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");
	}
}
