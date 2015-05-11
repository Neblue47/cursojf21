<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/tarefas.css" rel="stylesheet">
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"> </script>
<script src="js/jquery-ui.js"> </script>

<title>Oi Minha FJ-21</title>
</head>
<body>
<c:url value="/imagens/caelum.png" var="imagem"/>
<img src="${imagem}"/>
<h1 align="center">Agenda FJ21</h1>
<h3 align="center"><a href="contato?acao=l">Lista de Contatos</a></h3> 
<fieldset>
<legend>Pagina de Cadastro</legend>
	<form action="contato" method="post">
		Nome: <input type="text" name="nome" /><br />
		E-mail: <input type="text" name="email" /><br />
		Endereço: <input type="text" name="endereco" /><br />
		Data Nascimento: <caelum:campoData id="data" /><br />
		Carregar foto: <input type="file" name="foto" /><br />
		<input type="reset" value="Limpar" /><input type="submit" value="Gravar" />
  </form>
</fieldset>
<span class="foot">
	<hr>
	Todos os Direitos Reservados - 2015
	</span>  
</body>
</html>