<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="text-center"><h2>Encuesta</h2></div>
		<form action="/encuesta" method="POST">
			<div>
				<label for="nombreId">Tu nombre: </label>
				<input id="nombreId" type="text" name="nombre" placeholder="Pon tu nombre" >
			</div>
			<div>
				<label for="ubicacion">Ubicación de tu dojo: </label>
        		<select id="ubicacion" name="ubicacion">
            		<option value="San Jose">San Jose</option>
            		<option value="New York">New York</option>
            		<option value="Mexico City">Mexico City</option>
        		</select>
			</div>
			<div>
				<label for="lenguaje">lenguaje de programacion favorito: </label>
        		<select id="lenguaje" name="lenguajeP">
            		<option value="Python">Python</option>
            		<option value="Java">Java</option>
            		<option value="Html">Html</option>
        		</select>
			</div>
			<div>
				<label>Deja un comentario: </label>
				<textarea name="comentario" rows="10" cols="10" placeholder="deja tu comentario aqui" class="form-control"></textarea>
			</div>
			
			<input type="submit" value="Enviar" class="btn btn-success">
		</form>
		<div class="text-center text-danger"><p>${Error}</p></div>
	</div>
</body>
</html>
