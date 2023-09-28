<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar lenguaje</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>${lenguaje.nombre}</h2>
	
		<div class="mt-5"><h4>${lenguaje.creador}</h4></div>
		<div class="mt-5"><h5>${lenguaje.version}</h5></div>
		<div class="mt-5"><a href="/languages/${lenguaje.id}/edit" class="btn btn-warning">Editar</a></div>
		<div>
			<form action="/languages/${lenguaje.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE">
				<input type="submit" value="Eliminar" class="btn btn-danger"> 
			</form>
		</div>
	</div>
</body>
</html>
