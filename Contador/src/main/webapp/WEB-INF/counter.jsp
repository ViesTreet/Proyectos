<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Contador</title>
</head>
<body>
	<div class="container">
	<div>
		<h2>Estamos en la pagina contador la hemos visitado ${contador} veces</h2>
		<a href="/" class="btn btn-info"> Regresar al inicio</a>
		<a href="/reset" class="btn btn-danger"> Reset</a>
	</div>
	</div>
</body>
</html>