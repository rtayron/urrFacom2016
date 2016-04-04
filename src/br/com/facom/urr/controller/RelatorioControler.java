package br.com.facom.urr.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Relatorio")
public class RelatorioControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
  @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
	   PrintWriter out = response.getWriter();
	   
	   out.println("index.jsp");
	   out.println("bye mundo");
	   
   }

}
