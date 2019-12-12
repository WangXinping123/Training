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
	@RequestMapping(value="/fgadmin/address/list",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public JSONObject getByJSON(@RequestParam String jsonParam) {
		//String login=jsonParam.getString(("login"));
		JSONObject result=new JSONObject();
		if(jsonParam.equals("true")) {
			result.element("message","success");
			result.element("code","200");
		}
		else {
			result.element("message","fail");
			result.element("code","400");
		}
		return result;
	}
}
