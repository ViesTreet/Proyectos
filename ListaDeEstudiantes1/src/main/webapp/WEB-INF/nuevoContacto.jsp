<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Contacto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/contact/new" method="POST" modelAttribute="nuevoContacto">
			<form:label path="estudiante">Estudiantes</form:label>
			<form:select path="estudiante" class="form-select">
				<c:forEach items="${estudiantes}" var="estudiante">
					<form:option value="${estudiante.id}">${estudiante.nombre} ${estudiante.apellido}</form:option>
				</c:forEach>
			</form:select>
			<br>
			<form:label path="direccion">Direccion: </form:label>
			<form:input path="direccion" class="form-control"/>
			<form:errors path="direccion" class="text-danger"/>
			<br>
			<form:label path="ciudad">Ciudad: </form:label>
			<form:input path="ciudad" class="form-control"/>
			<form:errors path="ciudad" class="text-danger"/>
			<br>
			<form:label path="region">Region: </form:label>
			<form:input path="region" class="form-control"/>
			<form:errors path="region" class="text-danger"/>
			<br>
			<input type="submit" value="Guarda" class="btn btn-success">
		</form:form>
	
	</div>
</body>
</html>
