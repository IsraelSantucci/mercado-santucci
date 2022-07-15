package br.com.santucci.mercado.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.ProdutoDao;
import br.com.santucci.mercado.model.Produto;
import br.com.santucci.mercado.util.JPAUtil;

public class ListarProdutos implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		List<Produto> produtos = dao.buscarTodos();
		req.setAttribute("produtos", produtos);
		
		em.close();
		
		return "forward:lista-produtos.jsp";
	}

}
