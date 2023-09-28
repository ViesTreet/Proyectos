<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<form action="/editar" method="post">
				<input type="hidden" name="_method" value="PUT">
				<label>Nombre de la tarea:</label>
				<input name="nombreTarea" class="form-control" placeholder="${tareaActual.nombreTarea}">
				<br>
				<label>Asignado:</label>
				<select name="asignado" class="form-select">
					<c:forEach items="${usuarios}" var="usuario">
						<option value="${usuario.id}">${usuario.nombre} ${usuario.apellido}</option>
					</c:forEach>
				</select>
				<br>
				<label>Prioridad:</label>
				<select name="prioridad" class="form-select">
					<option value="3">Alta</option>
					<option value="2">Media</option>
					<option value="1">Baja</option>
				</select>
				<br>
				<input type="hidden" name="creador" value="${usuarioEnSesion.id}">
				<input type="hidden" name="idTarea" value="${tareaActual.id}">
				<input type="submit" value="Actualizar" class="btn btn-success">
			</form>
			<p class="text-danger">${error}</p>
		</div>
	</div>
</body>
</html>