package br.com.santucci.mercado.acao;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.CategoriaDao;
import br.com.santucci.mercado.dao.ProdutoDao;
import br.com.santucci.mercado.model.Categoria;
import br.com.santucci.mercado.model.Produto;
import br.com.santucci.mercado.util.JPAUtil;

public class EditarProduto implements Acao{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String descricao = req.getParameter("descricao");
		BigDecimal valor = new BigDecimal(req.getParameter("valor"));
		String categoriaNome = req.getParameter("categoria");
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		Categoria categoria = categoriaDao.buscarPorNome(categoriaNome);
		
		Produto produto = new Produto(nome, descricao, valor, categoria);
		produto.setId(id);
		ProdutoDao produtoDao = new ProdutoDao(entityManager);
		entityManager.getTransaction().begin();
		produtoDao.atualizar(produto);
		entityManager.getTransaction().commit();
		entityManager.close();
		return "redirect:controller?acao=ListarProdutos";
	}

}
