<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tarea.nombreTarea}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<h2>Tarea: ${tarea.nombreTarea}</h2>
			<h6 class="mt-3"><b>Creador: </b>${tarea.creador.nombre}</h6>
			<h6 class="mt-2"><b>Asignado/a: </b>${tarea.asignado.nombre}</h6>
			<h6 class="mt-2"><b>Prioridad: </b>
				<c:if test="${tarea.prioridad == 3}">Alta</c:if>
				<c:if test="${tarea.prioridad == 2}">Media</c:if>
				<c:if test="${tarea.prioridad == 1}">baja</c:if>
			</h6>
		</div>
		<c:if test="${tarea.creador.id == usuarioEnSesion.id}">
			<div class="mt-4 d-flex">
				<a href="/tasks/${tarea.id}/edit" class="btn btn-warning">Editar</a>
				<form action="/tasks/${tarea.id}/delete" method="post">
					<input type="hidden" name="_method" value="DELETE">
					<input type="submit" value="Eliminar" class="btn btn-danger">
				</form>
			</div>
		</c:if>
		<div class="mt-4">
			<c:if test="${tarea.asignado.id == usuarioEnSesion.id}">
				<form action="/tasks/${tarea.id}/delete" method="post">
					<input type="hidden" name="_method" value="DELETE">
					<input type="submit" value="Completar" class="btn btn-success">
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>