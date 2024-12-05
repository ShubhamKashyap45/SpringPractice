package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyClass;

public class TestAop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		MyClass ob = (MyClass)context.getBean("myClass");
		ob.m3(12);
		ob.getx();
		((ClassPathXmlApplicationContext)context).close();

	}

}
