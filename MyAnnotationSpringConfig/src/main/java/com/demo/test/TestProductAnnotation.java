package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		var p = context.getBean("product");
		var c = context.getBean("catogery");
		System.out.println(p);
		System.out.println(c);
		((ClassPathXmlApplicationContext)context).close();
	}

}
