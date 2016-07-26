<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Usuários Cadastrados">
	
	<h3><s:message code="listarUsuario.titulo"/></h3>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th><s:message code="listarUsuario.cont"/></th>
				<th><s:message code="listarUsuario.nome"/></th>
				<th><s:message code="listarUsuario.email"/></th>
				<th><s:message code="listarUsuario.login"/></th>
				<th><s:message code="listarUsuario.pontos"/></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${usuarios}" var="usuario" varStatus="numero">
				<tr>
					<td>${numero.index}</td>
					<td>${usuario.nome }</td>
					<td>${usuario.email }</td>
					<td>${usuario.login }</td>
					<td>${usuario.pontos }</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</tags:pageTemplate>
