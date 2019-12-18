package jinmingming;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.jinmingming.Action;
/**
 * 项目名称：TPSHOP 类名称：FenXiao 类描述： 后台分销相关操作
 * 
 * @author 靳明明      
 * @version
 */
public class FenXiao extends BaseTest{
	@BeforeClass
	public void aaa(){
		Action action=new Action(webtest);
		action.login();
		//分销
		webtest.click("link=分销");
	}
	@DataProvider(name="data1")
	public Object[][] getDada() throws Exception{
		return new TxtDataProvider().getTxtUser("data//yingxiao//fenxiao1.txt");
	}
	@Test(dataProvider="data1",priority=0)
	public void fenxiaoshangpin(String type,String ass) throws Exception{
		String a = '"'+"link"+"="+type+'"';
		webtest.click(a);
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent(ass));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	@Test(priority=1)
	void fenxiaoshezhi(){
		webtest.click("link=分销设置");
		getDriver().switchTo().frame("workspace");//进文本框
		SoftAssert soft =new SoftAssert();
		soft.assertTrue(webtest.isTextPresent("商城设置"));
		soft.assertAll();
		getDriver().switchTo().defaultContent();//出文本框
	}
	
}
