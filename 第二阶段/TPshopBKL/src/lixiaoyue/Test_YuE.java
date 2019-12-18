package lixiaoyue;

/*
 * 李晓月
 * 测试用户余额、优惠券、充值、积分
 * */


import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Test_YuE {

	public class Test_DingDan extends BaseTest{
		
		Base_login action;
		
		@BeforeMethod
		public void setup()
		{
			action=new Base_login(webtest);
		}

		//登录
		@Test(priority = 0,description="登录")
			 public void Entry() throws InterruptedException{
				action.login("13800138006", "123456");
				Thread.sleep(2000);
				AssertJUnit.assertTrue(webtest.isTextPresent("安全退出"));
				Thread.sleep(2000);
			}
		//进入我的订单页面查看账户余额、充值记录、消费记录、提现记录
		@Test(priority = 1,description="查看账户余额、充值记录")
		 public void MyYuE0() throws InterruptedException{
				webtest.click("link=账户余额");
				webtest.click("link=充值记录");
				Assert.assertTrue(getDriver().getPageSource().contains("状态"));
		}	
		
		@Test(priority = 2,description="消费记录")
		 public void MyYuE1() throws InterruptedException{
				webtest.click("link=消费记录");
				Assert.assertTrue(getDriver().getPageSource().contains("邀请会员注册赠送积分"));
		}	
		@Test(priority = 3,description="提现记录")
		 public void MyYuE2() throws InterruptedException{
				webtest.click("link=提现记录");
				Assert.assertTrue(getDriver().getPageSource().contains("手续费"));
		}	
		
		@Test(priority = 4,description="赠送积分")
		 public void MyGiven() throws InterruptedException{
				webtest.click("link=账户余额");
				webtest.click("link=消费记录");
				webtest.click("link=邀请会员注册赠送积分");
				Assert.assertTrue(getDriver().getPageSource().contains("商业用途务必购买正版,使用盗版将依法追究法律责任!!"));
		}	
		@Test(priority = 5,description="提现")
		 public void TiXian() throws InterruptedException{
			webtest.click("link=提现");
			Assert.assertTrue(getDriver().getPageSource().contains("选择提现方式"));
		}	
		
		@Test(priority = 6,description="提交申请")
		 public void TiJiao() throws InterruptedException{
			webtest.typeAndClear("id=money", "100");
			webtest.click("link=提交申请");
			Assert.assertTrue(getDriver().getPageSource().contains("账户余额不足"));
		}	
		
		
		@Test(priority = 7,description="充值")
		 public void ChongZhi() throws InterruptedException{
			webtest.open("http://localhost:8036/Home/User/recharge.html");
			webtest.click("link=充值");
			webtest.click("link=￥50.00");
			webtest.click("xpath=//*[@id='recharge_form']/div/div[2]/div/div/dl/dd/div/div/ul/li[1]/div/label/img");
			webtest.click("link=立即支付");
			Assert.assertTrue(getDriver().getPageSource().contains("商业用途务必购买正版,使用盗版将依法追究法律责任!!"));
		}
		
		
		@Test(priority = 8,description="查看优惠券、兑换优惠券")
		 public void Youhui() throws InterruptedException{
			webtest.open("http://localhost:8036/Home/user/index.html");
			webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul[2]/li[1]/a");
			webtest.click("link=兑换优惠券");
			webtest.typeAndClear("id=coupon_code", "123456");
			webtest.click("id=coupon_exchange");
			Assert.assertTrue(getDriver().getPageSource().contains("优惠券码不存在"));
		}	
		
		@Test(priority = 9,description="领取更多优惠券")
		 public void GetMo() throws InterruptedException{
			webtest.click("link=取消");
			webtest.click("link=领取更多优惠券");
			Assert.assertTrue(getDriver().getPageSource().contains("默认"));
		}	
		
		@Test(priority = 10,description="未有优惠券类型")
		 public void MoDeom() throws InterruptedException{
			webtest.click("link=默认");
			webtest.click("link=即将过期");
			webtest.click("link=面值最大");
		}	
		
		@Test(priority = 11,description="可用积分")
		 public void Cord() throws InterruptedException{
			webtest.open("http://localhost:8036/Home/user/index.html");
			webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul[1]/li[3]/a");
		}	

		@Test(priority = 12,description="积分明细、积分积累、积分消费")
		 public void Typee() throws InterruptedException{
			webtest.click("link=积分明细");
			Assert.assertTrue(getDriver().getPageSource().contains("邀请会员注册赠送积分"));
			webtest.click("link=积分积累");
			Assert.assertTrue(getDriver().getPageSource().contains("邀请会员注册赠送积分"));
			webtest.click("link=积分消费");
			Assert.assertTrue(getDriver().getPageSource().contains("下单消费"));
		}	
		
		@Test(priority = 13,description="vip充值")
		 public void Vip() throws InterruptedException{
			webtest.open("http://localhost:8036/Home/user/index.html");
			webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul[2]/li[2]/a");
			webtest.click("xpath=确认支付方式");
			webtest.click("xpath=确定");
			Assert.assertTrue(getDriver().getPageSource().contains("商业用途务必购买正版,使用盗版将依法追究法律责任!!"));
		}	
	}
}
