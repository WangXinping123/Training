package com.example.demo.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
@RequestMapping
public class AddAddress {
	public static Cookie cookie=null;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject doPostLoginByJSON(@RequestBody JSONObject json,HttpServletResponse response) {
		String phoneNumber = json.getString("phoneNumber");
		String password = json.getString("password");

		JSONObject result = new JSONObject();//返回的json

		if (phoneNumber.equals("20000000000") && password.equals("netease123")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			result.element("message", "success");
			result.element("code", "200");
			
		} else if(phoneNumber.equals("")){
			result.element("message", "用户名为空");
			result.element("code", "400");
		}
		return result;
	}
		
	
	@RequestMapping(value = "/fgadmin/address/new", method = RequestMethod.POST)
	public JSONObject addAfterLogin(HttpServletResponse response,@RequestBody ReceivingAddress address) {
		JSONObject result = new JSONObject();
		if(cookie==null) {
			result.element("code", 400);
			result.element("message", "未登录");
		} else{
			// 判断是不是参数都有
			if (address.getreceiverName() != null && address.getCellPhone() != null
					&& address.getAddressDetail() != null && address.getProvince() != null && address.getCity() != null
					&& address.getArea() != null) {
				if ((address.getreceiverName() instanceof String)
						&&(address.getCellPhone() instanceof String)
						&& (address.getCellPhone().toString().length() == 11)
						&& (address.getAddressDetail() instanceof String) 
						&&(address.getAddressDetail().toString().contains("大学"))
						&& (address.getProvince() instanceof String)
						&&(address.getProvince().toString().contains("省"))
						&& (address.getCity() instanceof String) 
						&&(address.getCity().toString().contains("市"))
						&& (address.getArea() instanceof String)
						&&(address.getArea().toString().contains("区"))){
					result.element("code", 200);
					result.element("message", "success");
					// return result;
				} else {

					// 判断是否是类型正确
					if (!(address.getreceiverName() instanceof String)) {
						result.element("code", 400);
						result.element("message", "receiverName参数类型不正确");
					}
					if (!(address.getCellPhone() instanceof String)) {
						result.element("code", 400);
						result.element("message", "cellPhone参数类型不正确");
					}
					if (address.getCellPhone().toString().length() != 11) {
						result.element("code", 400);
						result.element("message", "cellPhone参数类型不正确");
					}
					if (!(address.getAddressDetail() instanceof String)||
							!(address.getAddressDetail().toString().contains("大学"))) {
						result.element("code", 400);
						result.element("message", "addressDetail参数类型不正确");
					}
					if (!(address.getProvince().toString().contains("省"))) {
						result.element("code", 400);
						result.element("message", "province参数类型不正确");
					}
					if (!(address.getCity() instanceof String)||
							!(address.getCity().toString().contains("市"))) {
						result.element("code", 400);
						result.element("message", "city参数类型不正确");
					}
					if (!(address.getArea() instanceof String)||
							!(address.getArea().toString().contains("区"))) {
						result.element("code", 400);
						result.element("message", "area参数类型不正确");
					}
				}
			} else {
				if (address.getreceiverName() == null) {
					result.element("code", 400);
					result.element("message", "receiverName参数不存在");
				}
				if (address.getCellPhone() == null) {
					result.element("code", 400);
					result.element("message", "cellPhone参数不存在");
				}
				if (address.getAddressDetail() == null) {
					result.element("code", 400);
					result.element("message", "addressDetail参数不存在");
				}
				if (address.getProvince() == null) {
					result.element("code", 400);
					result.element("message", "province参数不存在");
				}
				if (address.getCity() == null) {
					result.element("code", 400);
					result.element("message", "city参数不存在");
				}
				if (address.getArea() == null) {
					result.element("code", 400);
					result.element("message", "area参数不存在");
				}
			}
		}
		return result;
	}
}
