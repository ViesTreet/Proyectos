<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lenguajes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th class="text-center">Lenguaje</th>
				<th class="text-center">Creador</th>
				<th class="text-center">Version</th>
				<th class="text-center">Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lenguajes}" var="lenguaje">
				<tr>
					<td><a href="/languages/${lenguaje.id}">${lenguaje.nombre}</a></td>
					<td>${lenguaje.creador}</td>
					<td>${lenguaje.version}</td>
					<td class="d-flex justify-content-center"><a href="/languages/${lenguaje.id}/edit" class="btn btn-warning">Editar</a>
					
					<form action="/languages/${lenguaje.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" value="Eliminar" class="btn btn-danger"> 
					</form>
					</td>
				</tr>
			
			</c:forEach>
		
		</tbody>
	</table>

	<div class="mt-5 pt-5">
		<div><h3>Crear nuevo lenguaje</h3></div>
		<div>
			<form:form action="/languages" method="POST" modelAttribute="lenguaje">
				<form:label path="nombre">Nombre del lenguaje: </form:label>
				<form:input path="nombre" class="form-control"/>
				<form:errors path="nombre" class="text-danger"/>
				
				<form:label path="creador">Nombre del creador:  </form:label>
				<form:input path="creador" class="form-control"/>
				<form:errors path="creador" class="text-danger"/>
				
				<form:label path="version">Version: </form:label>
				<form:input path="version" class="form-control"/>
				<form:errors path="version" class="text-danger"/>
				
				<input type="submit" value="Enviar" class="btn btn-success"/>
			
			</form:form>
		
		
		</div>
	</div>
  	</div>
</body>
</html>
