<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Libro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body class="bg-dark text-white">
	<div class="container">
		<h1>Editar Libro</h1>
	
	<form:form action="/libros/${libro.id}" method="post" modelAttribute="libro">
		<input type="hidden" name="_method" value="put"/>
    	<label for="nombre">Nombre:</label>
    	<form:input path="nombre" id="nombre" class="form-control"/>
    	<form:errors path="nombre" cssClass="error"/>

    	<br/>

    	<label for="descripcion">Descripción:</label>
    	<form:textarea path="descripcion" id="descripcion" rows="4" cols="50" class="form-control"/>
    	<form:errors path="descripcion" cssClass="error"/>

    	<br/>

    	<label for="lenguaje">Lenguaje:</label>
    	<form:input path="lenguaje" id="lenguaje" class="form-control"/>
    	<form:errors path="lenguaje" cssClass="error"/>

    	<br/>

    	<label for="paginas">Cantidad de Páginas:</label>
    	<form:input path="paginas" id="paginas" class="form-control"/>
    	<form:errors path="paginas" cssClass="error"/>

    	<br/>

    	<input type="submit" value="Guardar Cambios" class="btn btn-success"/>
	</form:form>
	</div>

</body>
</html>
