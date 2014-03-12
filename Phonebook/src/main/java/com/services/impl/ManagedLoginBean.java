package com.services.impl;

import java.util.List;

import org.hibernate.Session;

import com.model.ContactDetail;
import com.utils.HibernateUtil;

public class ManagedLoginBean {

	/*private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();*/

	public List<ContactDetail> getPhoneBookDetails() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<ContactDetail> result = session.createQuery("Select t from ContactDetail t").list();
		for (ContactDetail bean : result) {
			System.out.println(bean.getName());
			System.out.println(bean.getPhoneNum1());
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	public void insertLoginDetail(ContactDetail phoneDetails) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(phoneDetails);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static void main(String[] args) {
	/*	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select t from Todo t");
		List<LoginBean> todoList = q.getResultList();
		for (LoginBean todo : todoList) {
			System.out.println(todo);
		}
		System.out.println("Size: " + todoList.size());

		// create new todo
		em.getTransaction().begin();
		LoginBean todo = new LoginBean();
		todo.setName("test");
		todo.setPassword("Password");
		em.persist(todo);
		em.getTransaction().commit();

		em.close();*/
		
		 	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        com.model.LoginBean todo = new com.model.LoginBean();
			todo.setName("test");
			todo.setPassword("Password");
	        session.save(todo);
	        session.getTransaction().commit();
	        session.close();
	}

}
