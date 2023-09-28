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
			<form:form action="/ninja" method="POST" modelAttribute="nuevoNinja">
				<form:label path="dojo">Lista de dojos :</form:label>
				<form:select path="dojo" class="form-select">
					<c:forEach items="${Dojos}" var="dojo">
						<form:option value="${dojo.id}">${dojo.nombredojo}</form:option>
					</c:forEach>
				</form:select>
				<br>
				<form:label path="nombre">Nombre del Ninja :</form:label>
				<form:input path="nombre" class="form-control"/>
				<form:errors path="nombre" class="text-danger"/>
				<br>
				<form:label path="apellido">Apellido del Ninja :</form:label>
				<form:input path="apellido" class="form-control"/>
				<form:errors path="apellido" class="text-danger"/>
				<br>
				<form:label path="edad">Edad del Ninja :</form:label>
				<form:input type ="number" path="edad" class="form-control"/>
				<form:errors path="edad" class="text-danger"/>
				<br>
				<input type="submit" value="Guardar Ninja" class="btn btn-success">
			</form:form>
		</div>
	</div>
</body>
</html>
