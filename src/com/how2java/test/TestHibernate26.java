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
public class TestHibernate26 {
	static Session s1;
	static Session s2;
	
	
	public static void main(String[] args) throws InterruptedException {
		final SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Thread t1 = new Thread(){
			public void run(){
				s1 = sf.getCurrentSession();
			}
		};
		t1.start();
		
		Thread t2 = new Thread(){
			public void run(){
				s2 = sf.getCurrentSession();
			}
		};
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(s1 == s2);
		
	}
	
	
	
}
