package wxpBackgroundPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

public class ContentManage extends BaseTest {
	@Test(priority = 1, description = "后台登录")
	public void test_Page() {
		// 打开页面
		webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		// 文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("id=vertify", "1111");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isTextPresent("admin"));
	}

	@Test(priority = 5, description = "页面-内容管理-文章列表")
	public void test_Click01() throws Exception {
		webtest.click("link=页面");
		Thread.sleep(100);
		webtest.click("link=帮助分类");
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		Assert.assertTrue(getDriver().getPageSource().contains("文章分类"));
	}

	@DataProvider(name = "Article")
	public Object[][] getExcelData1() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "article.xlsx",
				"Sheet1");
	}

	@Test(priority = 10, dataProvider = "Article", description = "新增文章分类 正确")
	public void test_AddArticlePass(String name, String order, String keyword, String description, String type)
			throws Exception {
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();

		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(0).sendKeys(name);// 名称
		inputs.get(1).sendKeys(order);// 排序
		inputs.get(2).sendKeys(keyword);// 关键字
		inputs.get(3).sendKeys(description);// 描述
		webtest.tapClick();

		Select places = new Select(getDriver().findElement(By.id("parent_id")));
		places.selectByValue(type);
		webtest.click("id=submitBtn");
		Thread.sleep(100);
		Assert.assertTrue(getDriver().getPageSource().contains(name));
	}

	@DataProvider(name = "Article2")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "article.xlsx",
				"Sheet2");
	}


	@Test(priority = 12, dataProvider = "Article2", description = "新增文章分类 错误数据")
	public void test_AddArticleFail(String name, String order, String keyword, String description, String type,
			String result) throws Exception {
		if(getDriver().getPageSource().contains("新增分类")){
			List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
			fbuttons.get(0).click();
		}

		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(0).clear();
		inputs.get(0).sendKeys(name);// 名称
		inputs.get(1).clear();
		inputs.get(1).sendKeys(order);// 排序
		inputs.get(2).clear();
		inputs.get(2).sendKeys(keyword);// 关键字
		inputs.get(3).clear();
		inputs.get(3).sendKeys(description);// 描述
		webtest.tapClick();

		Select places = new Select(getDriver().findElement(By.id("parent_id")));
		places.selectByValue(type);
		webtest.click("id=submitBtn");
		Thread.sleep(100);
		Assert.assertTrue(webtest.isTextPresent(result));
	}

}
