package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	void modifyProduct();

	void deleteProduct();

	Product displayProductById();

	List<Product> getAllProducts();

	List<Product> getByPrice(double price);

}
