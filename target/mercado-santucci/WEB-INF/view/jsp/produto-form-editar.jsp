<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produto</title>
<link href="css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Cadastro de Produto</h2>
		<form action="controller?acao=EditarProduto" method="post">
			<span class="input-group-text">id:</span> <input type="text" name="id"  readonly="readonly" value="${produto.id}" /> <br> <br>
			<label>nome:</label> <input type="text" name="nome" value="${produto.nome}"/> <br> <br>
			<label>descrição:</label>
			<textarea name="descricao" row="5" cols="50" value="">${produto.descricao}</textarea>
			<br> <br> 
			
			<label>valor:</label> 
			<input type="number" step="0.01"
				name="valor" value="${produto.valor}"/> 
			
			<label>Categoria</label> 
			<select name="categoria">
				<c:if test="${not empty categorias }">
					<c:forEach var="ca" items="${categorias}" >
						<c:choose>
							<c:when test="${ca.nome eq produto.categoria.nome }">
								<option selected >${ca.nome }</option>
							</c:when>
								
							<c:otherwise>
								<option >${ca.nome }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
			</select> 
			<br><br>
			<input class="btn btn-primary" type="submit" value="Salvar">
		</form>
	</div>
</body>
</html>