
<nav role="navigation" class="navbar navbar-default">

	<div class="navbar-header">
		<button type="button" data-target="#navbarCollapse"
			data-toggle="collapse" class="navbar-toggle">
			<span class="sr-only">Menu Principal</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="/URR/" class="navbar-brand">URR</a>
	</div>

	<div id="navbarCollapse" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/URR/UpaCrs">UpaCrs</a></li>
			<li><a href="/URR/">Plantonista</a></li>
			<li><a href="/URR/">Paciente</a></li>
			<li><a href="/URR/">Notificações</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Relatórios <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Notificações por tipo</a></li>
					<li><a href="#">Relatório Quantitativo</a></li>
					<li><a href="#">Relatório de Notificação por UpaCrs</a></li>
				</ul></li>
		</ul>
		 <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="./">Adicionar Notificação<span class="sr-only">(current)</span></a></li>
          </ul>
	</div>

</nav>

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
                <button type="button" class="btn btn-primary">Sim</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
            </div>
        </div>
    </div>
</div>
