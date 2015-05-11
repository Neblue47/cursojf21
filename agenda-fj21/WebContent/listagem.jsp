<%@page import="br.com.caelum.jdbc.ContatoDao"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/tarefas.css" rel="stylesheet">
<title>Lista de Contato</title>
</head>
<%
 ContatoDao dao = new ContatoDao();   
 List <Contato> lista = dao.getLista();
 
%>
<body>
	<h1 align="center">Agenda FJ21</h1>
	<table border="1" width="100%">
	  <thead>
	  <tr>
	    <th> Nome </th>
	    <th> Email </th>
	    <th> Endereco </th>
	    <th> Nascido aos </th>
	    <th colspan="3"> Acao </th>
	    </tr>
	  </thead>
	  <tbody>
	   <%for(Contato c: lista){ %>
	    <tr> 
	        <td><%=c.getNome() %> </td>
	        <td><%=c.getEmail() %> </td>
	        <td><%=c.getEndereco() %> </td>
	        <td><%=String.format("%1$td/%1$tm/%1$tY",c.getDataNascimento()) %> </td> 
	        <td align="center"> <a href="contato?id=n"> Novo</a></td>
	        <td align="center"> <a href="#"> Editar</a></td>
	        <td align="center"> <a href="contato?id=<%=c.getId()%>"> Excluir</a></td>
	    </tr>
	    <%} %>	    
	  </tbody>
	</table>
</body>
</html>