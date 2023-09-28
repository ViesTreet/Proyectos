<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container pb-5">
		<div class="text-center"><h2>Dormitorio de ${dormitorios.nombreDormitorio}</h2></div>
		<div class="mt-2">
			<form action="/asignar" method="POST">
				<input type="hidden" name="_method" value="PUT">
				<label>Asignar Estudiante:</label>
				<select name="estudianteID" class="form-select">
					<c:forEach items="${estudiantes}" var="estudiante">
						<option value="${estudiante.id}">${estudiante.nombre}</option>
					</c:forEach>
				</select>
				<input type="hidden" name="DormitorioID" value="${dormitorios.id}">
				<br>
				<input type="submit" value="Guardar" class="btn btn-success">
			</form>
		</div>
		<div class="mt-3">
			<table  class="table table-hover">
				<thead>
					<tr>
						<th><strong>Nombre</strong></th>
						<th><strong>Accion</strong></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${estudianteEnEsteDormitorio}" var="estudiantes">
						<tr>
							<td>${estudiantes.nombre}</td>
							<td>
								<form action="/quitarDelRoom" method="POST" class="d-flex">
									<input type="hidden" name="_method" value="PUT">
									<input type="hidden" name="EstuId" value="${estudiantes.id}">
									<input type="hidden" name="DormiID" value="${dormitorios.id}">
									<br>
									<input type="submit" value="Sacar" class="btn btn-success">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
