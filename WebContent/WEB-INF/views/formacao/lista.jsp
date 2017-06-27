<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuários</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://v4-alpha.getbootstrap.com/examples/narrow-jumbotron/narrow-jumbotron.css">
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills float-right">
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/ProjetoSpringMVC/">Home <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/ProjetoSpringMVC/usuarios">Usuarios</a>
					</li>
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/ProjetoSpringMVC/formacoes">Formação</a>
					</li>
				</ul>
			</nav>
			<h3 class="text-muted">Projeto Spring MVC</h3>
		</div>

		<h2>
			Lista de formações - <a href="formacao/novo"
				class="btn btn-outline-success">criar formação</a>
		</h2>
		<hr>
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Ano</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="formacao" items="${listaformacoes}">
				<tr>
					<td>${formacao.curso}</td>
					<td>${formacao.anoInicio}</td>
					<td><a class="btn btn-outline-success btn-sm" href="formacao/editar/${formacao.id}"> editar </a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>