<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Cancion</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container ">
		<div><h2>Nueva Cancion</h2></div>
		<form:form action="/nuevo" method="POST" modelAttribute="cancion">
			<form:label path="nombre">Nombre de la cancion :</form:label>
			<form:input path="nombre" class="form-control"/>
			<form:errors path="nombre" class="text-danger"/>
			<br>
			<form:label path="autor">Nombre del autor :</form:label>
			<form:input path="autor" class="form-control"/>
			<form:errors path="autor" class="text-danger"/>
			<br>
			<form:label path="calificacion">Rating de la cancion(1-10) :</form:label>
			<form:input path="calificacion" class="form-control"/>
			<form:errors path="calificacion" class="text-danger"/>
			<br>
			<input type="submit" value="Guardar cancion" class="btn btn-success">
		</form:form>
	</div>
</body>
</html>
