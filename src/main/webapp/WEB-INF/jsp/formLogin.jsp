<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Faça seu Login</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
		integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
		crossorigin="anonymous">
		
		<link rel="stylesheet" type="text/css" 
		href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

	<body>
	
	<h1 align="center">Log in!</h1>
		
		<c:url var="loginUrl" value="/login" />
		
		<div align="center" class="container">
			<form:form servletRelativeAction="/login" method="post" class="form-horizontal">
				
				<div class="input-group input-sm col-xs-3" >
					<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
					<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
				</div>
				
				<div class="input-group input-sm col-xs-3">
					<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
					<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
				</div>
			
				<input type="submit" class="btn btn-primary" value="Log in">
					
			</form:form>
		</div>

	</body>
</html>