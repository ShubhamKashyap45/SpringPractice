package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.MyUser;

public class TestMyUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		var u1 = context.getBean(MyUser.class);
		System.out.println(u1);
		System.out.println("before close");
		((ClassPathXmlApplicationContext)context).close();
	}

}
