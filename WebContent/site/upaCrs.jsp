<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>URR</title>
<link rel="shortcut icon" type="image/png" href="/URR/img/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="/URR/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/site/menu.jsp" />
	<div id="main" class="container">
		<div id="top" class="row">
			<div class="col-md-3">
				<h2>Upas</h2>
			</div>

			<div class="col-md-6">
				<div class="input-group h2">
					<input name="data[search]" class="form-control" id="search"
						type="text" placeholder="Pesquisar UPA"> <span
						class="input-group-btn">
						<button class="btn btn-primary" type="submit">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>

			<div class="col-md-3">
				<a href="/URR/UpaCrs?logica=adicionar"
					class="btn btn-primary pull-right h2">Cadastrar UPA</a>
			</div>
		</div>
		<!-- /#top -->

		<hr />
		<div id="list" class="row">

			<div class="table-responsive col-md-12">
				<table class="table table-striped" id="lista" cellspacing="0"
					cellpadding="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Endereço</th>
							<th>Telefone</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="upaCrs" items="${upas}" varStatus="id">
							<tr>
								<td>${id.count}</td>
								<td>${upaCrs.endereco}</td>
								<td>${upaCrs.telefone}</td>
								<td class="actions">
								<a class="btn btn-success btn-xs" href="view.html">Visualizar</a> 
								<a class="btn btn-warning btn-xs" href="edit.html">Editar</a> 
								<a class="btn btn-danger btn-xs" href="#" data-id="${id.count}"  data-toggle="modal" data-target="#delete-modal">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

</div>


		<h3 class="page-header">Lista de Upas Crs</h3>



<!-- Modal -->
<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalLabel">Excluir Item</h4>
            </div>
            <div class="modal-body">Deseja realmente excluir este item? </div>
            <div class="modal-footer">
                <button type="button" id="exluirItem" class="btn btn-primary">Sim</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
            </div>
        </div>
    </div>
</div>



		<!-- BootStrap Jquery -->
		<script type="text/javascript" src="/URR/js/jquery.js"></script>
		<script type="text/javascript" src="/URR/js/bootstrap.min.js"></script>
		<script type="text/javascript">

			$("#exluirItem").click(function() {
				$.post("/URR/UpaCrs", {
					logica : "remove",
					id : 1 //passar id
				}, function(data, status) {
					$('#delete-modal').modal('hide');
				});
			});
		</script>
</body>
</html>