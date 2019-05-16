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
public class TestHibernate32 {

	public static void main(String[] args) throws InterruptedException {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s1 = sf.openSession();
        Session s2 = sf.openSession();
 
        s1.beginTransaction();
        s2.beginTransaction();
 
        Product p1 = (Product) s1.get(Product.class, 1);
        System.out.println("��Ʒԭ���۸���: " + p1.getPrice());
 
        p1.setPrice(p1.getPrice() + 1000);
 
        Product p2 = (Product) s2.get(Product.class, 1);
        p2.setPrice(p2.getPrice() + 1000);
 
        s1.update(p1);
        s2.update(p2);
 
        s1.getTransaction().commit();
        s2.getTransaction().commit();
 
        Product p = (Product) s1.get(Product.class, 1);
 
        System.out.println("�������μ۸����Ӻ󣬼۸��Ϊ: " + p.getPrice());
 
        s1.close();
        s2.close();
 
        sf.close();
		
	}
		
}
