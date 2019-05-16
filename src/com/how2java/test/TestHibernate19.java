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
public class TestHibernate19 {
	
	public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        Session s = sf.openSession();
        s.beginTransaction();
        Category p1 = (Category) s.get(Category.class, 1);
        Category p2 = (Category) s.get(Category.class, 1);
        s.getTransaction().commit();
        s.close();
        
        Session s2 = sf.openSession();
        s2.beginTransaction();
        Category p3 = (Category) s2.get(Category.class, 1);
 
        s2.getTransaction().commit();
        s2.close();
        sf.close();
		
	}
	
	
	
}
