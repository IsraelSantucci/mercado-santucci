package br.com.santucci.mercado.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.santucci.mercado.model.Cliente;
import br.com.santucci.mercado.model.Pedido;

public class VendaDao {

	private EntityManager em;
	
	public VendaDao(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Pedido pedido) {
		em.persist(pedido);
	}
	
	public void apagar(Pedido pedido) {
		pedido = em.merge(pedido);
		em.remove(pedido);
	}
	
	public Pedido buscarPorId(int id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> buscarPorCliente(Cliente cliente){
		return em.createQuery("select v form Pedido v "
				+ "inner join Cliente c "
				+ "where c.id = :cliente_id", Pedido.class)
				.setParameter("Cliente_id", cliente.getId())
				.getResultList();
	}
}