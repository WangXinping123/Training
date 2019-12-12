package com.example.demo.addAddress;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/fgadmin")
public class AddAddress {
	public static Cookie cookie;
	@ResponseBody
	@RequestMapping(value = "/loginmap", method = RequestMethod.POST)
	public String doPostLogin(HttpServletResponse response,
			@RequestParam(value = "u_Name", required = true) String userName,
			@RequestParam(value = "u_Pwd", required = true) String userPwd) {
		if (userName.equals("admin") && userPwd.equals("admin")) {
			cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "登录成功";
		}
		return "登录失败";
	}
	@ResponseBody
	@RequestMapping(value = "/address/new", method = RequestMethod.POST)
	public JSONObject addAfterLogin(@RequestBody ReceivingAddress address) {
		JSONObject result = new JSONObject();
		if (cookie == null) {
			result.element("code", 400);
			result.element("message", "未登录");
		} else {
			// 判断是不是参数都有
			if (address.getreceiverName() != null && address.getCellPhone() != null
					&& address.getAddressDetail() != null && address.getProvince() != null && address.getCity() != null
					&& address.getArea() != null) {
				if ((address.getreceiverName() instanceof String) &&(address.getCellPhone() instanceof String)&&(address.getCellPhone().toString().length() == 11) &&
						(address.getAddressDetail() instanceof String) &&(address.getProvince() instanceof String)&& (address.getCity() instanceof String)&&(address.getArea() instanceof String)) {
					result.element("code", 200);
					result.element("message", "success");
					//return result;
				}else {

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
					if (!(address.getAddressDetail() instanceof String)) {
						result.element("code", 400);
						result.element("message", "addressDetail参数类型不正确");
					}
					if (!(address.getProvince() instanceof String)) {
						result.element("code", 400);
						result.element("message", "province参数类型不正确");
					}
					if (!(address.getCity() instanceof String)) {
						result.element("code", 400);
						result.element("message", "city参数类型不正确");
					}
					if (!(address.getArea() instanceof String)) {
						result.element("code", 400);
						result.element("message","area参数类型不正确");
					}
				}
			}else {
				if (address.getreceiverName() == null ) {
					result.element("code", 400);
					result.element("message", "receiverName参数不存在");
				}
				if (address.getCellPhone() == null){ 
					result.element("code", 400);
					result.element("message", "cellPhone参数不存在");
				}
				if (address.getAddressDetail() == null) {
					result.element("code", 400);
					result.element("message","addressDetail参数不存在");
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
