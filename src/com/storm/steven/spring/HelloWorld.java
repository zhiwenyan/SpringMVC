package com.storm.steven.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	/**
	 * @RequestMappingӳ������URL
	 * ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ ����InternalResourceViewResolver�������½�����
	 * pref+retuanVal+��׺ �����ķ�ʽ�õ�ʵ�ʵ�������ͼ
	 * /WEB_INF/views/success.jsp
	 */

	@RequestMapping("/helloworld")  
	public String sayHello(){
		System.out.println("Hello World");
		return "success";
	}
}
