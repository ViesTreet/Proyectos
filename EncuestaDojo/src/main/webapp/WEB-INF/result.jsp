<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="text-center"><h2>Info</h2></div>
		<div class="row text-justify border border-dark p-2">
        	<div class="col-12">
            	<p><strong>Nombre:</strong> ${nombre}</p>
        	</div>
        	<div class="col-12">
            	<p><strong>Tu dojo esta en:</strong> ${ubicacion}</p>
        	</div>
        	<div class="col-12">
            	<p><strong>Tu lenguaje favorito es:</strong> ${lenguaje}</p>
        	</div>
        	<div class="col-12">
            	<p><strong>Tu comentario es:</strong> ${comentario}</p>
        	</div>
    	</div>
    </div>
</body>
</html>
