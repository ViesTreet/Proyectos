<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro e Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container-fluid gradiente">
		<div class="container">
			<div class="row">
				<div class="col-6">
					<h2>Regístrate</h2>
					<form:form action="/registro" method="POST" modelAttribute="nuevoUsuario">
						<form:label path="nombre">Nombre: </form:label>
						<form:input path="nombre" class="form-control"/>
						<form:errors path="nombre" class="text-danger"/>
						<br>
						<form:label path="apellido">Apellido: </form:label>
						<form:input path="apellido" class="form-control"/>
						<form:errors path="apellido" class="text-danger"/>
						<br>
						<form:label path="email">E-mail: </form:label>
						<form:input path="email" type="email" class="form-control"/>
						<form:errors path="email" class="text-danger"/>
						<br>
						<form:label path="password">Contraseña: </form:label>
						<form:password path="password" class="form-control"/>
						<form:errors path="password" class="text-danger"/>
						<br>
						<form:label path="confirmacion">Repite la contraseña: </form:label>
						<form:password path="confirmacion" class="form-control"/>
						<form:errors path="confirmacion" class="text-danger"/>
						<br>
						<input type="submit" value="Guardar" class="btn btn-success mt-3">
					</form:form>
				</div>
				<div class="col-6">
					<h2>Inicia Sesión</h2>
					<form action="/login" method="POST">
						<label for="emailId">E-mail: </label>
						<input type="email" id="emailId" name="email" class="form-control">
						<br>
						<label for="passwordId">Contraseña: </label>
						<input type="password" id="passwordId" name="password" class="form-control">
						<br>
						<input type="submit" value="Iniciar Sesion" class="btn btn-primary mt-3">
					</form>
					<p class="text-danger">${error_login}</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>