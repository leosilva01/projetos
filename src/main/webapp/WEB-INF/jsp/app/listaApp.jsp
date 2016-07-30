<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Apps de ${usuarioLogin}" >

	<h3 style="padding-left:30px;"><s:message code="listarApp.titulo" arguments="${usuarioLogin}"/></h3>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th><s:message code="listarApp.cont"/></th>
				<th><s:message code="listarApp.nome"/></th>
				<th><s:message code="listarApp.link"/></th>
				<th><s:message code="listarApp.votos"/></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${apps}" var="app" varStatus="numero">
				<tr>
					<td style="padding-left:30px;">${numero.index}</td>
					<td>${app.nome }</td>
					<td>${app.link }</td>
					<td>${app.qtdReviews }</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</tags:pageTemplate>
	