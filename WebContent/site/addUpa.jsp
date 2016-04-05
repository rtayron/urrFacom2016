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
<link rel="stylesheet" type="text/css" href="/URR/css/bootstrap.min.css">
</head>
<body>
	<%@include file="/site/menu.jsp"%>
	<div id="main" class="container">
		<h3 class="page-header">Adicionar Upa Crs</h3>
		<form action="/URR/UpaCrs?logica=salvar">
			<div class="row">
				<div class="form-group col-md-6">
					<label for="endereco">Endereço</label> 
					<input type="text" class="form-control" id="endereco">
				</div>

				<div class="form-group col-md-2">
					<label for="telefone">Telefone</label>
					<input type="text" class="form-control" id="telefone" >
				</div>

			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="/URR/UpaCrs" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<!-- BootStrap Jquery -->
	<script type="text/javascript" src="/URR/js/jquery.js"></script>
	<script type="text/javascript" src="/URR/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/URR/js/jquery.mask.min.js"></script>
	<script type="text/javascript">
	$('#telefone').focus(function(){
		$('#telefone').mask("(99) 9999-9999");
	})
	
	</script>
</body>
</html>