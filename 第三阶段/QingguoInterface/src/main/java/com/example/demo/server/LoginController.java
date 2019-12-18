package com.example.demo.server;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/**
 * @author 王欣平  登录
 *
 */
@RestController
@RequestMapping
public class LoginController {
	@RequestMapping(value = "/common/fgadmin/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject doPostLoginByJSON(@RequestBody JSONObject json,HttpServletResponse response) {
		String phoneArea = json.getString("phoneArea");
		String phoneNumber = json.getString("phoneNumber");
		String password = json.getString("password");

		JSONObject result = new JSONObject();//返回的json

		if (phoneArea.equals("86") && phoneNumber.equals("20000000000") 
				&& password.equals("netease123")) {
			Cookie cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			result.element("message", "success");
			result.element("code", "200");
			
		} else if(phoneNumber.equals("")){
			result.element("message", "用户名为空");
			result.element("code", "400");
		}
		else{
			result.element("message", "用户名或者密码错误");
			result.element("code", "400");
		}
		return result;
	}
	
}
