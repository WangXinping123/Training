package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.dataprovider.TxtDataProvider;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

public class Sumbit {
	int i=0;
	String submit_url = "/common/fgadmin/submit";
	String json_result="false";
	Checker checker = null;
	@DataProvider(name="data1")
	public Object[][] Dada() throws Exception{
		return new TxtDataProvider().getTxtUser("data/data.txt");
	}
	//未登录
	@Test(description = "未登录",priority=0)
	public void NullLogin() throws Exception{
		//提交
		JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "2,3");
		submit_para.element("skuNumbers", "1,1");
		submit_para.element("stockIds", "74966312,74966313");
		submit_para.element("receiverName", "张三");
		submit_para.element("cellPhone", "17073108818");
		submit_para.element("addressDetail", "网商路 599 号");
		submit_para.element("province", "浙江省");
		submit_para.element("city", "杭州市");
		submit_para.element("area", "滨江区");
		submit_para.element("transportFee", 0);
		submit_para.element("voiceStatus", 0);
		submit_para.element("needInvoice", 0);
		submit_para.element("invoiceHead", "");
		submit_para.element("accessSource", "noSource");
		submit_para.element("logisticsCompanyId", 1);
		submit_para.element("accessDevice", 0);
		submit_para.element("login",json_result);
		String submit = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit);
		checker = new Checker(submit);
		checker.verifyXpath("message", "请先登录！");
	}
	//登录失败
	@Test(description = "登录失败",priority=1)
	public void LoginFalse() throws Exception{
		//登录
		JSONObject user=new JSONObject();
		user.element("phoneArea", "86");
		user.put("phoneNumber", "20000000");
		user.element("password", "netease123");
		String login_result = HttpDriver.doPost("/common/fgadmin/login",user);	
		JSONObject json = JSONObject.fromObject(login_result);
		json_result =json.getString("message");
		System.out.println(json_result);
		//提交
		JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "2,3");
		submit_para.element("skuNumbers", "1,1");
		submit_para.element("stockIds", "74966312,74966313");
		submit_para.element("receiverName", "张三");
		submit_para.element("cellPhone", "17073108818");
		submit_para.element("addressDetail", "网商路 599 号");
		submit_para.element("province", "浙江省");
		submit_para.element("city", "杭州市");
		submit_para.element("area", "滨江区");
		submit_para.element("transportFee", 0);
		submit_para.element("voiceStatus", 0);
		submit_para.element("needInvoice", 0);
		submit_para.element("invoiceHead", "");
		submit_para.element("accessSource", "noSource");
		submit_para.element("logisticsCompanyId", 1);
		submit_para.element("accessDevice", 0);
		submit_para.element("login",json_result);
		String submit = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit);
		checker = new Checker(submit);
		checker.verifyXpath("message", "请先登录！");
	}
	//登录成功
	@Test(dataProvider="data1",description = "登录成功",priority=2)
	public void submitTest(String name,String cellphone,String address,String province,String city,String area) throws Exception{
		//登录
		JSONObject user=new JSONObject();
		user.element("phoneArea", "86");
		user.put("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String login_result = HttpDriver.doPost("/common/fgadmin/login",user);	
		JSONObject json = JSONObject.fromObject(login_result);
		json_result =json.getString("message");
		System.out.println(json_result);
		
		//提交
		JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "2,3");
		submit_para.element("skuNumbers", "1,1");
		submit_para.element("stockIds", "74966312,74966313");
		submit_para.element("receiverName", name);
		submit_para.element("cellPhone", cellphone);
		submit_para.element("addressDetail", address);
		submit_para.element("province", province);
		submit_para.element("city", city);
		submit_para.element("area", area);
		submit_para.element("transportFee", 0);
		submit_para.element("voiceStatus", 0);
		submit_para.element("needInvoice", 0);
		submit_para.element("invoiceHead", "");
		submit_para.element("accessSource", "noSource");
		submit_para.element("logisticsCompanyId", 1);
		submit_para.element("accessDevice", 0);
		submit_para.element("login",json_result);
		i++;
		String submit = HttpDriver.doPost(submit_url, submit_para);
		System.out.println("第"+i+"个"+submit);
		checker = new Checker(submit);
		if(i==1){
			checker.verifyXpath("message", "success");
		}
		else{
			checker.verifyXpath("message", "fail");
		}
	}
}
