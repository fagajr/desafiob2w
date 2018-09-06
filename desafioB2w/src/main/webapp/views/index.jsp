<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="projeto">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">

<script src="js/angular.min.js"></script>
<script src="js/angular-resource.min.js"></script>
<script src="js/angular-route.min.js"></script>
<script src="source/app.js"></script>
<script src="source/clientecontroller.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="col-xs-3">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="#/">HOME</a></li>
				<li><a href="#/novo">Novo Planeta</a></li>
				<li><a href="#/listar">Listar Planetas</a></li>
			</ul>
		</div>
		<div class="col-xs-9">
			<div ng-view></div>
		</div>
	</div>
	
</body>
</html>