package com.samet;
import java.util.Date;
import org.hibernate.Session;

import com.samet.user.DBUser;
import com.samet.user.Util.HibernateUtil;
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(31);
		user.setUsername("Batman");
		user.setCreatedBy("Admin");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		session.flush();
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		user.setUserId(32);
		user.setUsername("Samet");
		session2.save(user);
		System.out.println(user.getUsername());
		session2.getTransaction().commit();
		session2.close();
		
		
	}
}