<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<link rel="icon" href="https://static.vecteezy.com/system/resources/thumbnails/004/283/938/small/pm-logo-monogram-emblem-style-with-crown-shape-design-template-free-vector.jpg" type="image/x-icon">
</head>
<body>
	<div class="container">
		<div class="mt-5">
			<div class="d-flex justify-content-between"><h4>Hola ${usuarioEnSesion.nombre}</h4><a href="/logout" class="btn btn-danger">Logout</a></div>
			<h2 class="text-center"><b>Proyectos</b></h2>
			<div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Titulo del Proyecto</th>
							<th>Lider del proyecto</th>
							<th>Fecha de entrega</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${otrosProyectos}" var="op">
							<tr>
								<td>${op.titulo}</td>
								<td>${op.lider.nombre}</td>
								<td>${op.fecha}</td>
								<td><a href="/unir/${op.id}" class="btn btn-primary">Unirme al proyecto</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="mt-5">
			<h2 class="text-center"><b>Mis proyectos</b></h2>
			<div>
				<a href="/crear" class="btn btn-info">Crear un nuevo proyecto</a>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Titulo del Proyecto</th>
							<th>Lider del proyecto</th>
							<th>Fecha de entrega</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${misProyectos}" var="mp">
							<tr>
								<td>${mp.titulo}</td>
								<td>${mp.lider.nombre}</td>
								<td>${mp.fecha}</td>
								<td>
									<c:if test="${mp.lider.id == usuarioEnSesion.id}">
										<a href="/editar/${mp.id}" class="btn btn-warning">Editar</a>
									</c:if>
									<c:if test="${mp.lider.id != usuarioEnSesion.id}">
										<a href="/salir/${mp.id}" class="btn btn-danger">Salir</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
