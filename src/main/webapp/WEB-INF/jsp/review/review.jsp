<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Dar Review">
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th><s:message code="review.cont"/></th>
				<th><s:message code="review.nome"/></th>
				<th><s:message code="review.darReview"/></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${apps}" var="app" varStatus="contador">
				<tr>
					<td>${contador.index}</td>
					<td>${app.nome }</td>
					<td><a href="${s:mvcUrl('RC#darReview').arg(0,app.id).build() }" class = "btn btn-primary">
						<s:message code="review.review"/></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</tags:pageTemplate>
