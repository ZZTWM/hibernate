package com.how2java.test;

import java.util.HashSet;
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
import com.how2java.pojo.User;

/**
 * 
 */
public class TestHibernate20 {
	
	public static void main(String[] args) {
		
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
         
        Category c1 = (Category)s.get(Category.class, 5);
        System.out.println("log1");
        Category c2= (Category)s.get(Category.class, 5);
        System.out.println("log2");
        s.getTransaction().commit();
        s.close();
        Session s2 = sf.openSession();
        s2.beginTransaction();
        Category c3 = (Category)s2.get(Category.class, 5);
        System.out.println("log3");
  
        s2.getTransaction().commit();
        s2.close();
        sf.close();
		
	}
	
	
	
}
