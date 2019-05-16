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
 * ����
 */
public class TestHibernate13 {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		//��s.begin.Transaction��ʼ
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 1);
		s.delete(p);
		
		Product p2 = (Product) s.get(Product.class, 2);
		p2.setName("���ȳ���30���ַ�����Ϊ��Ʒ���Ƴ��ȳ���30���ַ�����Ϊ��Ʒ���Ƴ��ȳ���30���ַ�����Ϊ��Ʒ���Ƴ��ȳ���30���ַ�����Ϊ��Ʒ����");
		s.update(p2);
		
		//��s.getTransaction().commit()����
		s.getTransaction().commit();
		
		s.close();
		sf.close();
		
	}
	
}
