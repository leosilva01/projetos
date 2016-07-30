<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="titulo" required="true"%>
<%@ attribute name="bodyClass" required="false"%>

<!DOCTYPE html>
<html>
	
<head>
	<title>${titulo}</title>
	<meta charset="utf-8">
	
	<c:url value="/resources" var="cssPath"/>
	
	<link rel="stylesheet" href="${cssPath}/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="${cssPath}/css/style.css">

	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

	<script src="${cssPath}/js/jquery-1.9.1.js"></script>
	
	<script src="${cssPath}/js/bootstrap.min.js"> 	</script>

</head>

<body class="${bodyClass }">

	<%@ include file="/WEB-INF/jsp/header.jsp" %>
	
	
	<jsp:doBody />
	
	
	<%@ include file="/WEB-INF/jsp/footer.jsp" %>

	</body>	  
</html>