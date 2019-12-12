package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class hello {
	@RequestMapping("hello")
	public String test1() {
		return "hello ,test李焕贞";
	}

}
