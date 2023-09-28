<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<div class="col-12 mb-4 text-center"><h1>Dojos Y ninjas</h1></div>
		<div class="d-flex align-items-center justify-content-evenly">
			<a href="/ninja" class="btn btn-primary">Crear un nuevo ninja</a>
			<a href="/dojo" class="btn btn-info">Crear un nuevo dojo</a>
			<c:forEach items="${Dojos}" var="Dojo">
				<a href="/dojo/${Dojo.id}" class="btn btn-success">Ir a ${Dojo.nombredojo}</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>
