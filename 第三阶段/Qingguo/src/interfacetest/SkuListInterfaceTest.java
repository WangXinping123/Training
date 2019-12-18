package interfacetest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;


/**
 * 项目名称：Qingguo   
 * 类名称：SkuListInterfaceTest   
 * 类描述： 查询商品
 * @author 杨久鹏
 */
public class SkuListInterfaceTest extends HttpDriver{
	Checker checker;
	@Test(description="获取所有商品的sku列表")
	public void getAll() throws Exception{
		String result = HttpDriver.doGet("/common/skuList");
		System.out.println(result);
		checker = new Checker(result);
		checker.verifyXpath("message", "success");
	}
	
	@Test(description="获取goodsId=1的商品sku信息")
	public void getGoodId() throws Exception{
		String result = HttpDriver.doGet("/common/skuList","goodsId=1");
		checker = new Checker(result);
		checker.verifyXpath("message", "success");
	}
	@Test(description="获取商品sku信息失败(超过int最大取值范围)")
	public void getFail1() throws Exception{
		String result = HttpDriver.doGet("/common/skuList","goodsId=2147483648");
		System.out.println(result);
		checker = new Checker(result);
		checker.verifyXpath("message", "商品ID不正确");
	}
	@Test(description="获取goodsId不存在的商品失败")
	public void getFail2() throws Exception{
		String result = HttpDriver.doGet("/common/skuList","goodsId=9999");
		System.out.println(result);
		checker = new Checker(result);
		checker.verifyXpath("message", "商品ID不存在");
	}
	@Test(description="goodsId类型不正确")
	public void getFail3() throws Exception{
		String result = HttpDriver.doGet("/common/skuList","goodsId='1'");
		System.out.println(result);
		checker = new Checker(result);
		checker.verifyXpath("message", "商品ID参数类型不正确");
	}
}
