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
 * @version $Id: Test.java,v 0.1 2013-3-5 下午02:44:35 ZhuangZi Exp $
 */

public class Freemarker {
	@SuppressWarnings("unchecked")
	/***
	 * @author Administrator
	 * @Directions 生成HTML模板
	 * @param ftlpath
	 *            模板存放路径
	 * @param htmlpath
	 *            HTML文件存放路径
	 * @param tempName
	 *            生成HTML文件名
	 * @return null
	 */
	public static void creatHtml(String ftlpath, String htmlpath, String tempName) {
		/* 在整个应用的生命周期中，这个工作你应该只做一次。 */
		/* 创建和调整配置。 */
		Configuration cfg = new Configuration();
		try {

			cfg.setDirectoryForTemplateLoading(new File(ftlpath));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			/* 在整个应用的生命周期中，这个工作你可以执行多次 */
			/* 获取或创建模板 */
			Template temp = cfg.getTemplate(tempName + ".ftl");
			/* 创建数据模型 */
			Map root = new HashMap();
			root.put("user", "Big Joe");
			Map latest = new HashMap();
			root.put("latestProduct", latest);
			latest.put("url", "products/greenmouse.html");
			latest.put("name", "green mouse");
			/* 将模板和数据模型合并 */
			StringWriter out = new StringWriter();
			temp.process(root, out);
			System.out.println(out.toString());

			// 写入html文件
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
