<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usu�rio - Detalhe</title>
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
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/ProjetoSpringMVC/usuarios">Usuarios</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/ProjetoSpringMVC/formacoes">Forma��o</a>
					</li>
				</ul>
			</nav>
			<h3 class="text-muted">Projeto Spring MVC</h3>
		</div>

		<h2>Edi��o de Usu�rio</h2>
		<hr>
		<div class="row">
			<div class="col-md-6">
				<form:form method="POST" action="/ProjetoSpringMVC/usuario/gravar">
					
					<form:hidden path="id" />
					<h6>${data}</h6>
					<div class="form-group">
						<label for="exampleInputEmail1">Nome</label>
						<form:input path="nome" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">E-mail</label>
						<form:input path="email" cssClass="form-control" />
					</div>


					<div class="form-group">
						<label for="exampleInputEmail1">Login</label>
						<form:input path="login" cssClass="form-control" />
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Senha</label>
						<form:password path="senha" cssClass="form-control" />
					</div>
					<input type="submit" value="Grava" class="btn btn-outline-success">
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>