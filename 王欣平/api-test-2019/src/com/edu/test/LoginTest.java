package com.edu.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener2;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

/**
 * 项目名称：api-test-2019   
 * 类名称：LoginTest   
 * 类描述：   
 * @author user  
 * 创建时间：2019年9月18日 下午2:28:17   
 * @version  
 */
@Listeners(ApiListener2.class)
public class LoginTest {
	String login_url = "/common/fgadmin/login";
	Checker checker = null;
	
	public void login(Object phoneArea,Object phoneNumber,Object password) {
		JSONObject user = new JSONObject();
		user.element("phoneArea", phoneArea);
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		checker=new Checker(result);
	}

	@Test
	public void testLoginSuccess() throws Exception {
		login("86", "200000000065", "netease123");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "200");
	}
	
	@Test
	public void testLoginForWrongPhone() throws Exception {
		login(86, "200000000065", "netease123");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "400");
	}
	
	@Test
	public void testLoginForWrongPwd() throws Exception {
		login(86, "200000000065", "netease12333");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "用户名或者密码错误");
	}
}
