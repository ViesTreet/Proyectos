<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container" onclick="home()">
		<div class="text-center"><h1>Home</h1></div>
		<div class="d-flex justify-content-evenly mt-5"><a href="/date" class="btn btn-danger">Fecha</a>
		<a href="/time" class="btn btn-warning">Hora</a>
		</div>
		
		
	
	
	</div>
	
	<script>
        document.addEventListener("DOMContentLoaded", function() {
            alert("Estas en inicio");
        });
    </script>
</body>
</html>
