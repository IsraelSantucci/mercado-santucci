<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<h1>Tabela de produtos</h1>
		<table class="table">
			<thead>
				<th>Id</th>
				<th>Produto</th>
				<th>Descrição</th>
				<th>Categoria</th>
				<th>Valor</th>
			</thead>
			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td>${produto.id}</td>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>${produto.categoria.nome}</td>
					<td>${produto.valor}</td>
					
					<td><a href="controller?acao=EditarProdutoForm&id=${produto.id }" class="btn btn-success">Editar</a>
					<a href="controller?acao=ExcluirProduto&id=${produto.id }" class="btn btn-danger">excluir</a></td>
				<tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>