<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libro Buscado</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-dark text-white">
	<div class="container">
		<h1>Titulo: ${libroBuscado.nombre}</h1>
		<h3>Descripcion: ${libroBuscado.descripcion}</h3>
		<p>lenguaje: ${libroBuscado.lenguaje}</p>
		<p>paginas: ${libroBuscado.paginas} paginas</p>
	
	<div>
		<a href="/editar/${libroBuscado.id}" class="btn btn-success">Editar Libro</a>
		<form action="/borrar/${libroBuscado.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="Eliminar" class="btn btn-danger"> 
		</form>
	</div>
	</div>
</body>
</html>