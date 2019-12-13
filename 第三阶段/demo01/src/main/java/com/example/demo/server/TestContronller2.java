package com.example.demo.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContronller2 {

	  @RequestMapping(value="/get/with/param", method = RequestMethod.GET)
	    public Map<String, Object> getList(@RequestParam Integer id, @RequestParam String address,@RequestParam Integer login){

		  Map<String, Object> myList=new HashMap<>(); 
		   
		  if(login.equals(1)) {
			  if(id.equals(1)&&address.equals("浙江省_杭州市_滨江区")) {
		        //模拟商品
		        myList.put("message","success");
		        myList.put("result", 6);
		        myList.put("code", 200);
		        return myList;
			  }
			  else 
			  {	
				  myList.put("message","请求失败");
			  		myList.put("code",400);
			  		return myList;
			  }
		  
		  }
		  else
		  {
			  myList.put("message","未登录 ");
		  		myList.put("code",400);
			  return myList;
		  }
	    }

	
}
