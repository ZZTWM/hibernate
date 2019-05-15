package com.how2java.test;

import java.util.List;

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
public class TestHibernate10 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("c1");
		s.save(c);
		
		Product p = (Product) s.get(Product.class, 8);
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
	
}
