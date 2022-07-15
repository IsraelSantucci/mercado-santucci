package br.com.santucci.mercado.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.santucci.mercado.model.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		em.persist(categoria);
	}

	public void atualizar(Categoria categoria) {
		em.merge(categoria);
	}

	public void apagar(Categoria categoria) {
		categoria = em.merge(categoria);
		em.remove(categoria);
	}
	
	public Categoria buscarPorId(long id) {
		return em.find(Categoria.class, id);
	}
	
	public List<Categoria> buscarTodos(){
		return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
		
	}

	public Categoria buscarPorNome(String categoriaNome) {
		
		return em.createQuery("Select c from Categoria c where c.nome = :nomeCategoria", Categoria.class)
		.setParameter("nomeCategoria", categoriaNome)
		.getSingleResult();
	}
	
	
}
