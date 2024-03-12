package com.cafe.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	private HibernateUtils() {
	}
	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			// Mở kết nối tới database
			sf = new Configuration().configure().buildSessionFactory();
		}

		return sf;
	}

}
