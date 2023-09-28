<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex justify-content-center flex-wrap ">
		<div class="text-center col-12 mt-5">
			<h2>Introduce el código</h2>
		</div>
		<div>
			<form action="/password" method="POST">
				<div class="d-inline-block">
					<input type="password" name="code" placeholder="introduce el codigo" class="form-control">
				</div>
				<div class="d-flex justify-content-center"><input type="submit" value="enviar" class="btn btn-success"></div>
			</form>
			<p class="text-danger">${errorCodigo}</p>
		</div>
	</div>
</body>
</html>
