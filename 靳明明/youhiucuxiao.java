package com.jinmingming.business;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class youhiucuxiao extends BaseTest{
	@BeforeMethod
	public void login(){
		//Login��¼
		webtest.open("http://localhost:8036/index.php/Admin/Index/index#");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=vertify", "1234");//��֤���Ѿ����Σ����������ĸ�ֵ����
		webtest.click("name=submit");
	}

//	@DataProvider(name="excel")
//	public Object[][] getExcelDada() throws IOException{
//		return new ExcelDataProvider().getTestDataByExcel("D://ceshi//shixun//data//yingxiao//cuxiao.xlsx","Sheet1");
//	}
	
	@Test
	public void yingxiao() throws InterruptedException, AWTException{
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/a");
		//Ӫ��
		webtest.click("link=Ӫ��");
		Thread.sleep(2000);
		webtest.click("link=�Żݴ���");
		//��������
		getDriver().switchTo().frame("workspace");//���ı���
		WebElement e = getDriver().findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/a[1]/div/div/span"));
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", e);
		Thread.sleep(2000);
		//����
		//���������
		webtest.type("name=title", "title");
		//���������
		webtest.click("name=ֱ�Ӵ���");
		//�ۿ�
		webtest.type("name=expression", "90");
		//�޹�����
		webtest.type("name=buy_limit", "5");
		//��ʼʱ��
		webtest.click("name=start_time");
		WebElement s = getDriver().findElement(By.xpath("//*[@id='layui-laydate1']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", s);//���Ĭ��ʱ��
		webtest.type("name=start_time", "209-11-20 10:00:00");
		//����ʱ��
		webtest.click("name=end_time");
		WebElement end = getDriver().findElement(By.xpath("//*[@id='layui-laydate2']/div[2]/div/span[1]"));
		jse.executeScript("arguments[0].click();", end);//���Ĭ��ʱ��
		webtest.type("name=end_time", "209-11-23 10:00:00");
		//����ͼƬ
		webtest.click("xpath=/html/body/div[4]/form/div/dl[7]/dd/div/span[2]/input[3]");
		getDriver().switchTo().frame("layui-layer-iframe1");//���ı���
		WebElement d = getDriver().findElement(By.xpath("//*[@id='manage_tab']"));
		jse.executeScript("arguments[0].click();", d);
		WebElement f = getDriver().findElement(By.xpath("//*[@id='file_all_list']/li[1]/div[2]/span"));
		jse.executeScript("arguments[0].click();", f);
		webtest.click("link=ȷ��");
		//ѡ���Ż���Ʒ
		WebElement k = getDriver().findElement(By.xpath("//*[@id='handleposition']/div/dl[8]/dd/p/a"));
		jse.executeScript("arguments[0].click();", k);
		Thread.sleep(2000);
		getDriver().switchTo().frame("layui-layer-iframe1");//���ı���
		WebElement o = getDriver().findElement(By.xpath("//*[@id='flexigrid']/table/tbody/tr[1]/td[1]/div/input"));
		jse.executeScript("arguments[0].click();", o);
		webtest.click("link=ȷ���ύ");
		getDriver().switchTo().defaultContent();//���ı���
		//��Ʒ����
		//ȷ���ύ
		webtest.click("link=ȷ���ύ");
	}
}
