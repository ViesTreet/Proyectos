<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Libros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-dark text-white">
	<div class="container">
		<div class="text-center"><h1>Lista de libros</h1></div>
		<div>
			<table class="table table-dark table-hover">
			<thead>
				
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Lenguaje</th>
					<th>Paginas</th>
					<th>Acciones</th>
				</tr>
				
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="libro">
				<tr>
					<td>${libro.nombre}</td>
					<td>${libro.descripcion}</td>
					<td>${libro.lenguaje}</td>
					<td>${libro.paginas} paginas</td>
					<td><a href="/mostrar/${libro.id}" class="btn btn-info">Mostrar</a>	
					</td>
					
				
				</tr>
				</c:forEach>
			
			</tbody>
		</table>
		
		</div>
	</div>
</body>
</html>
