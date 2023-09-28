<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Lenguaje</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/languages/${lenguaje.id}" method="post" modelAttribute="lenguaje">
		<input type="hidden" name="_method" value="put"/>
    	<form:label path="nombre">Nombre del lenguaje: </form:label>
    	<form:input path="nombre" class="form-control"/>
    	<form:errors path="nombre" cssClass="error"/>

    	<br/>

    	<form:label path="creador">Nombre del creador: </form:label>
    	<form:input path="creador" class="form-control"/>
    	<form:errors path="creador" cssClass="error"/>

    	<br/>

    	<form:label path="version">Version: </form:label>
    	<form:input path="version" class="form-control"/>
    	<form:errors path="version" cssClass="error"/>

    	<br/>

    	<input type="submit" value="Guardar Cambios" class="btn btn-success"/>
	</form:form>
	
	</div>
</body>
</html>
