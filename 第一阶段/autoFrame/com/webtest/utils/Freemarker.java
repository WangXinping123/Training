package com.webtest.utils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/***
 * 
 * @author ZhuangZi
 * @version $Id: Test.java,v 0.1 2013-3-5 ����02:44:35 ZhuangZi Exp $
 */

public class Freemarker {
	@SuppressWarnings("unchecked")
	/***
	 * @author Administrator
	 * @Directions ����HTMLģ��
	 * @param ftlpath
	 *            ģ����·��
	 * @param htmlpath
	 *            HTML�ļ����·��
	 * @param tempName
	 *            ����HTML�ļ���
	 * @return null
	 */
	public static void creatHtml(String ftlpath, String htmlpath, String tempName) {
		/* ������Ӧ�õ����������У����������Ӧ��ֻ��һ�Ρ� */
		/* �����͵������á� */
		Configuration cfg = new Configuration();
		try {

			cfg.setDirectoryForTemplateLoading(new File(ftlpath));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			/* ������Ӧ�õ����������У�������������ִ�ж�� */
			/* ��ȡ�򴴽�ģ�� */
			Template temp = cfg.getTemplate(tempName + ".ftl");
			/* ��������ģ�� */
			Map root = new HashMap();
			root.put("user", "Big Joe");
			Map latest = new HashMap();
			root.put("latestProduct", latest);
			latest.put("url", "products/greenmouse.html");
			latest.put("name", "green mouse");
			/* ��ģ�������ģ�ͺϲ� */
			StringWriter out = new StringWriter();
			temp.process(root, out);
			System.out.println(out.toString());

			// д��html�ļ�
			File file = new File(htmlpath + tempName + ".html");
			if (!file.exists()) {
				file.mkdirs();
			}
			if (file.exists()) {
				file.delete();
			}
			RandomAccessFile ra = null;
			ra = new RandomAccessFile(file, "rw");
			ra.write(out.toString().getBytes("gb2312"));
			ra.close();
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		creatHtml("WebRoot/ftl", "WebRoot/html", "test");
	}
}
