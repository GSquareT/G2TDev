package com.gsquaret.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		 
		session.beginTransaction();
		List<User> li=getUsers(session);
		//session.create
		for (User user : li) {
			System.out.print(user.getUserId()+"  ");
			System.out.println(user.getUsername());
		}
		User user = new User();
		user.setUserId(1);
		user.setUsername("Gopal");
		user.setCreatedBy("Application");
		user.setCreatedDate(new Date());
		session.save(user);
		
		session.getTransaction().commit();
		
		
	}
	
	public static List<User> getUsers(Session session) {
		 List<User> list = session.createCriteria(User.class).list();
		 return list;
	}
	

}
