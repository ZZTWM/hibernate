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
public class TestHibernate28 {

	public static void main(String[] args) throws InterruptedException {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        Session s1 = sf.getCurrentSession();
 
        s1.get(Product.class, 5);
 
        s1.close();
 
        sf.close();
		
	}
		
}
