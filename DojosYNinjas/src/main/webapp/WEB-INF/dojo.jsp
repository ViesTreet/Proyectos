<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear nuevo dojo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div>
			<form:form action="/dojo" method="POST" modelAttribute="nuevoDojo">
				<form:label path="nombredojo">Nombre del Dojo:</form:label>
				<form:input path="nombredojo" class="form-control"/>
				<form:errors path="nombredojo" class="text-danger"/>
				<br>
				<input type="submit" value="Guardar Dojo" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>
