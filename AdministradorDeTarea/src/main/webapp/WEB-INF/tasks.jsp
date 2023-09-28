<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tasks</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="mt-5 d-flex justify-content-between">
			<h2>Bienvenid@, ${usuario.nombre} ${usuario.apellido}</h2>
			<div class="d-flex">
				<form>
					<input type="hidden" name="orden" value="desc">
					<input type="submit" value="Prioridad: Alta-Baja" class="btn btn-info">
				</form>
				<form class="ms-1">
					<input type="hidden" name="orden" value="asc">
					<input type="submit" value="Prioridad: Baja-Alta" class="btn btn-info">
				</form>
				<a class="ms-3 btn btn-danger" href="/logout">Cerrar Sesion</a>
			</div>
		</div>
		<div class="mt-5">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Tarea</th>
						<th>Creador</th>
						<th>Asignado/a</th>
						<th>Prioridad</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tareas}" var="tarea">
						<tr>
							<td><a href="/tasks/${tarea.id}">${tarea.nombreTarea}</a></td>
							<td>${tarea.creador.nombre} ${tarea.creador.apellido}</td>
							<td>${tarea.asignado.nombre} ${tarea.asignado.apellido}</td>
							<c:if test="${tarea.prioridad == 3 }">
								<td>Alta</td>	
							</c:if>
							<c:if test="${tarea.prioridad == 2 }">
								<td>Media</td>	
							</c:if>
							<c:if test="${tarea.prioridad == 1 }">
								<td>Baja</td>	
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="d-flex justify-content-end">
				<a href="/tasks/new" class="btn btn-warning mt-3 ">Crear Tarea</a>
			</div>
		</div>
	</div>
</body>
</html>