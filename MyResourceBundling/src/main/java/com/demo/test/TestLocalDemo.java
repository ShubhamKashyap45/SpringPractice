package com.demo.test;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

public class TestLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		Scanner scn = new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("1.US English");
			System.out.println("2. UK English");
			System.out.println("3. Marathi");
			System.out.println("4. Other");
			System.out.println("5. Exit");
			System.out.print("Choice");
			System.out.println("Select Language");
			
			MessageSource ms=(MessageSource) context.getBean(ResourceBundleMessageSource.class);
			String m = null, w=null, d=null, c=null;
			choice = scn.nextInt();
			Locale locale=null;
			switch(choice){
			case 1:
				locale = Locale.US;
				System.out.println("Contry: " + locale.getCountry() + " Language: " + 
				locale.getLanguage());
				
				
			case 2:
				locale = Locale.UK;
				System.out.println("Country: " + locale.getCountry() + " Language: " + locale.getLanguage());
				
//			case 3:
//				locale = new Locale("my", "marathi");
//				System.out.println("Country: " + locale.getCountry() + " Language: " + locale.getLanguage());
				
				
//			case 4:
//				locale = new Locale("aa", "test");
//				break;
				
			case 5:
				System.out.println("Thank You for visiting.....");
				scn.close();
				break;
				
			default:
				System.out.println("invalid choice");
				break;
			}
			
			m = ms.getMessage("msg.pay",null, locale);
			w = ms.getMessage("msg.welecome", new Object[] {"Shubham"}, locale);
			d = ms.getMessage("msg.data", null, locale);
			c = ms.getMessage("msg.currency",null, locale);
			System.out.println("pay: " + m);
			System.out.println("Welcome: " + w);
			System.out.println("Data: " + d);
			System.out.println("currency : "+c);
			
		} while(choice !=5);
	}

}
