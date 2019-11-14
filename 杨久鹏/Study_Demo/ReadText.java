package com.webtest.freemarker_demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadText {
	static String spath = "F:\\Freemarker学习\\生成报告\\test_11.14.1.html";
	public static String read() throws IOException {
		InputStreamReader isReader = null;
        BufferedReader bufReader = null;
		StringBuffer buf = new StringBuffer();
        try {
            File file = new File(spath);
            isReader = new InputStreamReader(new FileInputStream(file), "utf-8");
            bufReader = new BufferedReader(isReader, 1);
            String data;
            while((data = bufReader.readLine())!= null) {

                   buf.append(data);
            }

       } catch (Exception e) {
       //TODO 处理异常
       } finally {
         //TODO 关闭流
          isReader.close();

         bufReader.close();

       }
        System.out.print(buf.toString());
       return buf.toString();
	}
}
