<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Categoria</title>
</head>
<body>
	<h2>Cadastro de Categoria</h2>
	<form action="controller?acao=NovaCategoria" method="post">
		<label>nome:</label> <input type="text" name="nome" /> <br> <br>
		<br> <br> 
		
		<input type="submit" value="cadastrar">
	</form>
	
</body>
</html>