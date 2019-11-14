package com.webtest.freemarker_demo;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 匹配外部模板样式创建文件
 * @author yjp
 *
 */
public class Test02 {
	
	private static String TEMPLATE_PATH = "F:\\Freemarker学习\\模板";
	
    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            dataMap.put("time", time);
            dataMap.put("test_name", "tpshop");
            dataMap.put("description", "这一一个word模板验证！");
            //dataMap.put("name", "百度");
            
            // step4 加载模版文件
            Template template = configuration.getTemplate("001.html");
            // step5 生成数据
            File docFile = new File("F:\\Freemarker学习\\生成报告" + "\\" + "test_001"+".html");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^测试报告 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
