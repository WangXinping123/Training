package com.webtest.demo;

import org.testng.annotations.Test;

public class demo {

	@Test
	public void demo(){
		Admin_Login admin_Login = new Admin_Login();
		admin_Login.testLogin();
	}
}
