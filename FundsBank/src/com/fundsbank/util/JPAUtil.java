package com.fundsbank.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	private JPAUtil() {
		
	}
	
	
	public static EntityManager getEntityManager() {
		if(em==null || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("bankentity");
			em = emf.createEntityManager();
			
		}
		
		return em;
	}
	
	public static void close() {
		emf.close();
	}

}
