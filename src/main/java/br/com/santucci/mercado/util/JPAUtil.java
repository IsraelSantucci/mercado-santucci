package br.com.santucci.mercado.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("postgress");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
