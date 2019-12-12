package jinmingming;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;

public class ChangYongCuXiao1 extends BaseTest{
	int i=0;
	@BeforeClass
	public void aaa(){
		Action action = new Action(webtest);
		action.login();
		//营销
		webtest.click("link=营销");
	}
	@DataProvider(name="data1")
	public Object[][] Dada() throws Exception{
		return new TxtDataProvider().getTxtUser("data/yingxiao/changyongcuxiao1/shuju1.txt");
	}
	//正确
	@Test(dataProvider="data1",priority=0,description = "抢购") 
	public void yingxiao1(String title,String price,String goods_num,String buy_limit) throws InterruptedException{
		Thread.sleep(2000);
		webtest.click("link=抢购管理");
		//用属性来
		webtest.enterFrame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		//数据
		//抢购标题
		Thread.sleep(2000);
		webtest.type("name=title", title);
		//选择抢购商品
		Thread.sleep(300);
		WebElement d = getDriver().findElement(By.xpath("//*[@id='select_goods_button']"));
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
		Thread.sleep(200);
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参加抢购数量
		webtest.type("name=goods_num",goods_num);
		//限购数量
		webtest.type("name=buy_limit", buy_limit);
		//提交
		webtest.click("link=确认提交");
		i++;
		SoftAssert s =new SoftAssert();
		if(i==1){
			s.assertTrue(webtest.isTextPresent("共55条记录"));
		}else if (i==7 || i==11) {
			s.assertTrue(webtest.isTextPresent("共55条记录"));
		}
		else{
			s.assertTrue(!(webtest.isTextPresent("共55条记录")));
		}
		if(webtest.isTextPresent("共55条记录")){
			webtest.click("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(200);
		webtest.leaveFrame();//出文本框 
		s.assertAll();
	}
	//时间
	@DataProvider(name="data2")
	public Object[][] getExcelDada() throws Exception{
		return new TxtDataProvider().getTxtUser("data//yingxiao//changyongcuxiao1//starttime//starttime.txt");
	}
	//正确
	@Test(dataProvider="data2",priority=1,description = "抢购的开始时间") 
	public void yingxiao1(String title,String price,String goods_num,String buy_limit,String start_time) throws InterruptedException{
		webtest.click("link=抢购管理");
		//用属性来
		webtest.enterFrame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//抢购标题
		webtest.type("name=title", title);
		//选择抢购商品
		WebElement d = getDriver().findElement(By.xpath("//*[@id='select_goods_button']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement f = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//限时抢购价格
		getDriver().switchTo().frame("workspace");//进文本框
		webtest.type("name=price",price);
		//参加抢购数量
		webtest.type("name=goods_num",goods_num);
		//限购数量
		webtest.type("name=buy_limit", buy_limit);
		//开始时间
		webtest.click("name=start_time");
		WebElement k = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", k);
		webtest.typeAndClear("name=start_time",start_time);
		//抢购介绍
		//提交
		webtest.click("link=确认提交");	
		Thread.sleep(2000);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(!(webtest.isTextPresent("共55条记录")));
		if(webtest.isTextPresent("共55条记录")){
			webtest.click("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(2000);
		webtest.leaveFrame();//出文本框
		soft.assertAll();
	}
}
