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
public class TestHibernate23 {
	
	public static void main(String[] args) {
		
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
         
        System.out.println("log1");
        Product p = (Product)s.get(Product.class, 5);
        System.out.println("log2");
        Product p2 = (Product)s.load(Product.class, 5);
        System.out.println("log3");
         
        Product p3 = (Product)s.get(Product.class, 500);
        System.out.println("p3="+p3);
         
        Product p4 = (Product)s.load(Product.class, 500);
        System.out.println("p3="+p4);
        
        s.getTransaction().commit();
        s.close();
        sf.close();
		
	}
	
	
	
}
