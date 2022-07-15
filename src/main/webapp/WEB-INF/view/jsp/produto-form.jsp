<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produto</title>
</head>
<body>
	<h2>Cadastro de Produto</h2>
	<form action="controller?acao=NovoProduto" method="post">
		<label>nome:</label> <input type="text" name="nome" /> <br> <br>
		<label>descrição:</label>
		<textarea name="descricao" row="5" cols="50"></textarea>
		<br> <br> 
		
		<label>valor:</label> 
		<input type="number" step="0.01"
			name="valor" /> 
		<label>categoria</label> 
		<select name="categoria">
			<c:if test="${not empty categorias }">
				<c:forEach var="ca" items="${categorias}" >
					<option><c:out value="${ca.nome }"/></option>
				</c:forEach>

			</c:if>
		</select> 
		<br><br>
		<input type="submit" value="cadastrar">
	</form>
	
</body>
</html>