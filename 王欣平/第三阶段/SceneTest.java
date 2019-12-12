package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

/**
 * 项目名称：Qingguo   
 * 类名称：SceneTest01   
 * 类描述： 场景测试
 * @author 
 * 创建时间：2019年12月11日 下午5:44:13   
 * @version  
 */
public class SceneTest {
	String login_url = "/common/fgadmin/login";
	String address_url = "/fgadmin/address/list";
	String fee_url = "/get/with/param";
	String submit_url = "/fgadmin/orders/submit";
	String delete_url = "/fgadmin/address/delete";

	@Test(description="登录，查询地址，计算运费，提交订单")
	public void testScene01() throws Exception {
		// 1.登录post
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		// 2.获取地址get
		String address_result = HttpDriver.doGet(address_url,"login=true");
		System.out.println(address_result);
		JSONObject json_address = JSONObject.fromObject(address_result);
		String id=json_address.getString("id");
		String province = json_address.getString("province");
		String city = json_address.getString("city");
		String area = json_address.getString("area");
		String receiverName = json_address.getString("receiverName");
		String cellPhone = json_address.getString("cellPhone");
		String addressDetail = json_address.getString("addressDetail");

		// 3.获取运费 get
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address",province + "_" + city + "_" + area);
		fee_para.put("login", 1);
		String fee_result=HttpDriver.doGet(fee_url, fee_para);
		System.out.println(fee_result);
		JSONObject json_fee = JSONObject.fromObject(fee_result);
		String transportFee = json_fee.getString("result");

		// 4.提交订单submit post
		JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "2,3");
		submit_para.element("skuNumbers", "1,1");
		submit_para.element("stockIds", "74966312,74966313");
		submit_para.element("receiverName", receiverName);
		submit_para.element("cellPhone", cellPhone);
		submit_para.element("addressDetail", addressDetail);
		submit_para.element("province", province);
		submit_para.element("city", city);
		submit_para.element("area", area);
		submit_para.element("transportFee", transportFee);
		submit_para.element("voiceStatus", 0);
		submit_para.element("needInvoice", 0);
		submit_para.element("invoiceHead", "");
		submit_para.element("accessSource", "noSource");
		submit_para.element("logisticsCompanyId", 1);
		submit_para.element("accessDevice", 0);
		submit_para.element("login","success");
		
		String submit_result = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit_result);
	}
	
	@Test(description="浏览商品并查看商品详情")
	public void testScene02(){
		
	}
	
	
}
