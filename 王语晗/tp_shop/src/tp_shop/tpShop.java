package tp_shop;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class tpShop extends BaseTest{
	@Test(priority=1)
	public void register() throws InterruptedException{
		//打开网页
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//手机注册
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
		
		//邮箱注册
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=2)
	public void login() throws InterruptedException{
		//登录（手机号登录）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
		
		//登录（邮箱登录）
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=8@qq.com", "13988888888");
		webtest.type("name=password", "123456");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=3)
	public void deliver() throws InterruptedException{
		//送货至
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[1]/b");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[1]/ul/li[1]/a/em");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[2]/ul/li[3]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[3]/ul/li[1]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[4]/ul/li[7]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter() throws InterruptedException{
		//资产中心
		//1.我的优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1兑换优惠券
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
		//1-2领取更多优惠
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
		//2.账户余额
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-1提现
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/dl/dd[1]/label");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[2]/div[3]/a");
		webtest.type("id=pop_card","123456");
		webtest.type("id=pop_name","admin");
		webtest.click("xpath=//*[@id='add_card']");
		webtest.click("xpath=//*[@id='all_cash']");
		webtest.type("name=paypwd","123456");
		webtest.click("xpath=//*[@id='save_data']");
		//2-2充值
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[3]/a[4]");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
		//2-3消费记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
		//2-4提现记录
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
		//3.我的积分
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1积分换购
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
		//3-2积分累积
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
		//3-3积分消费
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
	}
		
	@Test(priority=4)
	public void focusCenter() throws InterruptedException{
		//关注中心
		//1.我的收藏
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
		webtest.click("xpath=//*[@id='all2']");//全选商品
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");//点击删除
		//2.我的足迹
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[3]/a");
	}
}
