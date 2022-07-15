package br.com.santucci.mercado.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.CategoriaDao;
import br.com.santucci.mercado.dao.ProdutoDao;
import br.com.santucci.mercado.model.Categoria;
import br.com.santucci.mercado.model.Produto;
import br.com.santucci.mercado.util.JPAUtil;

public class EditarProdutoForm implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		Produto produto = dao.buscarPorId(id);
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		List<Categoria> categorias = categoriaDao.buscarTodos();
		em.close();
		req.setAttribute("categorias", categorias);
		req.setAttribute("produto", produto);
		
		return "forward:produto-form-editar.jsp";
	}

}
