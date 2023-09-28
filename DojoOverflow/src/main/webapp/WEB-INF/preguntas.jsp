<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Preguntas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="pt-5">
				<h1 class="col-12 text-center">Preguntas</h1>
				<a href="preguntas/nueva" class="btn btn-info">Hacer una pregunta</a>
			<div >
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="text-center"><strong>Preguntas</strong></th>
							<th class="text-center"><strong>Etiquetas</strong></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${preguntas}" var="pregunta">
							<tr>
								<td><a href="/preguntas/${pregunta.id}">${pregunta.contenido}</a></td>
								<c:forEach items="${pregunta.etiquetas}" var="etiqueta">
									<td><span class="badge bg-secondary">${etiqueta.tema}</span></td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
