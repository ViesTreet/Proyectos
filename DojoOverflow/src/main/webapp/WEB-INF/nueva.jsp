<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear una pregunta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 class="text center">Nueva Pregunta</h2>
		<div>
			<form:form action="/nuevo" method="POST" modelAttribute="pregunta">
				<form:label path="contenido">Tu pregunta es:</form:label>
				<form:input path="contenido" class="form-control"/>
				<form:errors path="contenido" class="text-danger"/>
				<br>
				<label>Etiquetas</label>
				<input type="text" name="textoEtiquetas" class="form-control">
				<br>
				<input type="submit" value="Guardar" class="btn btn-success mt-2">
			</form:form>
		</div>
	</div>
</body>
</html>
