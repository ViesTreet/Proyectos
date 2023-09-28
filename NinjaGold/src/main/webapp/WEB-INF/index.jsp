<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2 class="row col-12">Tu oro es : ${oro}</h2>
		<div class="row justify-content-center">
			<div class="col border">
				<h3>Granja</h3>
				<p>Ganas 10 - 20 monedas </p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value ="granja">
					<input type="submit" value="Encontrar oro" class="btn btn-success">
				</form>
			</div>
			<div class="col border">
				<h3>Cueva</h3>
				<p>Ganas 5 - 10 monedas </p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value ="cueva">
					<input type="submit" value="Encontrar oro" class="btn btn-info">
				</form>
			</div>
			<div class="col border">
				<h3>Casa</h3>
				<p>Ganas 2 - 5 monedas </p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value ="casa">
					<input type="submit" value="Encontrar oro" class="btn btn-info">
				</form>
			</div>
			<div class="col border">
				<h3>Casino</h3>
				<p>Ganas/Pierdes 0 - 50 monedas </p>
				<form method="post" action="/jugar">
					<input type="hidden" name="lugar" value ="casino">
					<input type="submit" value="Encontrar oro" class="btn btn-danger">
				</form>
			</div>
		</div>
		<div class="row border">
			<h2 class="col-12">Actividades</h2>
			
			<div class="card-body">
				<c:forEach items="${actividades}" var="actividad">
			
					<c:if test="${actividad.contains('ganaste')}">
						<p class="text-success">${actividad}</p>
					</c:if>
					<c:if test="${actividad.contains('perdiste')}">
						<p class="text-danger">${actividad}</p>
					</c:if>
				
				</c:forEach>
			</div>
			
		</div>
	</div>
</body>
</html>
