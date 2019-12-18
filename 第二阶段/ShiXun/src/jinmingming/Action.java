package jinmingming;

import com.webtest.core.WebDriverEngine;
/**
 * 项目名称：TPSHOP 类名称：Action 类描述： 后台登录操作
 * 
 * @author 靳明明      
 * @version
 */
public class Action{ 

	private  WebDriverEngine webtest;
	public Action(WebDriverEngine webtest){	
		this.webtest=webtest;
	}

	public void login(){
		//Login登录
		webtest.open("http://localhost:8036/index.php/Admin/Index/index#");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=vertify", "1234");//验证码已经屏蔽，输入任意四个值都可
		webtest.click("name=submit");
	}
}
