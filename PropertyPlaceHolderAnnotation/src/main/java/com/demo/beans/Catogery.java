package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Catogery {
	
	@Value("${cat.cid}")
	private int cid;
	@Value("${cat.cname}")
	private String cname;
	public Catogery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catogery(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Catogery [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
