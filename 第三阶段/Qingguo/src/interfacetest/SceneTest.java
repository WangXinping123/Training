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
 * 类名称：SceneTest
 * 类描述： 场景测试（5个场景）
 * @author 
 *  王欣平：场景1,2,5
 *  靳明明：场景4，
 *  李晓月：场景3
 */
public class SceneTest {
	String login_url = "/common/fgadmin/login";
	String address_url = "/fgadmin/address/list";
	String fee_url = "/get/with/param";
	String submit_url = "/common/fgadmin/submit";
	String delete_url = "/fgadmin/address/delete";
	String skulist_url = "/common/skuList";
	String addAddress_url = "/fgadmin/address/new";
	Checker checker = null;
	String address_url2 = "/fgadmin/address/listNo";

	@Test(description = "浏览商品列表并查看商品详情")
	public void testScene01() throws Exception {
		String result = HttpDriver.doGet(skulist_url);
		JSONObject json_res = JSONObject.fromObject(result);
		JSONObject good1 = json_res.getJSONObject("result").getJSONObject("1");
		String id1 = good1.getString("goodId");

		JSONObject good2 = json_res.getJSONObject("result").getJSONObject("2");
		String id2 = good1.getString("goodId");

		JSONObject good3 = json_res.getJSONObject("result").getJSONObject("3");
		String id3 = good1.getString("goodId");
		// 查看第一个商品
		String goodInfo1 = HttpDriver.doGet("/common/skuList", "goodsId=" + id1);
		// 查看第一个商品
		String goodInfo2 = HttpDriver.doGet("/common/skuList", "goodsId=" + id2);
		// 查看第一个商品
		String goodInfo3 = HttpDriver.doGet("/common/skuList", "goodsId=" + id3);
		System.out.println(goodInfo1);
		System.out.println(goodInfo2);
		System.out.println(goodInfo3);
		Checker checker1 = new Checker(goodInfo1);
		Checker checker2 = new Checker(goodInfo2);
		Checker checker3 = new Checker(goodInfo3);
		checker1.verifyXpath("code", "200");
		checker2.verifyXpath("code", "200");
		checker3.verifyXpath("code", "200");
	}

