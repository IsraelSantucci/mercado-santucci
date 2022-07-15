package br.com.santucci.mercado.teste;

import javax.persistence.EntityManager;

import br.com.santucci.mercado.dao.VendaDao;
import br.com.santucci.mercado.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		VendaDao dao = new VendaDao(em);
		
		
		
	}
	
	
}
