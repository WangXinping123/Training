package com.webtest.jinmingming.fenxiao.fenxiaoguanli;

import org.testng.annotations.Test;

import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;

public class fenxiaoguanli2 extends BaseTest{
	@Test
	public void fenxiaoshnagliebiao(){
		Action action=new Action(webtest);
		action.login();
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//分销
		webtest.click("link=分销");
		webtest.click("link=分销商列表");
		//退出系统
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");
	}
}
