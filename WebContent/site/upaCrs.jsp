<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>URR</title>
<link rel="shortcut icon" type="image/png" href="img/favicon.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<c:import url="/site/menu.jsp"/>
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
				<a href="/URR/UpaCrs?logica=adicionar" class="btn btn-primary pull-right h2">Cadastrar UPA</a>
			</div>
		</div>
		<!-- /#top -->

		<hr />
		<div id="list" class="row">
 
    <div class="table-responsive col-md-12">
        <table class="table table-striped" cellspacing="0" cellpadding="0">
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
                        <a class="btn btn-danger btn-xs"  href="#" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                    </td>
                </tr>
 			</c:forEach>
            </tbody>
         </table>
 
     </div>
 </div>
<div id="bottom" class="row">
    <div class="col-md-12">
         
        <ul class="pagination">
            <li class="disabled"><a>&lt; Anterior</a></li>
            <li class="disabled"><a>1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
        </ul><!-- /.pagination -->
 
    </div>
	</div>
		<h3 class="page-header">Lista de Upas Crs</h3>
	</div>


	<!-- BootStrap Jquery -->
	<script type="text/javascript" src="/URR/js/jquery.js"></script>
	<script type="text/javascript" src="/URR/js/bootstrap.min.js"></script>
</body>


</html>