package shouye.ys;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
  @Test (dataProvider="excel",description="搜索框功能测试")
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
 
  
  @Test (description="搜索框功能测试6")
  public void search8() throws InterruptedException {
		webtest.open("http://localhost:8036");
		Thread.sleep(200);
		webtest.type("id=q","    ");
		Thread.sleep(200);
		webtest.click("class=ecsc-search-button");
		assertTrue(webtest.isTextPresent("请输入搜索词"));
		
  }
 
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
  }
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
  }
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
