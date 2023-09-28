<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Tarea</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<h3 class="text-center mb-4">Nueva Tarea</h3>
			<form:form action="/nuevo" method="post" modelAttribute="nuevaTarea">
				<form:label path="nombreTarea">Nombre de la Tarea:</form:label>
				<form:input path="nombreTarea" class="form-control"/>
				<form:errors path="nombreTarea" class="text-danger" />
				<br>
				<form:label path="asignado">Asignado/a: </form:label>
				<form:select path="asignado" class="form-select">
					<c:forEach items="${usuarios}" var="usuario">
						<form:option value="${usuario.id}">${usuario.nombre} ${usuario.apellido}</form:option>
					</c:forEach>
				</form:select>
				<br>
				<form:label path="prioridad">Prioridad:</form:label>
				<form:select path="prioridad" class="form-select">
					<form:option value="3">Alta</form:option>
					<form:option value="2">Media</form:option>
					<form:option value="1">Baja</form:option>
				</form:select>
				<br>
				<form:hidden path="creador" value="${usuarioEnSesion.id}"/>
				<br>
				<input type="submit" value="Guardar" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>
