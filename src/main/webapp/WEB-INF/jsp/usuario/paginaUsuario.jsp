<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Minha Página">

	<h1><s:message code="paginaUsuario.titulo"/></h1>
	
	<br>
	<h3><s:message code="paginaUsuario.bemVindo" arguments="${usuario.login }"/></h3>
	
	<form:form action="#" commandName="usuario">
				
		<label for="name"><s:message code="paginaUsuario.nome"/></label>
		<form:input path="nome" class="form-control" />
	
		<label for="name"><s:message code="paginaUsuario.login"/></label>	 
		<form:input path="login" class="form-control" disabled="true" />
	
		<label for="name"><s:message code="paginaUsuario.email"/></label>	 
		<form:input path="email" class="form-control" />
	
		<div align="center">
			<form:button class="btn btn-primary"><s:message code="paginaUsuario.salvar"/></form:button>
		</div>
	</form:form>
				
	</tags:pageTemplate>
	