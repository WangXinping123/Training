package jinmingming;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;
public class ChangYongCuXiao2 extends BaseTest{
	int i=0;
	@BeforeClass
	public void aaa(){
		Action action = new Action(webtest);
		action.login();
		//营销
		webtest.click("link=营销");
	}
	//14条
	@DataProvider(name="data")
	public Object[][] getDada() throws Exception{
		return new TxtDataProvider().getTxtUser("data//yingxiao//tuangou//shuju.txt");
	}
	@Test(dataProvider="data",priority=0,description = "团购")
	public void yingxiao(String title,String price,String goods_num,String virtual_num) throws InterruptedException{
		webtest.click("link=团购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//团购标题
		webtest.type("name=title", title);
		//选择团购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[4]/dd/p/a"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(200);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		Thread.sleep(200);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框
		//团购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参团数量
		webtest.type("name=goods_num",goods_num);
		//虚拟购买数
		webtest.type("name=virtual_num", virtual_num);
		//团购介绍
		//提交
		webtest.click("link=确认提交");
		i++;
		SoftAssert s =new SoftAssert();
		if(i==1 || i==7){
			s.assertTrue(webtest.isTextPresent("共17条记录"));
		}else if (i==11 || i==13) {
			s.assertTrue(webtest.isTextPresent("共17条记录"));
		}
		else{
			s.assertTrue(!(webtest.isTextPresent("共17条记录")));
		}
		if(webtest.isTextPresent("共17条记录")){
			webtest.click("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框 
		s.assertAll();
	}
	//时间
	@DataProvider(name="data2")
	public Object[][] getTxtDada() throws Exception{
		return new TxtDataProvider(). getTxtUser("data//yingxiao//tuangou//time.txt");
	}
	@Test(dataProvider="data2",priority=1,description = "团购的时间")
	public void eTime(String title,String start_time,String end_time,String price,String goods_num,String virtual_num) throws InterruptedException{
		webtest.click("link=团购管理");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//团购标题
		webtest.type("name=title", title);
		//开始时间
		webtest.typeAndClear("name=start_time", start_time);
		//结束时间
		webtest.typeAndClear("name=end_time", end_time);
		//选择团购商品
		Thread.sleep(200);
		WebElement d = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[4]/dd/p/a"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(200);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		Thread.sleep(200);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框
		//团购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参团数量
		webtest.type("name=goods_num",goods_num);
		//虚拟购买数
		webtest.type("name=virtual_num", virtual_num);
		//团购介绍
		//提交
		webtest.click("link=确认提交");
		Thread.sleep(2000);
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(!(webtest.isTextPresent("共17条记录")));
		if(webtest.isTextPresent("共17条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(2000);
		getDriver().switchTo().defaultContent();//出文本框 
		soft.assertAll();
	}
}
