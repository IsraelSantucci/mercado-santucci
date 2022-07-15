<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categorias</title>


<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<h1>Tabela de Categorias</h1>
		<table class="table">
			<thead>
				<th>Id</th>
				<th>Categoria</th>
				
			</thead>
			<c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.nome}</td>
					
					<td><a href="controller?acao=EditarCategoriaForm&id=${produto.id }" class="btn btn-success">Editar</a>
					<a href="controller?acao=ExcluirCategoria&id=${categoria.id }" class="btn btn-danger">excluir</a></td>
				<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>