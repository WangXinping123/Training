package com.webtest.shouye;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class NewTest  extends BaseTest{
	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel(
				ReadProperties.getPropertyValue("data_path")+"excl.xlsx", "Sheet1");
	}
  @Test (dataprovider="excel",description="搜索框功能测试")
  public void search1(String search,String  dy) throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q",search );
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(1000);
		assertTrue(webtest.isTextPresent(dy));
  }
  @Test (description="搜索框功能测试2")
  public void search2() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","小米 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		webtest.type("id=q","华为 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		webtest.type("id=q","vivo ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		
		assertTrue(webtest.isTextPresent("vivo"));
  }
 
  /*  @Test (description="搜索框功能测试3")
  public void search5() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","aaaa手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试4")
  public void search6() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机aaaaaa");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试5")
  public void search7() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","aaaaa手机aaaaaa");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }*/
  @Test (description="搜索框功能测试6")
  public void search8() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","    ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("请输入搜索词"));
		
  }
 /* @Test (description="搜索框功能测试7")
  public void search9() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("字符长度过长"));
  }
  @Test (description="搜索框功能测试8")
  public void search10() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("字符长度过长"));
  }
  @Test (description="搜索框功能测试9")
  public void search11() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机眼镜");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));
		
  }
  @Test (description="搜索框功能测试10")
  public void search12() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","眼镜手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));
  }
  @Test (description="搜索框功能测试42")
  public void search13() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","小");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("小"));
  }
  @Test (description="搜索框功能测试11")
  public void search14() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","华");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("华"));
  }*/
  @Test (description="搜索框功能测试12")
  public void search15() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","      手机             ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试13")
  public void search16() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","      手机 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试14")
  public void search17() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机                                ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
 /* @Test (description="搜索框功能测试15")
  public void search18() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","，，，，，，，，，，手机 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试16")
  public void search19() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机，，。、、");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试17")
  public void search20() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","。。，、++手机、、、、，。");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }*/
  @Test (description="搜索框功能测试18")
  public void search21() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","shouji");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.type("id=q","huawei");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.type("id=q","xiaomi");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("xiaomi"));
  }
  /*@Test (description="搜索框功能测试19")
  public void search22() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","111111手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试20")
  public void search23() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机111111223131");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试21")
  public void search24() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","12315556+899手机111111223131");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试22")
  public void search25() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","12315556+899手123156机111111223131");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试23")
  public void search26() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机 shouji");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试24")
  public void search27() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","1111手机。，。，。，。，，。。");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }*/
  @Test (description="搜索框功能测试25")
  public void search28() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","、、、、、    手机         。，。，。，。，，。。");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }
  @Test (description="搜索框功能测试26")
  public void search29() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("手机"));
  }/*
  @Test (description="搜索框功能测试27")
  public void search30() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机2000元左右");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));

  }
  @Test (description="搜索框功能测试28")
  public void search31() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","冰箱2000元左右");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));

  }*/
  @Test (description="搜索框功能测试29")
  public void search32() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));

  }
  @Test (description="敏感词屏蔽")
  public void search3() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","香烟 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		webtest.type("id=q","管制刀具 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		webtest.type("id=q","枪支 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }/*
  @Test (description="敏感词屏蔽2")
  public void search4() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","毒         品 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }
  @Test (description="敏感词屏蔽3")
  public void search33() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","高仿球鞋");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }
  @Test (description="敏感词屏蔽4")
  public void search34() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","木马病毒");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }
  @Test (description="敏感词屏蔽5")
  public void search35() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","外挂 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }
  @Test (description="敏感词屏蔽6")
  public void search36() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","爱奇艺土豆优酷账号 ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Assert.assertTrue(getDriver().getPageSource().contains("根据法律要求无法显示"));
  }
  @Test (description="搜索框功能测试42")
  public void search37() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","adc");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("-- 抱歉没找到您要搜索的商品，换个条件试试！--"));

  }*/
  @Test (description="搜索框功能测试29")
  public void search38() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("请输入搜索词"));

  }
  @Test (description="搜索框功能测试30")
  public void search39() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.click("xpath=//a[contains(text(),'1198元以下')]");
		assertTrue(webtest.isTextPresent("价格:0-1198"));

  }
  @Test (description="搜索框功能测试41")
  public void search40() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","手机");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		Thread.sleep(200);
		webtest.click("class=ecsc-logo");
		assertTrue(webtest.isTextPresent("热门推荐"));

  }
}
