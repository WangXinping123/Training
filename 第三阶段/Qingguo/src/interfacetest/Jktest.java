package interfacetest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.ExcelDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;


/**
 * 项目名称：Qingguo   
 * 类名称：Jktest   
 * 类描述： 添加地址
 * @author 杨硕   
 */
public class Jktest {
	int i=0;
	String submit_url = "/fgadmin/address/new";
	String json_result="false";
	Checker checker = null;
	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadPro.getPropValue("data_path")+"excl2.xlsx", "Sheet1");
	}
	
	@Test(dataProvider="excel",description = "新增地址",priority=0)
	public void Tjaddress(String receiverName,String cellPhone,String addressDetail,
			String province,String city,String area,String dy) throws Exception{		
		JSONObject user=new JSONObject();
		user.element("phoneArea", "86");
		user.put("phoneNumber", "20000000000");
		user.element("password", "netease123");
		String login_result = HttpDriver.doPost("/login",user);	
		JSONObject json = JSONObject.fromObject(login_result);
		json_result =json.getString("message");
		System.out.println(json_result);
		
		JSONObject addaddress=new JSONObject();
		addaddress.element("receiverName", receiverName);
		addaddress.element("cellPhone", cellPhone);
		addaddress.element("addressDetail", addressDetail);
		addaddress.element("province", province);
		addaddress.element("city", city);
		addaddress.element("area", area);
		String submit = HttpDriver.doPost(submit_url, addaddress);
		System.out.println(submit);
		checker = new Checker(submit);
		checker.verifyXpath("message", dy);

	}
}
