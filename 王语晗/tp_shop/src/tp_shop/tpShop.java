package tp_shop;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class tpShop extends BaseTest{
	@Test(priority=1)
	public void register() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
		
		//����ע��
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=2)
	public void login() throws InterruptedException{
		//��¼���ֻ��ŵ�¼��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
		
		//��¼�������¼��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=8@qq.com", "13988888888");
		webtest.type("name=password", "123456");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=3)
	public void deliver() throws InterruptedException{
		//�ͻ���
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[1]/b");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[1]/ul/li[1]/a/em");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[2]/ul/li[3]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[3]/ul/li[1]/a");
		webtest.click("xpath=/html/body/div[1]/div/div/div/div[1]/span[2]/ul/li/div/div/div[2]/div/div[4]/ul/li[7]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter() throws InterruptedException{
		//�ʲ�����
		//1.�ҵ��Ż�ȯ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1�һ��Ż�ȯ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
		//1-2��ȡ�����Ż�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-1����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/dl/dd[1]/label");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[2]/div[3]/a");
		webtest.type("id=pop_card","123456");
		webtest.type("id=pop_name","admin");
		webtest.click("xpath=//*[@id='add_card']");
		webtest.click("xpath=//*[@id='all_cash']");
		webtest.type("name=paypwd","123456");
		webtest.click("xpath=//*[@id='save_data']");
		//2-2��ֵ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[3]/a[4]");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
		//2-3���Ѽ�¼
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
		//2-4���ּ�¼
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
		//3.�ҵĻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1���ֻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
		//3-2�����ۻ�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
		//3-3��������
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
	}
		
	@Test(priority=4)
	public void focusCenter() throws InterruptedException{
		//��ע����
		//1.�ҵ��ղ�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
		webtest.click("xpath=//*[@id='all2']");//ȫѡ��Ʒ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");//���ɾ��
		//2.�ҵ��㼣
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[3]/a");
	}
}
