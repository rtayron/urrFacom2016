<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>URR</title>
<link rel="shortcut icon" type="image/png" href="img/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
	<%@include file="/site/menu.jsp"%>
	<div id="main" class="container">
		<div class="row">
			<div class="col-md-4">
				<p>
					<strong>Nome do Campo</strong>
				</p>
				<p>{Valor do Campo}</p>
			</div>
			<div class="col-md-4">
				<p>
					<strong>Nome do Campo</strong>
				</p>
				<p>{Valor do Campo}</p>
			</div>
			<div class="col-md-4">
				<p>
					<strong>Nome do Campo</strong>
				</p>
				<p>{Valor do Campo}</p>
			</div>
		</div>

		<h3 class="page-header">Visualizar Item #0001</h3>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="edit.jsp" class="btn btn-primary">Editar</a> <a
					href="../index.jsp" class="btn btn-default">Fechar</a>
			</div>
		</div>
	</div>
	<!-- BootStrap Jquery -->
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>