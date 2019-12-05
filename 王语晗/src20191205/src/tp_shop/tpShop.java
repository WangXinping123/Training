package tp_shop;

import javax.imageio.spi.RegisterableService;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import com.google.common.base.Throwables;
import com.webtest.core.BaseTest;

public class tpShop extends BaseTest{
	@Test(priority=1)
	public void register1() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（密码为纯数字）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register2() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（密码为纯数字）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "111111");
		webtest.type("id=password2", "111111");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register3() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（密码为纯字母）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13888888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abcdef");
		webtest.type("id=password2", "abcdef");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register4() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（密码为纯字母）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "9@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abcdef");
		webtest.type("id=password2", "abcdef");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register5() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（密码为数字和字母）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13788888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "ab1234");
		webtest.type("id=password2", "ab1234");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register6() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（密码为数字和字母）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "7@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "ab1234");
		webtest.type("id=password2", "ab1234");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register7() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（密码中含有特殊字符）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13688888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abc%$&");
		webtest.type("id=password2", "abc%$&");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register8() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（密码中含有特殊字符）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "6@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abc%$&");
		webtest.type("id=password2", "abc%$&");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register9() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（密码全为特殊字符）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13588888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "@#$%&*");
		webtest.type("id=password2", "@#$%&*");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register10() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（密码全为特殊字符）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "5@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "@#$%&*");
		webtest.type("id=password2", "@#$%&*");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister1() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（密码长度小于六位）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15188888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "1");//错误密码
		webtest.type("id=password2", "1");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister2() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（密码长度小于六位）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "11@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "1");
		webtest.type("id=password2", "1");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister3() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（密码长度大于十六位）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15288888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "888888888888888888");//错误密码
		webtest.type("id=password2", "888888888888888888");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
		
	@Test(priority=1)
	public void wrongRegister4() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（密码长度大于十六位）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "12@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "888888888888888888");
		webtest.type("id=password2", "888888888888888888");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister5() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（确认密码与密码不一致）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15388888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "567891");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister6() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（确认密码与密码不一致）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "13@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "567891");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister7() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（手机号码不符合规范）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "1");//错误手机号码
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister8() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（邮箱不符合规范）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "1");//错误邮箱
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister9() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（手机号码中输入中文）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "错误手机号");//错误手机号码
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister10() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（邮箱中输入中文)
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "错误邮箱");//错误邮箱
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister11() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（手机号码中输入英文)
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "abababababa");//错误手机号码
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister12() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（未填写手机号）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister13() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（未填写邮箱）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister14() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//手机注册（未填写推荐人手机号）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15488888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister15() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//邮箱注册（未填写推荐人手机号）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "14@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void wrongRegister16() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册（验证码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister17() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//邮箱注册（验证码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=verify_code", "");
		webtest.type("id=password", "111111");
		webtest.type("id=password2", "111111");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=2)
	public void login1() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//登录（手机号登录）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void login2() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//登录（邮箱登录）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin1() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//手机号登录（手机号错误）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "1234");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin2() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//邮箱登录（邮箱错误）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin3() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//手机登录（密码错误）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "a");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin4() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//邮箱登录（密码错误）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "a");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin5() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//登录（手机号未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin6() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//登录（邮箱未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin7() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//手机登录（密码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin8() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//邮箱登录（密码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin9() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//手机登录（验证码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin10() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//邮箱登录（验证码未填写）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=3)
	public void deliver() throws InterruptedException{
		//送货至
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[1]/b");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[1]/ul/li[1]/a/em");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[2]/ul/li[3]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[3]/ul/li[1]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[4]/ul/li[7]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter1() throws InterruptedException{
		//资产中心-我的优惠券-兑换优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1兑换优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
	}
	
	@Test(priority=4)
	public void possessionCenter2() throws InterruptedException{
		//资产中心-我的优惠券-领取更多优惠券
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-2领取更多优惠
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
	}
	
	@Test(priority=4)
	public void possessionCenter3() throws InterruptedException{
		//资产中心-账户余额-提现
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-1提现（支付宝）
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/dl/dd[1]/label");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[2]/div[3]/a");
		webtest.type("id=pop_card", "13988888888");
		webtest.type("id=pop_name", "admin");
		webtest.click("xpath=//*[@id='add_card']");
		webtest.type("name=money", "888");
		webtest.type("name=paypwd", "123456");
		webtest.click("xpath=//*[@id='save_data']");
	}
	
	@Test(priority=4)
	public void possessionCenter4() throws InterruptedException{
		//资产中心-账户余额-充值
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-2充值
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.type("name=account", "888");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
	}
	
	@Test(priority=4)
	public void possessionCenter5() throws InterruptedException{
		//资产中心-账户余额-充值记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-3充值记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter6() throws InterruptedException{
		//资产中心-账户余额-消费记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-4消费记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter7() throws InterruptedException{
		//资产中心-账户余额-提现记录
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-5提现记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter8() throws InterruptedException{
		//资产中心-我的积分-积分换购
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1积分换购
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
	}
	
	@Test(priority=4)
	public void possessionCenter9() throws InterruptedException{
		//资产中心-我的积分-积分明细
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-2积分明细
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter10() throws InterruptedException{
		//资产中心-我的积分-积分累计
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-3积分累计
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter11() throws InterruptedException{
		//资产中心-我的积分-积分消费
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-4积分消费
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
	}
		
	@Test(priority=4)
	public void focusCenter1() throws InterruptedException{
		//关注中心-我的收藏-删除商品
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-1删除商品
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[1]/li[1]/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");
	}
	
	@Test(priority=4)
	public void focusCenter2() throws InterruptedException{
		//关注中心-我的收藏-查看详情
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-2查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
	}
	
	@Test(priority=4)
	public void focusCenter3() throws InterruptedException{
		//关注中心-我的足迹-查看详情
		//2.我的足迹
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//2-1查看详情
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ul/li[3]/a");
	}
}
