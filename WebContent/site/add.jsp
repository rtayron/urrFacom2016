<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>URR - UpaCrs</title>
<link rel="shortcut icon" type="image/png" href="img/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
	<%@include file="/site/menu.jsp"%>
	<div id="main" class="container">
		<h3 class="page-header">Adicionar Item</h3>
		<form action="index.html">
			<div class="row">
				<div class="form-group col-md-4">
					<label for="campo1">Campo Um</label> <input type="text"
						class="form-control" id="campo1">
				</div>

				<div class="form-group col-md-4">
					<label for="campo2">Campo Dois</label> <input type="text"
						class="form-control" id="campo3">
				</div>

				<div class="form-group col-md-4">
					<label for="campo3">Campo Três</label> <input type="text"
						class="form-control" id="campo3">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="index.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<!-- BootStrap Jquery -->
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>