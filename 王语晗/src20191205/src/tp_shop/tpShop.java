package tp_shop;

import javax.imageio.spi.RegisterableService;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import com.google.common.base.Throwables;
import com.webtest.core.BaseTest;

public class tpShop extends BaseTest{
	@Test(priority=1)
	public void register1() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ����Ϊ�����֣�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register2() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ����Ϊ�����֣�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "111111");
		webtest.type("id=password2", "111111");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register3() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ����Ϊ����ĸ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13888888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abcdef");
		webtest.type("id=password2", "abcdef");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register4() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ����Ϊ����ĸ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "9@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abcdef");
		webtest.type("id=password2", "abcdef");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void register5() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ����Ϊ���ֺ���ĸ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13788888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "ab1234");
		webtest.type("id=password2", "ab1234");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register6() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ����Ϊ���ֺ���ĸ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "7@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "ab1234");
		webtest.type("id=password2", "ab1234");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register7() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ�����к��������ַ���
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13688888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abc%$&");
		webtest.type("id=password2", "abc%$&");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register8() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ�����к��������ַ���
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "6@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "abc%$&");
		webtest.type("id=password2", "abc%$&");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register9() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ����ȫΪ�����ַ���
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13588888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "@#$%&*");
		webtest.type("id=password2", "@#$%&*");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void register10() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ����ȫΪ�����ַ���
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "5@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "@#$%&*");
		webtest.type("id=password2", "@#$%&*");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister1() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨ���볤��С����λ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15188888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "1");//��������
		webtest.type("id=password2", "1");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister2() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨ���볤��С����λ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "11@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "1");
		webtest.type("id=password2", "1");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister3() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨ���볤�ȴ���ʮ��λ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15288888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "888888888888888888");//��������
		webtest.type("id=password2", "888888888888888888");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
		
	@Test(priority=1)
	public void wrongRegister4() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨ���볤�ȴ���ʮ��λ��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "12@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "888888888888888888");
		webtest.type("id=password2", "888888888888888888");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister5() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨȷ�����������벻һ�£�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15388888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "567891");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister6() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨȷ�����������벻һ�£�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "13@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "567891");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister7() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨ�ֻ����벻���Ϲ淶��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "1");//�����ֻ�����
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister8() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨ���䲻���Ϲ淶��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "1");//��������
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister9() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨ�ֻ��������������ģ�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "�����ֻ���");//�����ֻ�����
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister10() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨ��������������)
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "��������");//��������
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister11() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨ�ֻ�����������Ӣ��)
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "abababababa");//�����ֻ�����
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister12() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨδ��д�ֻ��ţ�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister13() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨδ��д���䣩
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister14() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//�ֻ�ע�ᣨδ��д�Ƽ����ֻ��ţ�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "15488888888");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister15() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		
		//����ע�ᣨδ��д�Ƽ����ֻ��ţ�
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "14@qq.com");
		webtest.type("name=verify_code", "1234");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	public void wrongRegister16() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//�ֻ�ע�ᣨ��֤��δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=verify_code", "");
		webtest.type("id=password", "123456");
		webtest.type("id=password2", "123456");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=1)
	public void wrongRegister17() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
				
		//����ע�ᣨ��֤��δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[2]");
		webtest.click("xpath=/html/body/div[1]/div/ul/li[2]/a");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=verify_code", "");
		webtest.type("id=password", "111111");
		webtest.type("id=password2", "111111");
		webtest.type("name=invite", "13588888888");
		webtest.click("xpath=/html/body/div[1]/div/form/div/div/div/div[6]/div/a");
	}
	
	@Test(priority=2)
	public void login1() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//��¼���ֻ��ŵ�¼��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void login2() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//��¼�������¼��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin1() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�ֻ��ŵ�¼���ֻ��Ŵ���
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "1234");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin2() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�����¼���������
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin3() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�ֻ���¼���������
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "a");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin4() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�����¼���������
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "a");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin5() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//��¼���ֻ���δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin6() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//��¼������δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin7() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�ֻ���¼������δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin8() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�����¼������δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "");
		webtest.type("name=verify_code", "1234");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin9() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�ֻ���¼����֤��δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "13988888888");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "");
		webtest.click("xpath=/html/body/div[2]/div/div[2]/div/form/div/div[6]/a");
	}
	
	@Test(priority=2)
	public void wrongLogin10() throws InterruptedException{
		//����ҳ
		webtest.open("http://localhost:9090/Home/Index/index.html");
		//�����¼����֤��δ��д��
		webtest.click("xpath=/html/body/div[1]/div[1]/div/div/div[2]/a[1]");
		webtest.type("name=username", "8@qq.com");
		webtest.type("name=password", "123456");
		webtest.type("name=verify_code", "");
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
	public void possessionCenter1() throws InterruptedException{
		//�ʲ�����-�ҵ��Ż�ȯ-�һ��Ż�ȯ
		//1.�ҵ��Ż�ȯ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-1�һ��Ż�ȯ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]/span/a");
		webtest.type("id=coupon_code","123456");
		webtest.click("xpath=//*[@id='coupon_exchange']");
	}
	
	@Test(priority=4)
	public void possessionCenter2() throws InterruptedException{
		//�ʲ�����-�ҵ��Ż�ȯ-��ȡ�����Ż�ȯ
		//1.�ҵ��Ż�ȯ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[2]/a");
		//1-2��ȡ�����Ż�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]/span/a");
	}
	
	@Test(priority=4)
	public void possessionCenter3() throws InterruptedException{
		//�ʲ�����-�˻����-����
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-1���֣�֧������
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[1]");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/dl/dd[1]/label");
		webtest.click("xpath=/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/form/div/div[1]/div[2]/div[3]/a");
		webtest.type("id=pop_card", "13988888888");
		webtest.type("id=pop_name", "admin");
		webtest.click("xpath=//*[@id='add_card']");
		webtest.type("name=money", "888");
		webtest.type("name=paypwd", "123456");
		webtest.click("xpath=//*[@id='save_data']");
	}
	
	@Test(priority=4)
	public void possessionCenter4() throws InterruptedException{
		//�ʲ�����-�˻����-��ֵ
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-2��ֵ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[4]/a[2]");
		webtest.type("name=account", "888");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/dl/dd/div/div/ul/li[4]/div/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div/div/a[2]");
	}
	
	@Test(priority=4)
	public void possessionCenter5() throws InterruptedException{
		//�ʲ�����-�˻����-��ֵ��¼
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-3��ֵ��¼
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter6() throws InterruptedException{
		//�ʲ�����-�˻����-���Ѽ�¼
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-4���Ѽ�¼
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter7() throws InterruptedException{
		//�ʲ�����-�˻����-���ּ�¼
		//2.�˻����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[3]/a");
		//2-5���ּ�¼
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div[1]/div[3]/ul/li[3]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter8() throws InterruptedException{
		//�ʲ�����-�ҵĻ���-���ֻ���
		//3.�ҵĻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-1���ֻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/a");
		webtest.click("xpath=/html/body/div[4]/div/div/div[3]/ul[1]/li[1]/div/div[2]/div/a");
		webtest.click("xpath=//*[@id='buy_now']");
		webtest.click("xpath=/html/body/div[12]/div/button");
	}
	
	@Test(priority=4)
	public void possessionCenter9() throws InterruptedException{
		//�ʲ�����-�ҵĻ���-������ϸ
		//3.�ҵĻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-2������ϸ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[1]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter10() throws InterruptedException{
		//�ʲ�����-�ҵĻ���-�����ۼ�
		//3.�ҵĻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-3�����ۼ�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[2]/a");
	}
	
	@Test(priority=4)
	public void possessionCenter11() throws InterruptedException{
		//�ʲ�����-�ҵĻ���-��������
		//3.�ҵĻ���
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[2]/li[4]/a");
		//3-4��������
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/form/div[1]/ul/li[3]/a");
	}
		
	@Test(priority=4)
	public void focusCenter1() throws InterruptedException{
		//��ע����-�ҵ��ղ�-ɾ����Ʒ
		//1.�ҵ��ղ�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-1ɾ����Ʒ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[1]/li[1]/input");
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[6]/div[2]/a");
	}
	
	@Test(priority=4)
	public void focusCenter2() throws InterruptedException{
		//��ע����-�ҵ��ղ�-�鿴����
		//1.�ҵ��ղ�
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//1-2�鿴����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[5]/ul[2]/li[5]/div/a");
	}
	
	@Test(priority=4)
	public void focusCenter3() throws InterruptedException{
		//��ע����-�ҵ��㼣-�鿴����
		//2.�ҵ��㼣
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[1]/div/ul[3]/li[2]/a");
		//2-1�鿴����
		webtest.click("xpath=/html/body/div[3]/div/div[2]/div[2]/div/div[2]/ul/li[3]/a");
	}
}
