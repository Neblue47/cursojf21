<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/tarefas.css" rel="stylesheet">

<title>Lista de Contato</title>
</head>

<body>
<c:url value="/imagens/caelum.png" var="imagem"/>
<img src="${imagem}"/>
	<h1 align="center">Agenda FJ21</h1> 
	<h3 align="center"><a href="contato?acao=n">Novo Contato</a></h3> 
	<table border="1" width="100%">
	  <thead>
	  <tr>
	    <th> Nome </th>
	    <th> Email </th>
	    <th> Endereco </th>
	    <th> Nascido aos </th>
	    <th colspan="2"> Acao </th>
	    </tr>
	  </thead>
	  <tbody>
	  <fieldset>
		<legend>Pesquisar pelo nome</legend>
			<form action="contato" method="get">
				<input type="text" name="nome" /><input type="hidden" name="acao" value="ps"/>
				<input type="submit" value="Ok" />
		  </form>
		</fieldset>
	   <c:forEach var="contato" items="${contatos}">
	    <tr> 
	        <td>${contato.nome} </td>
	        <td>
	            <c:if test="${not empty contato.email}"> <a href="mailto:${contato.email}">${contato.email}</a></c:if>
                <c:if test="${empty contato.email}">E-mail não informado</c:if> 
            </td>
	        <td>${contato.endereco}</td>
	        <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /> </td> 
	        <td align="center"> <a href="contato?id=${contato.id}&acao=al"> Editar</a></td>
	        <td align="center"> <a href="contato?id=${contato.id}&acao=ex"> Excluir</a></td>
	    </tr>
	    </c:forEach>    
	  </tbody>
	</table>
	
	<span class="foot">
	<hr>
	Todos os Direitos Reservados - 2015
	</span>
</body>
</html>