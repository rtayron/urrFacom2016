package br.com.facom.urr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
	   
	   if (acao.equals("all")) {
		   try {
			ArrayList<UpaCrs> upas = new UpaCrsDao().all();
			RequestDispatcher rd = request.getRequestDispatcher("/site/upaCrs.jsp");		   
			rd.forward(request,response);
		} catch (SQLException | DaoException e) {
			out.println("<div class=\"alert alert-danger\">"
			+"<strong>Danger!</strong> "+e.getCause()
			+"</div>"
			);
		}
		   
		   
		   
	   } else if (acao.equals("adiciona")){
		   
	   } else if (acao.equals("edit")){
		   
	   } else if (acao.equals("remove")){
		   
	   }
	  
   }

}
