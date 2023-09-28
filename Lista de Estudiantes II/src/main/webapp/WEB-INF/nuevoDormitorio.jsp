<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Dormitorio</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container pb-5"> 
		<div class="mt-2"><h1>Crear nuevo dormitorio</h1></div>
		<div class="mt-2">
			<form:form action="/dormitorio" method="POST" modelAttribute="nuevoDormitorio">
				<form:label path="nombreDormitorio">Nombre del dormitorio: </form:label>
				<form:input path="nombreDormitorio" class="form-control"/>
				<form:errors path="nombreDormitorio" class="text-danger"/>
				<br>
				<input type="submit" value="Guardar" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>