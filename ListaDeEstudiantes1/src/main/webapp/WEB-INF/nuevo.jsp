<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Estudiante</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="/students/new" method="POST">
			<label>Nombre:</label>
			<input type="text" name="nombre" class="form-control"/>
			<br>
			<label>Apellido:</label>
			<input type="text" name="apellido" class="form-control"/>
			<br>
			<label>Edad: </label>
			<input type="number" name="edad" class="form-control"/>
			<br>
			<input type="submit" value="Guardar" class="btn btn-success">
		</form>
	
	</div>
</body>
</html>
