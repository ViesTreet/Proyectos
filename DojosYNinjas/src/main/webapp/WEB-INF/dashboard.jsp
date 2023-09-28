<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Edad</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${DojoBuscado.ninjas}" var="ninja">
					<tr>
						<td>${ninja.nombre}</td>
						<td>${ninja.apellido}</td>
						<td>${ninja.edad}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
