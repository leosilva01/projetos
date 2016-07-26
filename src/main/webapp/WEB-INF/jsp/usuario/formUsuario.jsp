<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Apps de ${usuarioLogin}" >
	
	<div class="container col-xs-3">

		<form:form action="${s:mvcUrl('UC#salva').build() }" method="POST" commandName="usuario"> <!-- iniciais de UsuarioController # nome do metodo -->
		
			<label for="name">Nome: </label>
			<form:errors path="nome" />
			<form:input path="nome" class="form-control" />
		
			<label for="name">Email: </label>	 
			<form:errors path="email" />
			<form:input path="email" class="form-control" />
		
			<label	for="name">Login: </label>
			<form:errors path="login" />
			<form:input path="login" class="form-control" />
		
			<label for="name">Senha: </label>
			<form:errors path="senha" />
			<form:password path="senha" class="form-control" />
		
			<div align="center" >
				<form:button class="btn btn-primary">Cadastrar</form:button>
			</div>
			
		</form:form>
	</div>
</tags:pageTemplate>
