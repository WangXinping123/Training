package demoyk;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import com.webtest.core.BaseTest;
/**
 * 项目名称：TPSHOP 类名称：Admin_Login 类描述： 后台登录操作
 * 
 * @author 袁康      
 * @version
 */
public class Admin_Login extends BaseTest{
	
	@BeforeClass
	public static void testLogin() {
		webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("id=vertify", "1111");
		webtest.click("xpath=//input[@type='button']");
		assertTrue(webtest.isTextPresent("admin"));
	}
	

}
