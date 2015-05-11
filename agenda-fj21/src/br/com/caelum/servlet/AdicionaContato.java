package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;


@WebServlet("/contato")
public class AdicionaContato extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// pegando os parâmetros do request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("data");
		System.out.println(dataEmTexto);
		Calendar dataNascimento = null;
		// fazendo a conversão da data
		try {
		Date date = new SimpleDateFormat("dd/MM/yyyy")
		.parse(dataEmTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		} catch (ParseException e) {
		out.println("Erro de conversão da data");
		return; //para a execução do método
		}
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adContato(contato);
		// imprime o nome do contato que foi adicionado
		response.sendRedirect("lista.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Contato cont = new Contato();
		ContatoDao dao = new ContatoDao();
		
		String acao = request.getParameter("acao");
		 if( acao.equals("n")) {
			 response.sendRedirect("index.jsp");
		 }
		 if(acao.equals("ex")) {
		    try
		    {
		    	String id = request.getParameter("id");
		    	long cod = Integer.parseInt(id);
		    	cont.setId(cod);
		    	dao.exclui(cont);
		    	response.sendRedirect("lista.jsp");
		    	
		    }
		    catch(NullPointerException enuror){
		    	
		    }
		 }
		 if(acao.equals("al")) {
			    try
			    {
			    	String id = request.getParameter("id");
			    	long cod = Integer.parseInt(id);
			    	Contato contato = new ContatoDao().getLista(cod);
			    	request.setAttribute("contatos", contato);
			    	RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp");
			    	rd.forward(request, response);
			    	
			    }
			    catch(NullPointerException enuror){
			    	
			    }
			 }
		 if(acao.equals("l")) {
			    try
			    {
			    	List<Contato> contatos = new ContatoDao().getLista();
			    	request.setAttribute("contatos", contatos);
			    	RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			    	rd.forward(request, response);
			    	
			    }
			    catch(Exception enuror){
			    	
			    }
			 }
		 
		 if(acao.equals("ps")) {
			    try
			    {
			    	List<Contato> contatos = null;
			    	String valor = request.getParameter("nome");
			    	if(valor!=null && !valor.equals(""))
			    	contatos = new ContatoDao().getLista(valor);
			    	else
			    	contatos = new ContatoDao().getLista();
			    	request.setAttribute("contatos", contatos);
			    	RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
			    	rd.forward(request, response);
			    	
			    }
			    catch(Exception enuror){
			    	
			    }
			 }
	}
	

}
