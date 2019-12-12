package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
@RestController
@RequestMapping
public class AddressList {
	@RequestMapping(value = "/fgadmin/address/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public JSONObject getAddressList(@RequestParam (required =false) String login) {
		JSONObject result = new JSONObject();//返回的json 
		if(login.equals("true")) {
			 result.element("message", "success");
			 result.element("province","浙江省");
			 result.element("city", "杭州市");
			 result.element("area", "滨江区");
			 result.element("receiverName", "张三");
			 result.element("cellPhone", "12345678901");
			 result.element("addressDetail", "浙江大学");
			 result.element("code", "200");
			 return result;
		 }else {
			 result.element("message", "请先登录");
			 result.element("code", "400");
			 return result;
		 }
	}
}
