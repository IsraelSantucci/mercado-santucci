package br.com.santucci.mercado.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.santucci.mercado.model.Produto;

public class ProdutoDao {

	private EntityManager em;
	
	public ProdutoDao (EntityManager em) {
		this.em = em;
		
	}
	
	public void salvar(Produto produto) {
		em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		em.merge(produto);
	}
	
	public void apagar(Produto produto) {
		produto = em.merge(produto);
		em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}
}
