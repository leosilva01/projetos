<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Add App">

	<div class="container col-xs-3" align="center">

		<form:form action="${s:mvcUrl('AC#salva').build() }" method="POST" commandName="app">
		
			<label for="name">
				<s:message code="formApp.nome"/></label>
			<form:errors path="nome"/>
			<form:input path="nome" class="form-control" />
		
			<label for="name">
				<s:message code="formApp.link"/></label>	 
			<form:errors path="link"/>
			<form:input path="link" class="form-control" />
		
			<div align="center">
				<form:button class="btn btn-primary">
					<s:message code="formApp.cadastrar"/></form:button>
			</div>
		</form:form>
	</div>
		
</tags:pageTemplate>