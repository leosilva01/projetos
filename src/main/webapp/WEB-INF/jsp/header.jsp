<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<security:authentication property="principal" var="usuarioLogado"/>
	
	<nav class="navbar-default navbar-static-top">
	  <div class="container-fluid">
	  
	    <div class="navbar-header active	">
	    	<a class="navbar-brand" href="${s:mvcUrl('IC#index').build() }">Reviews</a>
	    </div>
	    
	    <ul class="nav navbar-nav">
	    
	    <security:authorize access="isAuthenticated()" >
	    
	    	<li><a href="${s:mvcUrl('AC#formApp').build() }"><i class="fa fa-plus fa-fw fa-lg" aria-hidden="true" style="color:#00B16A"></i>Add new app</a></li>
	    
	    	<li><a href="${s:mvcUrl('AC#listar').build() }"><i class="fa fa-mobile fa-fw fa-lg" aria-hidden="true"></i>My apps</a></li>

	    	<li><a href="${s:mvcUrl('RC#review').build() }"><i class="fa fa-star fa-fw fa-lg" aria-hidden="true"></i>Give reviews</a></li>

	    	<li><a href="${s:mvcUrl('UC#listar').build() }"><i class="fa fa-list fa-fw fa-lg" aria-hidden="true"></i>List users</a></li>
	    	
	        <li><a href="${s:mvcUrl('UC#detalhe').build() }"><i class="fa fa-cog fa-fw fa-lg" aria-hidden="true"></i>My account</a></li>
	    	
	    </security:authorize>
	      
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="#">Page 1-1</a></li>
	        	<li><a href="#">Page 1-2</a></li>
	        	<li><a href="#">Page 1-3</a></li>
	        </ul>
	      </li>
	    </ul>
	    
	    <ul class="nav navbar-nav navbar-right">
	    
	    <security:authorize access="isAnonymous()">
	    	<li><a href="${s:mvcUrl('UC#formUsuario').build() }"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	    	<li><a href="${s:mvcUrl('LC#formLogin').build() }"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </security:authorize>
	    
	    <security:authorize access="isAuthenticated()">
	    	<li><a href="${s:mvcUrl('UC#detalhe').build() }">${usuarioLogado.username }</a></li>
	    	
	    	<li><a href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </security:authorize>
	    
	    </ul>
	  </div>
	</nav>
