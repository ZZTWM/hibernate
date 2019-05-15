package com.how2java.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 *
 */
public class TestHibernate11 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c = (Category) s.get(Category.class, 1);
		Set<Product> ps = c.getProducts();
		
		for (Product p : ps) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
	
}
