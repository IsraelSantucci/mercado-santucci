package br.com.santucci.mercado.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.CategoriaDao;
import br.com.santucci.mercado.model.Categoria;
import br.com.santucci.mercado.util.JPAUtil;

public class NovaCategoria implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao dao = new CategoriaDao(em);
		em.getTransaction().begin();
		Categoria categoria = new Categoria(nome);
		dao.cadastrar(categoria);
		em.getTransaction().commit();
		em.close();
		return "redirect:controller?acao=ListarCategorias";
	}

}
