<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Add App">

	<br>
	  <div class="col-xs-4">

		<form:form action="${s:mvcUrl('AC#salva').build() }" method="POST" commandName="app" style="padding-left:30px; padding-right:30px; col-xs-2; ">
		
			<label for="name">
				<s:message code="formApp.nome"/></label>
			<form:errors path="nome"/>
			<form:input path="nome" class="form-control" />
		
			<label for="name">
				<s:message code="formApp.link"/></label>	 
			<form:errors path="link"/>
			<form:input path="link" class="form-control" />
			
			<br>
			<div align="left">
				<form:button id="signup-bt">
					<s:message code="formApp.cadastrar"/></form:button>
			</div>
		</form:form>
	</div>
		
</tags:pageTemplate>