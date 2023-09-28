<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenid@</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/Css/style.css">
<link rel="icon" href="https://static.vecteezy.com/system/resources/thumbnails/004/283/938/small/pm-logo-monogram-emblem-style-with-crown-shape-design-template-free-vector.jpg" type="image/x-icon">
</head>
<body>
	<div class="container-fluid gradienteLogin">
		<div class="container pt-5 pb-5">
			<div class="bg-light">
				<div class="text-center"><h1>Bienvenid@</h1></div>
				<div class="d-flex flex-wrap">
					<div class="d-flex col-12 mt-3">
						<h3 class="col-6 text-center">Iniciar Sesion</h3>
						<h3 class="col-6 text-center">Registrarse</h3>
					</div>
					<div class="col-12 mt-2 d-flex justify-content-evenly mb-3">
						<div class="col-5">
							<form action="/login" method="POST">
								<label>E-Mail</label>
								<input type="email" class="form-control" name="email">
								<br>
								<label>Contraseña</label>
								<input type="password" class="form-control" name="contrasena">
								<br>
								<input type="submit" class="btn btn-success d-flex justify-content-center">
							</form>
							<p class="text-center text-danger">${error_login}</p>
						</div>
						<div class="col-5">
							<form:form action="/registro" method="POST" modelAttribute="registro">
								<form:label path="nombre">Nombre: </form:label>
								<form:input path="nombre" class="form-control"/>
								<form:errors path="nombre" class="text-danger"/>
								<br>
								<form:label path="apellido">Apellido: </form:label>
								<form:input path="apellido" class="form-control"/>
								<form:errors path="apellido" class="text-danger"/>
								<br>
								<form:label path="email">Correo Electronico: </form:label>
								<form:input type="email" path="email" class="form-control"/>
								<form:errors path="email" class="text-danger"/>
								<br>
								<form:label path="contrasena">Contraseña: </form:label>
								<form:input type="password" path="contrasena" class="form-control"/>
								<form:errors path="contrasena" class="text-danger"/>
								<br>
								<form:label path="confirmacion">Confirmar contraseña: </form:label>
								<form:input type="password" path="confirmacion" class="form-control"/>
								<form:errors path="confirmacion" class="text-danger"/>
								<br>
								<input type="submit" class="btn btn-primary d-flex justify-content-center">
							</form:form>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>
</body>
</html>