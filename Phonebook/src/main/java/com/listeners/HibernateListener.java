package com.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.utils.HibernateUtil;

public class HibernateListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 HibernateUtil.getSessionFactory(); // Just call the static initializer of that class
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().close(); // Free all resources		
	}

}
