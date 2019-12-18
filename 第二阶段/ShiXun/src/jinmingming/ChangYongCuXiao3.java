package jinmingming;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.webtest.jinmingming.Action;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;
/**
 * 项目名称：TPSHOP 类名称：ChangYongCuXiao3 类描述： 后台营销优惠促销添加活动
 * 
 * @author 靳明明      
 * @version
 */
public class ChangYongCuXiao3 extends BaseTest{
	int i=0;
	int j=0;
	int l=0;
	@BeforeClass
	public void aaa(){
		Action action=new Action(webtest);
		action.login();
		//营销
		webtest.click("link=营销");
	}
	@DataProvider(name="data1")
	public Object[][] getExcelDada() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/youhiucuxiao/shuju1.txt");
	}
	@Test(dataProvider="data1",priority=0,description = "优惠促销")
	public void yingxiao(String name,String type,String num) throws Exception{
		webtest.click("link=优惠促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//促销活动名称
		webtest.type("name=title", name);
		//促销活动类型
		webtest.click("name=直接打折");
		//折扣
		webtest.type("name=expression", type);
		//限购数量
		webtest.type("name=buy_limit", num);
		//选择优惠商品
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);	
		Thread.sleep(2000);
		
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		Thread.sleep(200);
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//进文本框
		getDriver().switchTo().frame("workspace");
		//宣传图片
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe2");//进文本框
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/img"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("xpath=/html/body/div/div/div[2]/ul/li[1]");
		getDriver().switchTo().defaultContent();//出文本框
		
		//确认提交
		getDriver().switchTo().frame("workspace");
		webtest.click("link=确认提交");
		Thread.sleep(200);
		i++;
		SoftAssert soft =new SoftAssert();
		if(i==1 || i==5){
			soft.assertTrue(webtest.isTextPresent("共15条记录"));
		}else{
			soft.assertTrue(!(webtest.isTextPresent("共15条记录")));
		}
		if(webtest.isTextPresent("共15条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框
		soft.assertAll();
	}
	
	@DataProvider(name="data2")
	public Object[][] getDada() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/youhiucuxiao/shuju2.txt");
	}
	@Test(dataProvider="data2",priority=1,description = "优惠促销")
	public void yingxiao1(String name,String type,String num) throws Exception{
		webtest.click("link=优惠促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//促销活动名称
		webtest.type("name=title",name);
		//促销活动类型
		webtest.click("name=减价优惠");
		//减价金额
		webtest.type("name=expression", type);
		//限购数量
		webtest.type("name=buy_limit", num);	
		//选择优惠商品
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);	
		Thread.sleep(200);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		Thread.sleep(200);
		getDriver().switchTo().defaultContent();//出文本框
		//进文本框
		getDriver().switchTo().frame("workspace");
		//宣传图片
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe2");//进文本框
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/img"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("xpath=/html/body/div/div/div[2]/ul/li[1]");
		getDriver().switchTo().defaultContent();//出文本框
		
		//确认提交
		getDriver().switchTo().frame("workspace");
		webtest.click("link=确认提交");
		Thread.sleep(200);
		j++;
		SoftAssert soft =new SoftAssert();
		if(j==1){
			soft.assertTrue(webtest.isTextPresent("共15条记录"));
		}else{
			soft.assertTrue(!(webtest.isTextPresent("共15条记录")));
		}
		if(webtest.isTextPresent("共15条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(2000);
		getDriver().switchTo().defaultContent();
		soft.assertAll();
	}
	
	@DataProvider(name="data3")
	public Object[][] getDada1() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/youhiucuxiao/shuju3.txt");
	}
	@Test(dataProvider="data3",priority=2,description = "优惠促销")
	public void yingxiao2(String name,String type,String num) throws Exception{
		webtest.click("link=优惠促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//促销活动名称
		webtest.type("name=title", name);
		//促销活动类型
		webtest.click("name=固定金额出售");
		//折扣
		webtest.type("name=expression", type);
		//限购数量
		webtest.type("name=buy_limit", num);	
		//选择优惠商品
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);	
		Thread.sleep(200);
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		Thread.sleep(200);
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//商品描述
		
		getDriver().switchTo().frame("workspace");
		//宣传图片
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe2");//进文本框
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/img"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("xpath=/html/body/div/div/div[2]/ul/li[1]");
		getDriver().switchTo().defaultContent();//出文本框
		
		//确认提交
		getDriver().switchTo().frame("workspace");
		webtest.click("link=确认提交");
		Thread.sleep(200);
		l++;
		SoftAssert soft =new SoftAssert();
		if(l==1){
			soft.assertTrue(webtest.isTextPresent("共15条记录"));
		}else{
			soft.assertTrue(!(webtest.isTextPresent("共15条记录")));
		}
		if(webtest.isTextPresent("共15条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(2000);
		getDriver().switchTo().defaultContent();//出文本框
		soft.assertAll();
	}
	//时间
	@DataProvider(name="data4")
	public Object[][] getDada4() throws IOException{
		return new TxtDataProvider().getTxtUser("data/yingxiao/youhiucuxiao/time.txt");
	}
	@Test(dataProvider="data4",priority=3,description = "优惠促销的时间")
	public void yingxiao(String name,String type,String num,String start_time,String end_time) throws Exception{
		webtest.click("link=优惠促销");
		//用属性来
		getDriver().switchTo().frame("workspace");//进文本框
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//数据
		//促销活动名称
		webtest.type("name=title", name);
		//促销活动类型
		webtest.click("name=直接打折");
		//折扣
		webtest.type("name=expression", type);
		//限购数量
		webtest.type("name=buy_limit", num);
		//开始时间
		webtest.typeAndClear("name=start_time", start_time);
		//结束时间
		webtest.typeAndClear("name=end_time", end_time);		
		//选择优惠商品
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);	
		Thread.sleep(200);
		
		getDriver().switchTo().frame("layui-layer-iframe1");//进文本框
		Thread.sleep(200);
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		Thread.sleep(200);
		webtest.click("link=确认提交");
		getDriver().switchTo().defaultContent();//出文本框
		//商品描述
		
		getDriver().switchTo().frame("workspace");
		//宣传图片
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe2");//进文本框
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		Thread.sleep(2000);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/img"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("xpath=/html/body/div/div/div[2]/ul/li[1]");
		getDriver().switchTo().defaultContent();//出文本框
		
		//确认提交
		getDriver().switchTo().frame("workspace");
		webtest.click("link=确认提交");
		Thread.sleep(2000);
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(!(webtest.isTextPresent("共15条记录")));
		if(webtest.isTextPresent("共15条记录")){
			webtest.click("xpath=//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/i");
			webtest.click("link=删除");
			webtest.click("link=确定");
		}
		Thread.sleep(2000);
		getDriver().switchTo().defaultContent();//出文本框
		soft.assertAll();
	}
}
