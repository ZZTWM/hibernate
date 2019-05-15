package com.how2java.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * HQL（Hibernate Query Language）是hibernate专门用于查询数据的语句，有别于SQL，HQL 更接近于面向对象的思维方式。 
 * 比如使用的是类的名字Product,而非表格的名字product_
 * @author Administrator
 *
 */
public class TestHibernate07 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		s.beginTransaction();
		
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%" + name + "%");
		
		List<Product> ps =q.list();
		
		for (Product p : ps) {
			System.out.println(p.getName());
		}
		
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
	
}
