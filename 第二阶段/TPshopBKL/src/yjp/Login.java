package yjp;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

/**
 * Login
 * @author 杨久鹏
 *
 */
public class Login extends BaseTest{
	
	private WebDriverEngine webtest;
	  public Login(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String phone,String password) 
	  {
	
		  if(is_login()) {
			  webtest.click("link=安全退出");
		  }
			webtest.click("link=登录");
			webtest.type("name=username", phone);
			webtest.type("name=password", password);
			webtest.type("id=verify_code", "1");
			webtest.click("link=登    录");
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("link=安全退出");
	  }
	  
	  

}
