package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate05 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 5);
		s.delete(p);
		System.out.println("É¾³ý³É¹¦£¡");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
	
}
