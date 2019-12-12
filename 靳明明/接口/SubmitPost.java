package com.example.demo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class SubmitPost {
	@RestController
	public class postQingguo {
		@ResponseBody
		@RequestMapping(value = "/common/fgadmin/submit", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
		public JSONObject doPostSubmit(@RequestBody JSONObject json,HttpServletResponse response) {
			//打印json信息
			System.out.println(json.toString());
	
			String skuIds = json.getString("skuIds");
			String skuNumbers = json.getString("skuNumbers");
			String stockIds = json.getString("stockIds");
			String receiverName = json.getString("receiverName");
			String cellPhone = json.getString("cellPhone");
			String addressDetail = json.getString("addressDetail");
			String province = json.getString("province");
			String city = json.getString("city");
			String area = json.getString("area");
			String voiceStatus = json.getString("voiceStatus");
			String needInvoice = json.getString("needInvoice");
			String invoiceHead = json.getString("invoiceHead");
			String transportFee = json.getString("transportFee");
			String logisticsCompanyId = json.getString("logisticsCompanyId");
			String accessSource = json.getString("accessSource");
			String accessDevice = json.getString("accessDevice");
			String login = json.getString("login");
			JSONObject resultsumbit = new JSONObject();
			if(login.equals("success")) {
				if (receiverName.trim().length()!=0 && cellPhone.length()==11 
						&& addressDetail.trim().length()!=0 && province.trim().length()!=0 
						&& city.trim().length()!=0 && area.trim().length()!=0
						&& skuIds.equals("2,3") && skuNumbers.equals("1,1") 
						&& stockIds.equals("74966312,74966313") && transportFee.length()!=0 
						&& voiceStatus.equals("0") && needInvoice.equals("0") 
						&& logisticsCompanyId.equals("1") && invoiceHead.equals("")
						&&accessSource.equals("noSource") && accessDevice.equals("0")){
					Cookie cookie1 = new Cookie("submit","strue");
					response.addCookie(cookie1);
					resultsumbit.element("message","success");
					resultsumbit.element("receiverName ", receiverName );
					resultsumbit.element("cellPhone",cellPhone);
					resultsumbit.element("addressDetail", addressDetail);
					resultsumbit.element("province", province);
					resultsumbit.element("city", city);
					resultsumbit.element("area",area );
					resultsumbit.element("code", 200);
				}
				else {
					resultsumbit.element("message","fail");
					resultsumbit.element("code", 400);
				}
			}else {
				resultsumbit.element("message", "请先登录！");
				resultsumbit.element("code", 400);
			}
			return resultsumbit;
		}
		
	}
	
}
