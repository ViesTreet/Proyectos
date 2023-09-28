<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Students</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container pb-5">
		<div class="text-center mb-5">
			<h1>Lista de todos los estudiantes</h1>
		</div>
		<div class="mt-2">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><strong>Nombre :</strong></th>
						<th><strong>Edad :</strong></th>
						<th><strong>Direccion :</strong></th>
						<th><strong>Ciudad :</strong></th>
						<th><strong>Region :</strong></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${estudiantes}" var="estudiante">
						<tr>
							<td>${estudiante.nombre} ${estudiante.apellido}</td>
							<td>${estudiante.edad}</td>
							<td>${estudiante.contacto.direccion}</td>
							<td>${estudiante.contacto.ciudad}</td>
							<td>${estudiante.contacto.region}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="mt-5 d-flex justify-content-evenly">
			<a href="/students/new" class="btn btn-info">Nuevo Estudiante</a>
			<a href="/contact/new" class="btn btn-warning">Nuevo Contacto</a>
		</div>
	</div>
</body>
</html>
