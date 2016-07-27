<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<security:authentication property="principal" var="usuarioLogado"/>
	
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	  
	    <div class="navbar-header active">
	    	<a class="navbar-brand" href="${s:mvcUrl('IC#index').build() }">
	    		<s:message code="menu.reviews"/></a>
	    </div>
	    
	    <ul class="nav navbar-nav">
	    
	    <security:authorize access="isAuthenticated()" >
	    	
			<li><a href="${s:mvcUrl('UC#detalhe').build() }"><i class="fa fa-plus fa-fw fa-lg" aria-hidden="true" style="color:#00B16A"></i>
				<s:message code="menu.minhaPagina"/></a></li>
	    
	    	<li><a href="${s:mvcUrl('AC#listar').build() }">
				<s:message code="menu.listarMeusApps"/></a></li>

	    	<li><a href="${s:mvcUrl('AC#formApp').build() }">
				<s:message code="menu.addApp"/></a></li>

	    	<li><a href="${s:mvcUrl('UC#listar').build() }">
				<s:message code="menu.listarUsuarios"/></a></li>

	    	<li><a href="${s:mvcUrl('RC#review').build() }">
				<s:message code="menu.listarAppParaReview"/></a></li>
			
	    </security:authorize>
	      
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
								<s:message code="menu.idioma"/><span class="caret"></span></a>
				
				<ul class="dropdown-menu">
					
					<li> <a href="?locale=pt_BR">
						<s:message code="menu.idioma.pt"/></a></li>
						
					<li><a href="?locale=en_US">
						<s:message code="menu.idioma.en"/></a></li>
				</ul>
	      	</li>
	      
			
	      
	    </ul>
	    
	    <ul class="nav navbar-nav navbar-right">
	    
	    <security:authorize access="isAnonymous()">
	    	<li><a href="${s:mvcUrl('UC#formUsuario').build() }"><span class="glyphicon glyphicon-user"></span>
				<s:message code="menu.signIn"/></a></li>
	    	<li><a href="${s:mvcUrl('LC#formLogin').build() }"><span class="glyphicon glyphicon-log-in"></span>
				<s:message code="menu.signUp"/></a></li>
	    </security:authorize>
	    
	    <security:authorize access="isAuthenticated()">
	    	<li><a href="${s:mvcUrl('UC#detalhe').build() }">${usuarioLogado.username }</a></li>
	    	
	    	<li><a href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-out"></span>
	    		<s:message code="menu.Logout"/></a></li>
	    </security:authorize>
	    
	    </ul>
	  </div>
	</nav>
