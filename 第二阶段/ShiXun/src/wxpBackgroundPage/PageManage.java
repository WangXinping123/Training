package wxpBackgroundPage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

/**
 * 项目名称：TPSHOP 类名称：PageManage 类描述： 页面管理的相关操作
 * 
 * @author wangxinping 创建时间：2019年12月4日 下午2:48:00
 * @version
 */
public class PageManage extends BaseTest {

	@Test(priority = 1, description = "后台登录")
	public void test_Page() {
		// 打开页面
		webtest.open("http://localhost:8036/index.php/Admin/Admin/login");
		// 文本框输入
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("id=vertify", "1111");
		webtest.click("xpath=//input[@type='button']");
		AssertJUnit.assertTrue(webtest.isTextPresent("admin"));
	}

	@Test(priority = 5, description = "页面-页面管理-模板分类管理")
	public void test_Click01() throws Exception {
		webtest.click("link=页面");
		Thread.sleep(100);
		webtest.click("link=模板分类管理");
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("行业及风格分类"));
	}

	@DataProvider(name = "industry")
	public Object[][] getExcelData1() throws Exception {
		return new ExcelDataProvider()
				.getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "industry.xlsx", "Sheet1");
	}

	@Test(priority = 12, dataProvider = "industry", description = "新增行业")
	public void test_AddIndustry(String name, String order, String type) throws Exception {
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();

		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(0).sendKeys(name);// 名称
		inputs.get(1).sendKeys(order);// 排序
		webtest.tapClick();
		Select belong = new Select(getDriver().findElement(By.id("parent_id")));
		belong.selectByVisibleText(type);
		webtest.click("id=submitBtn");
		Thread.sleep(100);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(name));
	}

	@Test(priority = 15, description = "页面-页面管理-PC端导航栏")
	public void test_Click02() throws Exception {
		webtest.leaveFrame();
		Thread.sleep(200);
		webtest.click("link=PC端导航栏");
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains("自定义导航栏管理"));
	}

	@DataProvider(name = "link")
	public Object[][] getExcelData() throws Exception {
		return new ExcelDataProvider()
				.getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "linkdata.xlsx", "Sheet1");
	}

	@Test(priority = 20, dataProvider = "link", description = "新增底部导航")
	public void test_AddLinkBottom(String place, String content, String order) throws Exception {
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();
		Thread.sleep(50);
		// System.out.println("****"+fbuttons.size());
		Select places = new Select(getDriver().findElement(By.id("position")));
		places.selectByValue(place);
		Select contents = new Select(getDriver().findElement(By.id("system_bottom")));
		contents.selectByVisibleText(content);
		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(2).sendKeys(order);// 排序

		webtest.click("id=submitBtn");
		Thread.sleep(3000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(place));
	}

	@DataProvider(name = "link2")
	public Object[][] getExcelData2() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "link.xlsx",
				"Sheet1");
	}

	@Test(priority = 22, dataProvider = "link2", description = "新增顶部 导航")
	public void test_AddLinkTop(String place, String content, String order) throws Exception {
		List<WebElement> fbuttons = getDriver().findElements(By.className("fbutton"));
		fbuttons.get(0).click();
		Thread.sleep(50);

		Select places = new Select(getDriver().findElement(By.id("position")));
		places.selectByValue(place);
		Select contents = new Select(getDriver().findElement(By.id("system_nav")));
		contents.selectByVisibleText(content);
		List<WebElement> inputs = getDriver().findElements(By.className("input-txt"));
		inputs.get(2).sendKeys(order);// 排序

		webtest.click("id=submitBtn");
		Thread.sleep(3000);
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(place));
	}

	@DataProvider(name = "manage")
	public Object[][] getExcelData3() throws Exception {
		return new ExcelDataProvider().getTestDataByExcel(ReadProperties.getPropertyValue("data_path") + "manage.xlsx",
				"Sheet1");
	}

	@Test(priority = 25, dataProvider = "manage", description = "页面管理左侧导航栏的点击")
	public void test_Click01(String linkName, String content) throws Exception {
		webtest.leaveFrame();
		webtest.click("link=" + linkName);
		Thread.sleep(100);
		webtest.enterFrame("workspace");
		AssertJUnit.assertTrue(getDriver().getPageSource().contains(content));
		webtest.leaveFrame();
		Thread.sleep(100);
	}
}
