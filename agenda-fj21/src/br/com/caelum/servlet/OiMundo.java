package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {

	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Calendar ca = Calendar.getInstance();
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align='center'>Oi mundo Servlet!</h1>");
		out.println("<h5 align='center'>"+ca.getTime()+"</h5>");
		out.println("</body>");
		out.println("</html>");
}
	
}
