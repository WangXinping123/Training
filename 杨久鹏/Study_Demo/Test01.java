package com.webtest.freemarker_demo;

import java.io.FileWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Template;

public class Test01 {
  
	/**
	 * 直接创建文件
	 * @param args
	 */
	public static void main(String[] args){
	      try {
	            // 创建插值的map
	            Map<String,Object> map = new HashMap<String,Object>();
	            map.put("user", "rr");
	            map.put("url", "http://www.baidu.com/");
	            map.put("name", "百度");

	            // 创建一个模板对象
	            Template t = new Template(null, new StringReader(
	                    "用户名：${user};URL：    ${url};姓名： 　${name}"), null);

	            // 执行插值，并输出到指定的输出流中
	            Writer writer = new FileWriter("F:\\111\\222.html");
	            t.process(map, writer);
	            // t.process(map, new OutputStreamWriter(System.out));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    }
	   
	}