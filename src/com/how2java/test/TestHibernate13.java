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
 * 事务
 */
public class TestHibernate13 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		//由s.begin.Transaction开始
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 1);
		s.delete(p);
		
		Product p2 = (Product) s.get(Product.class, 2);
		p2.setName("长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称长度超过30的字符串作为产品名称");
		s.update(p2);
		
		//由s.getTransaction().commit()结束
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
	
}
