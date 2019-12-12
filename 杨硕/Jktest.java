package com.webtest.shouye;

import java.io.IOException;

import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class Jktest {
	int i=0;
	String submit_url = "/fgadmin/address/new";
	String json_result="false";
	Checker checker = null;
	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"excl.xlsx", "Sheet1");
	}
	@Test(description = "提交地址",priority=0)
	public void Tjaddress(String receiverName,String cellPhone,String addressDetail,String province,String city,String area) throws Exception{
		//登录
		JSONObject user=new JSONObject();
		user.element("phoneArea", "86");
		user.put("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String login_result = HttpDriver.doPost("/common/fgadmin/login",user);	
		JSONObject json = JSONObject.fromObject(login_result);
		json_result =json.getString("message");
		System.out.println(json_result);
		//添加地址
		JSONObject addaddress=new JSONObject();
		addaddress.element("receiverName", receiverName);
		addaddress.element("cellPhone", cellPhone);
		addaddress.element("addressDetail", addressDetail);
		addaddress.element("province", province);
		addaddress.element("city", city);
		addaddress.element("area", area);
		String submit = HttpDriver.doPost(addaddress);

	}
}
