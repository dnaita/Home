package com.tutorial.services.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorial.LoginBean;
import com.tutorial.PhoneBook;

public class ManagedLoginBean {

	private static final String PERSISTENCE_UNIT_NAME = "todos";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();

	public List<PhoneBook> getPhoneBookDetails() {

		List<PhoneBook> result = em.createQuery("Select t from PhoneBook t").getResultList();
		for (PhoneBook bean : result) {
			System.out.println(bean.getName());
			System.out.println(bean.getPhoneNum());
		}
		return result;
	}

	public void insertLoginDetail(PhoneBook phoneDetails) {

		em.getTransaction().begin();
		em.persist(phoneDetails);
		em.getTransaction().commit();
		
	}
	
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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

		em.close();
	}

}
