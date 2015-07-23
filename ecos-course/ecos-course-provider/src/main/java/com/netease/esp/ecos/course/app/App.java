package com.netease.esp.ecos.course.app;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Spring 启动 ...");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:config/spring.xml", "classpath:config/dubbo.xml"});
		context.start();
		System.out.println("Spring 运行中 ...");

		// 为保证服务一直开着，利用输入流的阻塞来模拟
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		context.close();
	}
}
