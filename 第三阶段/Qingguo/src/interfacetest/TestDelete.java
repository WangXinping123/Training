package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

/**
 * 项目名称：Qingguo   
 * 类名称：TestDelete   
 * 类描述： 删除地址
 * @author 李晓月
 * 创建时间：2019年12月18日 下午2:27:43   
 * @version  
 */
public class TestDelete {
	String json_result=" ";
	String delete_url="/fgadmin/delete";
	Checker checker = null;
	
	
	//未登录状态下
	public void DeleteNoLogin(Object id) throws Exception{
		JSONObject Id = new JSONObject();
		Id.element("id", id);
		Id.element("login",json_result);
		String result=HttpDriver.doPost(delete_url, Id);
		System.out.println(result);
		checker = new Checker(result);
	} 	

	@Test(priority=1,description="未登录状态下删除存在的指定id的地址")
	public void testDelete1() throws Exception {
		DeleteNoLogin("123456");
		checker.verifyXpath("code", "400");
	}
		
	@Test(priority=2,description="删除错误不存在的id的地址")
	public void testDelete2() throws Exception {
		DeleteNoLogin("456789");
		checker.verifyXpath("code", "400");
	}
		
	@Test(priority=3,description="未登录状态下删除指定id的地址")
	public void testDelete3() throws Exception {
		DeleteNoLogin(" ");
		checker.verifyXpath("code", "400");
	}
		
	@Test(priority=4,description="删除格式错误的id的地址")
	public void testDelete4() throws Exception {
		DeleteNoLogin("{123456}");
		checker.verifyXpath("code", "400");
	}
	

	//登录失败
		public void DeleteLoginFail(Object id) throws Exception{
			JSONObject user=new JSONObject();
			user.element("phoneArea", "86");
			user.put("phoneNumber", "20000000000");
			//密码错误
			user.element("password", "123456789");
			String login_result = HttpDriver.doPost("/common/fgadmin/login",user);	
			JSONObject json = JSONObject.fromObject(login_result);
			json_result =json.getString("message");
			System.out.println(json_result);
				
			JSONObject Id = new JSONObject();
			Id.element("id", id);
			Id.element("login",json_result);
			String result=HttpDriver.doPost(delete_url, Id);
			System.out.println(result);
			checker = new Checker(result);
		} 	

		@Test(priority=5,description="登录失败状态下删除存在的指定id的地址")
		public void testDelete5() throws Exception {
			DeleteLoginFail("123456");
			checker.verifyXpath("code", "400");
		}
			
	//登录状态下
	public void Delete(Object id) throws Exception{
		JSONObject user=new JSONObject();
		user.element("phoneArea", "86");
		user.put("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String login_result = HttpDriver.doPost("/common/fgadmin/login",user);	
		JSONObject json = JSONObject.fromObject(login_result);
		json_result =json.getString("message");
		System.out.println(json_result);
		
		JSONObject Id = new JSONObject();
		Id.element("id", id);
		Id.element("login", json_result);
		String result=HttpDriver.doPost(delete_url, Id);
		System.out.println(result);
		checker = new Checker(result);
	} 
	
	@Test(priority=6,description="删除指定id的地址(存在的id)")
	public void testDelete6() throws Exception {
		Delete("123456");
		checker.verifyXpath("code", "200");
	}
	
	
	@Test(priority=7,description="删除错误不存在的id的地址")
	public void testDelete7() throws Exception {
		Delete("123789");
		checker.verifyXpath("code", "400");
	}
	
	@Test(priority=8,description="删除不指定id地址")
	public void testDelete8() throws Exception {
		Delete(" ");
		checker.verifyXpath("code", "400");
	}
	
	@Test(priority=9,description="删除格式错误的id的地址")
	public void testDelete9() throws Exception {
		Delete("{123456}");
		checker.verifyXpath("code", "400");
	}
	
}
