package com.School.mypro_hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private static final SessionFactory sessionfactory=getsessionfactory();

	private static SessionFactory getsessionfactory()
	{
		try
		{
			return new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Food.class).buildSessionFactory();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static Session getSession()
	{
		return sessionfactory.openSession();
		
	}
	
}

