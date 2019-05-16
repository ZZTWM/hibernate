package com.how2java.test;

import java.util.HashSet;
import java.util.Iterator;
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
public class TestHibernate33 {

	public static void main(String[] args) throws InterruptedException {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        Session s = sf.openSession();
        s.beginTransaction();
   
        s.createQuery("from Category").list();
           
        s.getTransaction().commit();
        s.close();
        sf.close();
		
	}
		
}
