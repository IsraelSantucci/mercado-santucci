package br.com.santucci.mercado.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.CategoriaDao;
import br.com.santucci.mercado.model.Categoria;
import br.com.santucci.mercado.util.JPAUtil;

public class NovoProdutoForm implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		List<Categoria> categorias = categoriaDao.buscarTodos();
		req.setAttribute("categorias", categorias);
		
		em.close();
		return "forward:produto-form.jsp";
		
	}

}
