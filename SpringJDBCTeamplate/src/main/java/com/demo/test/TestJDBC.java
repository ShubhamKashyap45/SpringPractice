package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner scn = new Scanner(System.in);
		ProductService pservice = (ProductService) context.getBean("productServiceImpl");
		int choice = 0;
		do {
			System.out.println("1.Add new product");
			System.out.println("2.Delete Product");
			System.out.println("3.Modify Product");
			System.out.println("4.Display by Id");
			System.out.println("5.Display All");
			System.out.println("6. Display by Price");
			System.out.println("7. Exit");
			System.out.println();
			System.out.println("Enter your Choice");

			choice = scn.nextInt();

			switch (choice) {
			case 1:
				pservice.addNewProduct();
				System.out.println("New Product Added");
				System.out.println();
				break;

			case 2:
				pservice.deleteProduct();
				System.out.println("Product is deleted");
				System.out.println();
				break;

			case 3:
				pservice.modifyProduct();
				System.out.println("Product is modified");
				System.out.println();
				break;

			case 4:
				Product res = pservice.displayProductById();
				System.out.println(res);
				break;

			case 5:
				List<Product> plist = pservice.getAllProducts();
				plist.forEach(System.out::println);
				break;
			case 6:
				System.out.println("accept price");
				double price = scn.nextDouble();
				plist = pservice.getByPrice(price);
				if (plist != null) {
					plist.forEach(System.out::println);
				} else {
					System.out.println("product not found");
				}
				
				break;

			case 7:
				System.out.println("Thank You for Visiting......");
				break;
				
			default:
				System.out.println("invalid choice");

			}
			
			
		} while (choice != 7);

	}

}
