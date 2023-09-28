<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${musica.nombre}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5 pb-5">
		<div class="d-flex col-12 mb-3">
			<h5 class="col-4">Nombre :</h5>
			<h5>${musica.nombre}</h5>
		</div>
		<div class="d-flex col-12 mb-3">
			<h5 class="col-4">Autor :</h5>
			<h5>${musica.autor}</h5>
		</div>
		<div class="d-flex col-12 mb-3">
			<h5 class="col-4">Rating :</h5>
			<h5>${musica.calificacion}</h5>
		</div>
		<form action="/borrar/${musica.id}" method="POST">
			<input type="hidden" name="_method" value="DELETE">
			<input type="submit" value="Eliminar" class="btn btn-danger"> 
		</form>
		</div>
</body>
</html>
