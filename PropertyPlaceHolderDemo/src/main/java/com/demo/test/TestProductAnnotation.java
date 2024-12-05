package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Catogery;
import com.demo.beans.Product;

public class TestProductAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		var p = context.getBean(Product.class);
		var c = context.getBean(Catogery.class);
		
		System.out.println(p);
		System.out.println(c);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
