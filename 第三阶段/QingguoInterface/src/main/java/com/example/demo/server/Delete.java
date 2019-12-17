package com.example.demo.server;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;


@RestController 
@RequestMapping
public class Delete {
	@RequestMapping(value = "/fgadmin/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject doDeleteByJSON(@RequestBody JSONObject json,HttpServletResponse response) {
		String id = json.getString("id");
		String login = json.getString("login");

		JSONObject result = new JSONObject();

		if (login.equals("success")) {
			result.element("value", "成功登录");
			if(id.equals("123456") ){
				result.element("value", "id存在删除成功");
    			result.element("message","success");
    			result.element("code","200");
    		}
			
			else if(id.trim().length()!=0){
				result.element("value", "id为空删除失败");
				result.element("message","fail");
				result.element("code","400");
			}
			else{
				result.element("value", "id不存在删除失败");
				result.element("message","fail");
				result.element("code","400");
			}
			
		} 
		else if(login.trim().length()!=0){
			result.element("value", "请登录");
			result.element("message","fail");
			result.element("code","400");
		}
		else{
			result.element("value", "请重新登录");
			result.element("message","fail");
			result.element("code","400");
		}
		return result;
	}
}

