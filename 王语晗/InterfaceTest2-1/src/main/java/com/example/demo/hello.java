package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

public class hello {
	@RequestMapping("hello")
	public String test1() {
		return "hello ,test李焕贞";
	}

}
