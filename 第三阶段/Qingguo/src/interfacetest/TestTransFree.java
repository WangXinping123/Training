package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.ApiListener;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

/**
 * 项目名称：Qingguo   
 * 类名称：Demo1   
 * 类描述： 
 * @author yuankang
 * 创建时间：2019年12月11日 下午5:43:38   
 * @version  
 */
@Listeners(ApiListener.class)
public class TestTransFree {
	Checker checker= null;
	@Test
	//登录状态，正常查询
	public void test1() throws Exception {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","浙江省_杭州市_滨江区");
		fee_para.put("login", 1);
		String fee_result=HttpDriver.doGet("/get/with/param/", fee_para);
		System.out.println(fee_result);
		checker=new Checker(fee_result);
		checker.verifyXpath("code", "200");
	}
	@Test
	//非登录状态
	public void test2() throws Exception {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","浙江省_杭州市_滨江区");
		fee_para.put("login", 0);
		String fee_result=HttpDriver.doGet("/get/with/param/", fee_para);
		System.out.println(fee_result);
		checker=new Checker(fee_result);
		checker.verifyXpath("message", "未登录");
	}
	@Test
	//登录状态，查询不存在地址
	public void test3() throws Exception {
		Map<String, Object> fee_para=new HashMap<String, Object>();
		fee_para.put("id", "1");
		fee_para.put("address","123123");
		fee_para.put("login", 1);
		String fee_result=HttpDriver.doGet("/get/with/param/", fee_para);
		System.out.println(fee_result);
		checker=new Checker(fee_result);
		checker.verifyXpath("code","400");
	}

}
