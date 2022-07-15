package br.com.santucci.mercado.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.ProdutoDao;
import br.com.santucci.mercado.model.Produto;
import br.com.santucci.mercado.util.JPAUtil;

public class ExcluirProduto implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		ProdutoDao dao = new ProdutoDao(em);
		Produto produto = dao.buscarPorId(id);
		dao.apagar(produto);
		em.getTransaction().commit();
		em.close();
		System.out.println("apagando");
		return "redirect:controller?acao=ListarProdutos";
	}

}
