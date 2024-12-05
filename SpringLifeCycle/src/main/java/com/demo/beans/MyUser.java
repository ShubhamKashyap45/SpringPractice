package com.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser implements ApplicationContextAware,BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean{
	private int uid;
	private String pname;
	public MyUser() {
		super();
		System.out.println("in default constructor");
	}
	public MyUser(int uid, String pname) {
		
		super();
		System.out.println("in parametrised constructor");
		this.uid = uid;
		this.pname = pname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in myuser setuid");
		this.uid = uid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		System.out.println("in myuser setpname");
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "MyUSer [uid=" + uid + ", pname=" + pname + "]";
	}
	public void setBeanName(String name) {
		System.out.println("in setBeanName"+name);
		
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("in setBeanFactory");
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterpropertiesset");
		
	}
	public void myinit() {
		System.out.println("in myinit method");
	}
	public void destroy() throws Exception {
		System.out.println("in disposable bean destroy method");
		
	}
	public void mydestroy() {
		System.out.println("in mydestroy method");
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("in setApplicationContextAware");
		
	}

}
	
