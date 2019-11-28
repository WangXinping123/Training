package com.webtest.demo;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.ApiListener;
import com.webtest.dataprovider.ExcelDataProvider;
@Listeners({ ApiListener.class})
public class Index extends Admin_Login{
	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("G:/testclass/data/goodsmage.xlsx", "Sheet1");
	}

	@Test
	public void goodsMage(){
		webtest.click("xpath=//a[contains(text(), '首页')]");
		//进入首页点击商品管理
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='commfunc-con']/a[1]/i");
		webtest.leaveFrame();
		//点击左侧的商品列表
		webtest.click("xpath=//a[@data-param='goodsList|Goods']");
		//进入商品管理的frame
		webtest.enterFrame("workspace");
		///点击添加商品
		webtest.click("xpath=//div[@title='添加商品']");
		//添加商品信息
		webtest.type("name=goods_name", "盲盒啊啊啊");
		webtest.selectByVisibleText("name=cat_id", "艺术");
		webtest.selectByVisibleText("name=cat_id_2", "精美礼品");
		webtest.selectByVisibleText("name=cat_id_3", "收藏品");
		webtest.type("name=goods_remark", "这是一个小物件");
		webtest.type("name=shop_price", "30");
		webtest.type("name=market_price", "50");
		webtest.click("xpath=//label[@id='is_free_shipping_label_1']");
		webtest.click("xpath=//a[@id='submit']");
		Assert.assertTrue(getDriver().getPageSource().contains("盲盒啊啊啊"));
		webtest.leaveFrame();
	}
	@Test
	public void userList(){
		webtest.click("xpath=//a[contains(text(), '首页')]");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='commfunc-con']/a[5]/i");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='index|User']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='添加会员']");
		webtest.type("name=nickname", "user001");
		webtest.type("name=password", "user001");
		webtest.type("name=mobile", "13933133167");
		webtest.type("name=email", "749822099@qq.com");
		webtest.click("xpath=//a[@id='submitBtn']");
		Assert.assertTrue(getDriver().getPageSource().contains("user001"));

		webtest.leaveFrame();
	}
	@Test
	public void active(){
		webtest.click("xpath=//a[contains(text(), '首页')]");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@class='markfunc-con']/a[1]/i");
		webtest.leaveFrame();
		webtest.click("xpath=//a[@data-param='flash_sale|Promotion']");
		webtest.enterFrame("workspace");
		webtest.click("xpath=//div[@title='添加活动']");
		webtest.click("xpath=//a[@id='select_goods_button']");
		webtest.enterFrame("layui-layer-iframe1");
		webtest.click("xpath=//div[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input");
		webtest.click("xpath=//a[contains(text(),'确认提交')]");
		webtest.leaveFrame();
		webtest.enterFrame("workspace");
		webtest.type("name=title", "促销活动");
		webtest.type("name=goods_name", "user001");
		webtest.type("name=price", "12");
		webtest.type("name=goods_num", "20");
		webtest.type("name=buy_limit", "2");
		webtest.type("name=start_time", "2019-11-30");
		webtest.selectByVisibleText("name=start_time_h", "6:00:00");
		
		webtest.click("xpath=//form[@id='handleposition']/div/div/a");
		Assert.assertTrue(getDriver().getPageSource().contains("促销活动"));

		webtest.leaveFrame();
	}
	
}
