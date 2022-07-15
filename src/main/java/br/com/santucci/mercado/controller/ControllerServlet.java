package br.com.santucci.mercado.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.santucci.mercado.acao.Acao;

@WebServlet(urlPatterns="/controller")
public class ControllerServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acaoParametro = req.getParameter("acao");
		
		String nome = "";
		try {
			Class<?> classeLocalizada = Class.forName("br.com.santucci.mercado.acao." + acaoParametro);
			Acao acao = (Acao) classeLocalizada.getDeclaredConstructor().newInstance();
			nome = acao.executa(req, resp);
			
		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new ServletException(e);
		}
	
		String[] caminho = nome.split(":");
		if(caminho[0].equals("forward")) {
			RequestDispatcher dispatcher= req.getRequestDispatcher("WEB-INF/view/jsp/" + caminho[1]);
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect(caminho[1]);
		}
	}
	
	
	
	
}
