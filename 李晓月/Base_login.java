package Dingdan;

import com.webtest.core.WebDriverEngine;

public class Base_login{
	private WebDriverEngine webtest;
	  public Base_login(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String username,String password) throws InterruptedException 
	  {
		  if(is_login()) {
			  webtest.click("link=��ȫ�˳�");
		  }
		  	webtest.open("http://localhost:8036/Home/Index/index.html");
		  	Thread.sleep(2000);
			webtest.click("link=��¼");
			Thread.sleep(2000);
			webtest.type("name=username", username);
			webtest.type("name=password", password);
			webtest.type("name=verify_code", "1234");
			webtest.click("name=sbtbutton");
			Thread.sleep(2000);
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("link=��ȫ�˳�");
	  }
}
