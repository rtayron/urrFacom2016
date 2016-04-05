package br.com.facom.urr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.facom.urr.dao.UpaCrsDao;
import br.com.facom.urr.entidades.UpaCrs;
import exception.DaoException;

@WebServlet("/UpaCrs")
public class UpaCrsControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	   PrintWriter out = response.getWriter();
	   String acao = request.getParameter("logica");
	   
	   if (acao == null) {
		  listar(request, response);
	   } else if (acao.equals("adicionar")){	  
		   RequestDispatcher rd = request.getRequestDispatcher("/site/addUpa.jsp");
		   rd.forward(request,response);  	
	   } else if (acao.equals("salvar")){
		   try {

			   HashMap<String, Object> valores = new HashMap<String, Object>();
			   valores.put("endereco", request.getParameter("endereco"));
			   valores.put("telefone", request.getParameter("telefone"));
			   
			   new UpaCrsDao().insert(valores);
			   this.listar(request, response);
		   } catch (DaoException e) {
			e.printStackTrace();
			returnErro(out);
		   	}
	   } else if (acao.equals("remove")){
		   
	   }
	  
   }
	
	
	private void returnErro(PrintWriter out ){
		out.println("<div class=\"alert alert-danger\">"
		+"<strong>Erro Interno!</strong>"
		+"</div>"
		);
	}
	
	
	private void listar(HttpServletRequest request,  HttpServletResponse response ){
		PrintWriter out = null;
		try {			 	
			 	out = response.getWriter();
				ArrayList<UpaCrs> upas = new UpaCrsDao().all();
				request.setAttribute("upas", upas);
				RequestDispatcher rd = request.getRequestDispatcher("/site/upaCrs.jsp");		   
				rd.forward(request,response);
			} catch (SQLException | DaoException | IOException | ServletException e) {
				e.printStackTrace();
				this.returnErro(out);
			}
	}

}
