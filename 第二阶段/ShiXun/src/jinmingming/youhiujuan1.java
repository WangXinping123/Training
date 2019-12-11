package jinmingming;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;

public class youhiujuan1 extends BaseTest{
	
	@Test
	public void youhiujuan() throws Exception{
		Action action=new Action(webtest);
		action.login();
		//营销
		webtest.click("link=营销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement a = getDriver().findElement(By.xpath("/html/body/div/div[3]/div/ul/a[1]/li"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", a);
		Thread.sleep(2000);
		//添加优惠劵
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div"));
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		webtest.tapDown();
		webtest.tapDown();
		//数据
		//优惠劵名称
		webtest.type("name=name","优惠劵1");
		webtest.click("xpath=/html/body/div[4]/div/div/div/h3");
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		webtest.tapDown();
		//优惠劵面额
		webtest.type("name=money", "100");
		//消费金额
		webtest.type("name=condition","200");
		//发放数量
		webtest.type("name=createnum", "10");
		//发放类型
		webtest.click("xpath=//*[@id='handleposition']/div/dl[5]/dd/label[2]");
		//时间
		//发放起始时间
		webtest.typeAndClear("name=send_start_time","2019-11-27 22:00:00");
		//发放结束时间
		webtest.typeAndClear("name=send_end_time","2019-11-28 22:00:00");
		webtest.typeAndClear("name=use_start_time", "2019-11-29 10:00:00");//使用起始日期
		webtest.typeAndClear("name=use_end_time", "2019-11-29 12:00:00");//使用结束时间
		webtest.click("link=确认提交");
		Thread.sleep(2000);
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("共38条记录"));
		soft.assertAll();
		if(webtest.isTextPresent("共38条记录")){
			webtest.click("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(5000);
		webtest.open("http://localhost:8036/index.php/admin/Admin/logout");//退出
		soft.assertAll();
	}
}
