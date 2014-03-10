package com.services.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;

import com.model.LoginBean;
import com.model.Todo;
import com.utils.HibernateUtil;

public class Main {

	//private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		/*factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();*/
		// read the existing entries and write to console
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.getTransaction().begin();
		Query q = session.createQuery("select t from LoginBean t");
		List<LoginBean> todoList = q.list();
		for (LoginBean todo : todoList) {
			System.out.println(todo.getName());
		}
		System.out.println("Size: " + todoList.size());
		session.getTransaction().commit();

		// create new todo
		/*em.getTransaction().begin();
		Todo todo = new Todo();
		todo.setSummary("This is a test");
		todo.setDescription("This is a test");
		em.persist(todo);
		em.getTransaction().commit();

		em.close();*/
	}
}