	@Test(description = "登录，查询地址，计算运费，提交订单")
	public void testScene02() throws Exception {
		// 1.登录post
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		// 2.获取地址get
		String address_result = HttpDriver.doGet(address_url, "login=true");
		System.out.println(address_result);
		JSONObject json_address = JSONObject.fromObject(address_result);
		String id = json_address.getString("id");
		String province = json_address.getString("province");
		String city = json_address.getString("city");
		String area = json_address.getString("area");
		String receiverName = json_address.getString("receiverName");
		String cellPhone = json_address.getString("cellPhone");
		String addressDetail = json_address.getString("addressDetail");

		// 3.获取运费 get
		Map<String, Object> fee_para = new HashMap<String, Object>();
		fee_para.put("id", id);
		fee_para.put("address", province + "_" + city + "_" + area);
		fee_para.put("login", 1);
		String fee_result = HttpDriver.doGet(fee_url, fee_para);
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
		submit_para.element("login", "success");

		String submit_result = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit_result);
	}

	@Test(description = "登录，查询地址，添加地址，计算运费，提交订单")
	public void testScene03() throws Exception {
		// 查询地址，并打印已有地址
		String result = HttpDriver.doGet(address_url2, "login=true");
		System.out.println(result);
		JSONObject json_address = JSONObject.fromObject(result);
		String value = json_address.getString("value");
		System.out.println(value);
		// //添加地址
		// 先登录
		JSONObject uu = new JSONObject();
		uu.element("phoneNumber", "20000000000");
		uu.element("password", "netease123");
		String login_result = HttpDriver.doPost("/fgadmin/loginmap", uu);
		System.out.println(login_result);

		JSONObject address = new JSONObject();
		address.element("province", "浙江省");
		address.element("city", "杭州市");
		address.element("area", "滨江区");
		address.element("receiverName", "张三");
		address.element("cellPhone", "12345678901");
		address.element("addressDetail", "浙江大学");
		String address_result = HttpDriver.doPost("/fgadmin/address/new", address);
		System.out.println(address_result);

		// 查询已添加地址
		String result2 = HttpDriver.doGet(address_url, "login=true");
		JSONObject json_address2 = JSONObject.fromObject(result2);
		String province2 = json_address2.getString("province");
		String city2 = json_address2.getString("city");
		String area2 = json_address2.getString("area");
		String receiverName2 = json_address2.getString("receiverName");
		String cellPhone2 = json_address2.getString("cellPhone");
		String addressDetail2 = json_address2.getString("addressDetail");
		System.out.println(json_address2);

		// 获取运费 get
		Map<String, Object> fee_para = new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address", "浙江省_杭州市_滨江区");
		fee_para.put("login", 1);
		String fee_result = HttpDriver.doGet(fee_url, fee_para);
		System.out.println(fee_result);

		// 提交订单
		JSONObject submit_para = new JSONObject();
		submit_para.element("skuIds", "2,3");
		submit_para.element("skuNumbers", "1,1");
		submit_para.element("stockIds", "74966312,74966313");
		submit_para.element("receiverName", receiverName2);
		submit_para.element("cellPhone", cellPhone2);
		submit_para.element("addressDetail", addressDetail2);
		submit_para.element("province", province2);
		submit_para.element("city", city2);
		submit_para.element("area", area2);
		submit_para.element("transportFee", 0);
		submit_para.element("voiceStatus", 0);
		submit_para.element("needInvoice", 0);
		submit_para.element("invoiceHead", "");
		submit_para.element("accessSource", "noSource");
		submit_para.element("logisticsCompanyId", 1);
		submit_para.element("accessDevice", 0);
		submit_para.element("login", "true");
		String submit = HttpDriver.doPost(submit_url, submit_para);
		System.out.println();
		checker = new Checker(result);
		checker.verifyXpath("code", "200");
	}

	@Test(description = "查询收货地址，计算运费，提交订单")
	public void testScene04() throws Exception {
		String address_url = "/fgadmin/address/list";
		String submit_url = "/common/fgadmin/submit";
		String json_result = "success";
		Checker checker = null;

		// 查询收货地址
		// JSONObject data=new JSONObject();
		String result = HttpDriver.doGet(address_url, "login=true");
		System.out.println(result);
		JSONObject list = JSONObject.fromObject(result);
		String id = list.getString("id");
		String receiverName = list.getString("receiverName");
		String cellPhone = list.getString("cellPhone");
		String addressDetail = list.getString("addressDetail");
		String province = list.getString("province");
		String city = list.getString("city");
		String area = list.getString("area");

		// 计算运费
		Map<String, Object> fee_para = new HashMap<String, Object>();
		fee_para.put("id", id);
		fee_para.put("address", "浙江省_杭州市_滨江区");
		fee_para.put("login", 1);
		String fee_result = HttpDriver.doGet("/get/with/param/", fee_para);
		System.out.println(fee_result);
		JSONObject fee = JSONObject.fromObject(fee_result);
		String transportFee = fee.getString("result");

		// 提交订单
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
		submit_para.element("login", json_result);
		String submit = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit);
		checker = new Checker(submit);
		checker.verifyXpath("message", "success");
	}

	@Test(description = "登录，查询，添加收货地址，计算运费，提交订单")
	public void testScene05() throws Exception {
		// 1.登录post
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(login_url, user);
		System.out.println(result);
		// 2.获取地址get
		String address_result = HttpDriver.doGet(address_url, "login=true");
		System.out.println(address_result);
		JSONObject json_address = JSONObject.fromObject(address_result);
		String id = json_address.getString("id");
		String province = json_address.getString("province");
		String city = json_address.getString("city");
		String area = json_address.getString("area");
		String receiverName = json_address.getString("receiverName");
		String cellPhone = json_address.getString("cellPhone");
		String addressDetail = json_address.getString("addressDetail");
		// 3.添加地址
		JSONObject user2 = new JSONObject();
		user2.element("phoneNumber", "20000000000");
		user2.element("password", "netease123");
		String loginr = HttpDriver.doPost("/login", user2);
		System.out.println(loginr);
		JSONObject address = new JSONObject();
		address.element("receiverName", receiverName);
		address.element("cellPhone", cellPhone);
		address.element("addressDetail", addressDetail);
		address.element("province", province);
		address.element("city", city);
		address.element("area", area);
		String addAddressResult = HttpDriver.doPost(addAddress_url, address);
		System.out.println(addAddressResult);

		// 4.获取运费 get
		Map<String, Object> fee_para = new HashMap<String, Object>();
		fee_para.put("id", id);
		fee_para.put("address", province + "_" + city + "_" + area);
		fee_para.put("login", 1);
		String fee_result = HttpDriver.doGet(fee_url, fee_para);
		System.out.println(fee_result);
		JSONObject json_fee = JSONObject.fromObject(fee_result);
		String transportFee = json_fee.getString("result");

		// 5.提交订单submit post
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
		submit_para.element("login", "success");

		String submit_result = HttpDriver.doPost(submit_url, submit_para);
		System.out.println(submit_result);
		checker = new Checker(submit_result);
		checker.verifyXpath("message", "success");
	}
}
