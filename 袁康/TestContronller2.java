package com.example.demo;

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

	@RequestMapping("/hello")
	@ResponseBody
	public String test1() {
		return "hello,test";
	}
	  @RequestMapping(value="/get/with/param", method = RequestMethod.GET)
	    public Map<String, Object> getList(@RequestParam Integer id, @RequestParam String address,@RequestParam Integer login){
	        //商品列表返回的是一个Map， 有一个商品名称，有一个价格
	        //@RequestParam，此注解设置开始位置和结束位置
	        //真实项目中需要拿start和end到数据库中取值，此处模拟以下商品
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
