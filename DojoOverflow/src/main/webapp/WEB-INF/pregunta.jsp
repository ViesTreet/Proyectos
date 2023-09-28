<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pregunta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${pregunta.contenido}</h1>
		<div>
			<h4>Etiquetas:</h4>
			<c:forEach items="${pregunta.etiquetas}" var="etiqueta">
				<span class="badge bg-secondary">${etiqueta.tema}</span>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-6 mt-3">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Respuestas</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pregunta.respuestas}" var="respuesta">
							<tr>
								<td>${respuesta.texto}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-6">
				<form:form action="/crear" method="POST" modelAttribute="crearRespuesta">
					<form:label path="texto">Pon tu respuesta: </form:label>
					<form:textarea path="texto" class="form-control" placeholder="Escribe aqui tu respuesta"/>
					<form:errors path="texto" class="text-danger"/>
					<form:hidden path="pregunta" value="${pregunta.id}"/>
					<br>
					<input type="submit" value="Guardar" class="btn btn-success">
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
