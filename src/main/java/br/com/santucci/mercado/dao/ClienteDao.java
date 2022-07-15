package br.com.santucci.mercado.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.santucci.mercado.model.Cliente;

public class ClienteDao {

	private EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void apagar(Cliente cliente) {
		cliente = em.merge(cliente);
		em.remove(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente buscarPorId(int id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> buscarTodos(){
		return em.createQuery("select c from Cliente c").getResultList();
	}
}
