<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Minha Página">

	<h3 style="padding-left:30px;"><s:message code="paginaUsuario.titulo"/></h3>
	
	<br>
	<h4 style="padding-left:30px;"><s:message code="paginaUsuario.bemVindo" arguments="${usuario.login }"/></h4>
	
	<div class="col-xs-4">
	<form:form action="#" commandName="usuario" style="padding-left:30px; padding-right:30px; col-xs-2; ">
				
		<label for="name"><s:message code="paginaUsuario.nome"/></label>
		<form:input path="nome" class="form-control" />
		<br>
		<label for="name"><s:message code="paginaUsuario.login"/></label>	 
		<form:input path="login" class="form-control" disabled="true" />
		<br>
		<label for="name"><s:message code="paginaUsuario.email"/></label>	 
		<form:input path="email" class="form-control" />
		<br>
		<div align="left">
			<form:button id="signup-bt"><s:message code="paginaUsuario.salvar"/></form:button>
		</div>
	</form:form>
	</div>
				
	</tags:pageTemplate>
	