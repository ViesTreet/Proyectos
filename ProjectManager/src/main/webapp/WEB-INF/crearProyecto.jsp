<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear proyecto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<link rel="icon" href="https://static.vecteezy.com/system/resources/thumbnails/004/283/938/small/pm-logo-monogram-emblem-style-with-crown-shape-design-template-free-vector.jpg" type="image/x-icon">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<h2>Crear Proyecto</h2>
			<form:form action="/crearP" method="POST" modelAttribute="creaProyecto">
				<form:label path="titulo">Titulo del Proyecto: </form:label>
				<form:input path="titulo" class="form-control"/>
				<form:errors path="titulo" class="text-danger"/>
				<br>
				<form:label path="descripcion">Descripcion del Proyecto: </form:label>
				<form:textarea path="descripcion" class="form-control"/>
				<form:errors path="descripcion" class="text-danger"/>
				<br>
				<form:label path="fecha">Fecha de entrega: </form:label>
				<form:input type="date" path="fecha" class="form-control"/>
				<form:errors path="fecha" class="text-danger"/>
				<br>
				<form:hidden path="lider" value="${usuarioEnSesion.id}"/>
				<input type="submit" value="Crear" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>
