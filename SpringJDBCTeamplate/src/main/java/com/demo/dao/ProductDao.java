package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void saveProdct(Product p);

	void modifyProduct(Product p);

	void removeProduct(int dpid);

	Product showById(int pid);

	List<Product> findAll();

	List<Product> findByPrice(double price);
	
}
