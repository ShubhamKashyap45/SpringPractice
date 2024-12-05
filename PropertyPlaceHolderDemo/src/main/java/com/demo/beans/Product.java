package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@Value("${prod.pid}")
	private int pid;
	@Value("${prod.pname}")
	private String pname;
	@Value("${prod.qty}")
	private int qty;
	@Autowired
//	@Qualifier("c1")
	Catogery c;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Catogery getC() {
		return c;
	}

	public void setC(Catogery c) {
		this.c = c;
	}

	public Product(int pid, String pname, int qty, Catogery c) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.c = c;
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + "]";
	}
	
	

}
