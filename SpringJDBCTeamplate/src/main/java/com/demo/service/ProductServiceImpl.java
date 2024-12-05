package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao pdao;
	
	public void addNewProduct() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=scn.nextInt();
		System.out.println("Enter name");
		String pname = scn.next();
		System.out.println("Enter Quantity");
		int qty = scn.nextInt();
		System.out.println("Enter Price");
		double price = scn.nextDouble();
		System.out.println("Enter expiry date (dd/MM/yyyy");
		String dt = scn.next();
		LocalDate ldt = LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter cid");
		int cid = scn.nextInt();
		Product p = new Product(pid, pname, qty, price, ldt, cid);
		pdao.saveProdct(p);
	}

	@Override
	public void modifyProduct() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter pid: ");
		int pid = scn.nextInt();
		System.out.println("Enter name to update: ");
		String uname = scn.next();
		System.out.println("Enter quantity to update: ");
		int uqty = scn.nextInt();
		System.out.println("Enter Price to update: ");
		double uprice = scn.nextDouble();
		System.out.println("Enter Date to update (dd/MM/yyyy: ");
		String udt = scn.next();
		LocalDate uldt = LocalDate.parse(udt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter your cid");
		int ucid = scn.nextInt();
		
		Product p = new Product(pid, uname, uqty, uprice, uldt, ucid);
		pdao.modifyProduct(p);
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter pid to delete");
		int dpid = scn.nextInt();
		pdao.removeProduct(dpid);

		
	}

	@Override
	public Product displayProductById() {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter pid to display");
		int pid = scn.nextInt();
		return pdao.showById(pid);
		
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public List<Product> getByPrice(double price) {
		// TODO Auto-generated method stub
		return pdao.findByPrice(price);	}
	
}
