package QingGuo;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

public class addressList {
	String address_url="/fgadmin/address/list";
	String url="http://localhost:8888/fgadmin/address/list";
	Checker checker=null;
	@Test(priority=1)
	public void addressList() throws Exception{
		JSONObject data=new JSONObject();
		//data.element("login", 1);
		//CookieStore cookie=Common.getCookie("200000000065", "netease123");
		String result=HttpDriver.doGet(address_url,"login=true");
		System.out.println(result);
		checker=new Checker(result);
		checker.verifyXpath("message","success");
	}
	
	@Test(priority=2)
	public void wrongAddressList() throws Exception{
		String result=HttpDriver.doGet(address_url);
		System.out.println(result);
		checker=new Checker(result);
		checker.verifyXpath("message", "fail");
	}
}
