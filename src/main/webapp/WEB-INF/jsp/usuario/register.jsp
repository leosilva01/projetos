<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, minimum-scale=1, user-scalable=no">
		<title>Mobile Reviews - Login</title>

		<c:url value="/resources" var="cssPath"/>
		<link rel='stylesheet' href='${cssPath}/css/style.css'>
		<link rel='stylesheet' href='${cssPath}/css/bootstrap.min.css'>

		<style type="text/css">
		
		html { 
		  background: url(${cssPath}/img/register-bg1.jpg) no-repeat center center fixed; 
		  -webkit-background-size: cover;
		  -moz-background-size: cover;
		  -o-background-size: cover;
		  background-size: cover;
		}

		body {
 		 background: transparent; !important;
		}

		.wrapper {
		  margin-top: 120px;
		  margin-bottom: 80px;
		}

		.form-signin {
		  max-width: 380px;
		  padding: 15px 35px 45px;
		  margin: 0 auto;
		  background-color: #fff;
		  border: 1px solid rgba(0, 0, 0, 0.1);
		  border-radius: 10px 10px 10px 10px;
		  opacity: .9;
		}
		.form-signin .form-signin-heading,
		.form-signin .checkbox {
		  margin-bottom: 30px;
		  text-align: center;
	      padding: 0;
	      margin-bottom: 15px;
	      font-family: 'SF-Regular', sans-serif;
	      font-size: 18px;
	      color: #111111;
		}
		.form-signin .checkbox {
		  font-weight: normal;
		  font-size: 15px;
		  text-align: right;

		}
		.form-signin .form-control {
		  position: relative;
		  font-size: 16px;
		  height: auto;
		  padding: 10px;
		  -webkit-box-sizing: border-box;
		  -moz-box-sizing: border-box;
		  box-sizing: border-box;
		}
		.form-signin .form-control:focus {
		  z-index: 2;
		}
		.form-signin input[type="text"] {
		  margin-bottom: -1px;
		  border-bottom-left-radius: 0;
		  border-bottom-right-radius: 0;
		}
		.form-signin input[type="password"] {
		  margin-bottom: 20px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}

		.btn-login {
			background-color: #0084fd;
		    color: rgba(255,255,255,1);
		    border: 0px solid #800000;
		    padding: 7px 20px;
		    font-family: SF-Regular;
		    font-size: 15px;
		    width: 100%;
		}

		.btn-login:hover {
    		background-color: #136CE4;
		}

		.form-signin-terms {
		  margin-bottom: 30px;
		  text-align: left;
	      padding: 0;
	      margin-bottom: 15px;
	      font-family: 'SF-Regular', sans-serif;
	      font-size: 14px;
	      color: #111111;
		}




		</style>

	</head>
	</head>
	</head>
	<body>

		<div class="wrapper">
	    <form:form action="${s:mvcUrl('UC#salva').build() }" method="POST" commandName="usuario" class="form-signin"> <!-- iniciais de UsuarioController # nome do metodo -->
		
	    
	      <h2 class="form-signin-heading">Register</h2>
	      
			<form:errors path="nome" />
			<form:input path="nome" class="form-control" placeholder="Full Name" required=""/>		
	      
			<form:errors path="email" />
			<form:input path="email" class="form-control" placeholder="Email Address" required="" />
	      
			<form:errors path="login" />
			<form:input path="login" class="form-control" placeholder="Login" required="" />
		
			<form:errors path="senha" />
			<form:password path="senha" class="form-control" placeholder="Password" required=""/>
		
	      
	      <label class="checkbox">
	        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Subscribe to the newsletter
	      </label>
	      
	      <form:button class="btn-login">Sign Up</form:button>
	      
	      <a href="${s:mvcUrl('LC#formLogin').build() }">Already have an account? Login here.</a>
	      
	      <br><br>
	      
	      <div class="form-signin-terms">By Signing Up you agree with our <a href="terms.html">terms and conditions</a>.</div>
	    </form:form>
  		</div>
	</body>

</html>