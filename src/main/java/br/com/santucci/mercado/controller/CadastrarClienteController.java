package br.com.santucci.mercado.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.dao.CategoriaDao;
import br.com.santucci.mercado.model.Categoria;
import br.com.santucci.mercado.util.JPAUtil;


@WebServlet (urlPatterns = "/cadastrar-cliente")
public class CadastrarClienteController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		List<Categoria> categorias = categoriaDao.buscarTodos();
		System.out.println(categorias.size());
		req.setAttribute("categorias", categorias);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("cadastrar-cliente.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
	
}
