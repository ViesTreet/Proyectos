<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Musica Encontrada</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
	
	<header class="d-flex justify-content-between mt-2 col-12 mb-5">
		<div class="d-flex col-3">
		<a href="/dashboard" class="btn btn-info">Volver a dashboard</a>
		</div>
		<form action="/search" method="POST" class="d-flex col-4">
			<input type="text" name="autor" class="form-control" placeholder="escribe el nombre del autor">
			<input type="submit" value="Buscar Artista" class="btn btn-primary">
		
		</form>
	</header>
	<main class="mt-2">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Autor</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${top10}" var="topTen">
				<tr>
					<td><a href="/songs/${topTen.id}">${topTen.nombre}</a></td>
					<td>${topTen.autor}</td>
					<td>${topTen.calificacion}</td>
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
	
	</main>
	</div>
</body>
</html>