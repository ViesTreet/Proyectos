<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenidos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="col-12 text-center mt-5">
			<h2>Bienvenid@s</h2>
		</div>
		<div class="col-12 d-flex flex-wrap mt-3 justify-content-around">
			<div class="col-5">
				<div class="text-center"><h4>Registrarse</h4></div>
				<div>
					<form:form action="/registro" method="post" modelAttribute="registro">
						<form:label path="nombre">Nombre:</form:label>
						<form:input path="nombre" class="form-control" placeholder="Pon tu nombre aqui"/>
						<form:errors path="nombre" class="text-danger" />
						<br>
						<form:label path="apellido">Apellido:</form:label>
						<form:input path="apellido" class="form-control" placeholder="Pon tu apellido aqui"/>
						<form:errors path="apellido" class="text-danger" />
						<br>
						<form:label path="email">Correo Electronico:</form:label>
						<form:input type="email" path="email" class="form-control" placeholder="Pon tu e-mail aqui"/>
						<form:errors path="email" class="text-danger" />
						<br>
						<form:label path="contrasena">Contraseña:</form:label>
						<form:input type="password" path="contrasena" class="form-control" placeholder="Pon tu contraseña aqui"/>
						<form:errors path="contrasena" class="text-danger" />
						<br>
						<form:label path="confirmacion">Confirma la contraseña:</form:label>
						<form:input type="password" path="confirmacion" class="form-control" placeholder="Pon tu contraseña aqui"/>
						<form:errors path="confirmacion" class="text-danger" />
						<br>
						<div class="col-12 d-flex justify-content-center">
							<input type="submit" value="Registrarme" class="btn btn-success">
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-5">
				<div class="text-center"><h4>Iniciar sesion</h4></div>
				<div>
					<form action="/login" method="post">
						<label>Correo Electronico</label>
						<input name="loginEmail" type="email" class="form-control" placeholder="Pon tu e-mail aqui">
						<br>
						<label>Contraseña</label>
						<input name="loginContrasena" type="password" class="form-control" placeholder="Pon tu contraseña aqui">
						<br>
						<div class="col-12 d-flex justify-content-center">
							<input type="submit" value="Entrar" class="btn btn-primary">
						</div>
					</form>
					<div class="col-12"><p class="text-center text-danger">${error_login}</p></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>