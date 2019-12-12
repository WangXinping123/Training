package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;
import com.edu.core.HttpDriver;
import com.edu.dataprovider.ExcelDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

/**
 * 项目名称：Qingguo   
 * 类名称：Login   
 * 类描述： 
 * @author wangxinping 
 * 创建时间：2019年12月11日 下午5:44:07   
 * @version  
 */
@Listeners(ApiListener.class)
public class Login {
	String login_url = "/common/fgadmin/login";
	Checker checker = null;

	public void login(Object phoneArea, Object phoneNumber, Object password) {
		JSONObject user = new JSONObject();
		user.element("phoneArea", phoneArea);
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		checker = new Checker(result);
	}

	@Test(description = "成功登录")
	public void testLoginSuccess() throws Exception {
		login("86", "20000000000", "netease123");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "200");
	}

	@Test(priority = 2, description = "错误数据，密码错误")
	public void testLoginWrongPwd() throws Exception {
		login("86", "20000000000", "netease112333");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "400");
	}
	
	@Test(priority = 3, description = "错误数据，用户名错误")
	public void testLoginWrongPhone() throws Exception {
		login("86", "2000000000005499", "netease123");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "400");
	}
	
	@Test(priority = 4, description = "错误数据，用户名或密码错误")
	public void testLoginForWrongArea() throws Exception {
		login(86, "20000000000", "netease112333");
		checker.verifyTextPresent("message");
		checker.verifyXpath("code", "400");
	}

	@Test(priority = 5, description = "用户名为空")
	public void testLoginForNullNumber() throws Exception {
		login("86", "", "netease123");
		checker.verifyTextPresent("message");
		checker.verifyXpath("message", "用户名为空");
	}
}
