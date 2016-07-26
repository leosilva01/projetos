<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, minimum-scale=1, user-scalable=no">
		<title>Mobile Reviews</title>
		
		<c:url value="/resources" var="cssPath"/>
		<link rel="stylesheet" href="${cssPath}/css/style.css">
		<link rel='stylesheet' href='${cssPath}/css/onepage-scroll.css'>
		<link rel='stylesheet' href='${cssPath}/css/scroller.css'>
		<link rel='stylesheet' href='${cssPath}/css/bootstrap.min.css'>

		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${cssPath}/js/jquery.onepage-scroll.js"></script>
		<script type="text/javascript" src="${cssPath}/js/script.js"></script>
		<script type="text/javascript" src="${cssPath}/js/typed.js"></script>
		
		<script>
    		$(function(){
        		$(".element").typed({
            		strings: ["More Reviews.", "More Downloads.", "More Revenue.", "a Better App Business."],
            		typeSpeed: 20
        		});
    		});
		</script>

		<script>
		  $(document).ready(function(){
	      $(".main").onepage_scroll({
	        sectionContainer: "section",
	        responsiveFallback: 600,
	        loop: false
	      });
			});	
		</script>


	</head>
	<body>

		<nav class="nav-bar">
  			<span id="logo">
                <h4>Mobile Reviews</h4>
             </span>

             <ul>
		        <li><a href="#" onclick="$('.pageScroll').moveTo(1)">HOME</a></li>
		        <li><a href="#" onclick="$('.pageScroll').moveTo(2)">HOW IT WORKS</a></li>
		        <li><a href="#" onclick="$('.pageScroll').moveTo(3)">PRICING</a></li>
		        <li><a href="#" onclick="$('.pageScroll').moveTo(4)">FAQ</a></li>
		        <li><a href="#" onclick="$('.pageScroll').moveTo(5)">CONTACT US</a></li>
		     </ul>

			<security:authorize access="isAnonymous()" >

             <span id="signin-span">
	                <button id="signin-bt" onclick="window.location.href='${s:mvcUrl('UC#detalhe').build() }'">Sign In</button>
             </span>

		     <span id="signup-span">
	                <button id="signup-bt" onclick="window.location.href='${s:mvcUrl('UC#formUsuario').build() }'">Sign Up</button>
             </span>

			</security:authorize>
			
			<security:authorize access="isAuthenticated()" >
				<security:authentication property="principal" var="usuarioLogado"/>
				
				<span id="signin-span">
		                <button id="signin-bt" onclick="window.location.href='${s:mvcUrl('UC#detalhe').build() }'">Minha Página</button>
	             </span>
	             
	             <span id="signup-span">
					<button id="signin-bt" onclick="window.location.href='<c:url value='/logout' />'">Logout</button>
	             </span>
			</security:authorize>


		</nav>



		<div class="main">
			<section class="page1">


				<div class="page_container">

					<div align="center">
						
						<h2>Get <span class="element"></span></h2>
						<br>
						<button class="button" href="#" onclick="$('.pageScroll').moveTo(2)">See How</button>
					</div>

						
				</div>
			</section>

			<section class="page2">
		     	<div class="page_container">
	     		<table width="100%" border="0">
						<tbody>
						<tr>
							<td width="50%" rowspan="6">
								<img src="${cssPath}/img/iPhone-5C.png" alt="Exchange Reviews!" height="800">
							</td>
						</tr>
						<tr>

							<td width="50%" colspan="3" height="90px" valign="top">

								<h1>How does it work?</h1>
								
							</td>
						</tr>
						<tr>

							<td width="16%" height="90px" valign="top">
								<img src="${cssPath}/img/Comments-100.png" alt="Give a Review" width="60">
							</td>
							<td width="18%" height="90px" valign="top">
								<img src="${cssPath}/img/Rating Filled-100.png" alt="Receive a Review" width="60">
							</td>
							<td width="16%" valign="top">
								<img src="${cssPath}/img/Line Chart Filled-100.png" alt="Rank Higher" width="60">
							</td>
							
						</tr>

						<tr>

							<td valign="top" height="90px">
								<h4>1. Give an Honest Review</h4>
							</td>

							
							<td valign="top" height="90px">
								<h4>2. Receive a Review</h4>
							</td>


							<td valign="top" height="90px">
								<h4>3. Rank Higher in the Appstores</h4>
							</td>
						</tr>

						<tr>
							<td width="50%" colspan="3" valign="top" height="70px">

								<h1>It's simple as that!</h1>

							</td>
						</tr>

						<tr>
							<td width="50%" valign="top" colspan="3">

								<button class="button2">Sign Up for Free</button>
								<br><br><br>
								<h5><a href="#" onclick="$('.pageScroll').moveTo(3)">Or... Continue scrolling down and learn more.</a></h5>

							</td>

						</tr>

						<tr>
							<td width="50%" valign="top" colspan="3">



							</td>

						</tr>

						</tbody>
					</table>	
		     	

				</div>
      		</section>

			<section class="page3">
		     	<div class="page_container">

		     		<h1>Our Plans</h1>

					<div class="sm-pricing__plans">
 
						<div class="sm-pricing__plan sm-pricing__plan_first">
							<h2 class="sm-pricing__plan-title sm-pricing__plan-title_starter sm-pricing__plan-title_first">
								Starter
							</h2>
							<div class="sm-pricing__plan-price -monthly">
								<span class="sm-pricing__plan-price-value">Free</span>
							</div>

							<a href="https://app.splitmetrics.com/signup?ss=pricing_249plan&plan=3" class="sm-pricing__plan-cta -monthly">Sign up</a>

							<ul class="sm-pricing__plan-benefits hidden-sm">
								<li class="sm-pricing__plan-benefits-item">3 apps</li>
								<li class="sm-pricing__plan-benefits-item">Android and iOS support</li>
								<li class="sm-pricing__plan-benefits-item">Access to the best review community</li>
							</ul>
						</div>
 
 
						<div class="sm-pricing__plan sm-pricing__plan_last">
							<h2 class="sm-pricing__plan-title sm-pricing__plan-title_pro">
								Premium
							</h2>
							<div class="sm-pricing__plan-price -monthly">
								<span class="sm-pricing__plan-price-value">$19.90</span> / mo
							</div>

							<a href="https://app.splitmetrics.com/signup?ss=pricing_990plan&plan=4" class="sm-pricing__plan-cta -monthly">Sign up</a>

							<ul class="sm-pricing__plan-benefits hidden-sm">
								<li class="sm-pricing__plan-benefits-item">All items from FREE plan plus the below</li>
								<li class="sm-pricing__plan-benefits-item">Unlimited apps</li>
								<li class="sm-pricing__plan-benefits-item">No Ads</li>
								<li class="sm-pricing__plan-benefits-item">Twice the reviews for each given review</li>
								<li class="sm-pricing__plan-benefits-item">Attach a note for your app's reviewer</li>
								<li class="sm-pricing__plan-benefits-item">Priority support</li>
							</ul>
						</div>
					</div>
				</div>
      		</section>

			<section class="page4">
		     	<div class="page_container">

		     		<h1>F.A.Q.</h1>

					
				</div>
      		</section>

      		<section class="page5">
		     	<div class="page_container">

		     		<h1>Contact</h1>

		     		<table width="100%" border="0">
						<tbody>
						<tr>
							<td colspan="2" height="80" valign="top">
								<h2>We'd love to hear from you</h2>
							</td>
						</tr>
						<tr>

							<td width="50%">
								<h4>General Inqueries</h4>
							</td>
							<td width="50%">
								<h4>Press</h4>
							</td>
						</tr>
						<tr>

							<td width="50%">
								<h5><a href="mailto:info@mobilereviews.com">info@mobilereviews.com</a></h5>
							</td>
							<td width="50%">
								<h5><a href="mailto:info@mobilereviews.com">press@mobilereviews.com</a></h5>
							</td>
						</tr>

						<tr>

							<td width="50%">
								<h4>Support</h4>
							</td>
							<td width="50%">
								
							</td>
						</tr>

						<tr>

							<td width="50%">
								<h5><a href="mailto:info@mobilereviews.com">support@mobilereviews.com</a></h5>
							</td>
							<td width="50%">
								
							</td>
						</tr>

						</tbody>
					</table>

					
				</div>

				<footer>

					<br>
					<table width="40%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tbody>
						<tr class="footer-tr">
							<td valign="bottom">
								<a href="#" onclick="$('.pageScroll').moveTo(1)" id="text-footer">HOME</a>
							</td>
							<td valign="center">
								<a href="#" onclick="$('.pageScroll').moveTo(2)" id="text-footer">HOW IT WORKS</a>
							</td>
							<td valign="center">
								<a href="#" onclick="$('.pageScroll').moveTo(3)" id="text-footer">PRICING</a>
							</td>
							<td valign="center">
								<a href="#" onclick="$('.pageScroll').moveTo(4)" id="text-footer">FAQ</a>
							</td>
							<td valign="center">
								<a href="#" onclick="$('.pageScroll').moveTo(5)" id="text-footer">CONTACT US</a>
							</td>

						</tr>
						<tr>

							<td colspan="5">
								<br>
								<p id="text-footer">Copyright 2016 Mobile Reviews</p>
							</td>
						</tr>

						</tbody>
					</table>

					<span id="footer-span-facebook">
								<img src='${cssPath}/img/icon_facebook.png' height='25' onmouseover="this.src='${cssPath}/img/icon_facebook-hover.png';" onmouseout="this.src='${cssPath}/img/icon_facebook.png';" />
					</span>

					<span id="footer-span-twitter">
								<img src='${cssPath}/img/icon_twitter.png' height='25' onmouseover="this.src='${cssPath}/img/icon_twitter-hover.png';" onmouseout="this.src='${cssPath}/img/icon_twitter.png';" />
					</span>

					<span id="footer-span-top">
								<a href="#" onclick="$('.pageScroll').moveTo(1)"><img src='${cssPath}/img/top.png' height='25'/></a>
					</span>

					</footer>
					
				</footer>


      		</section>

  		</div>

		

	</body>
</html>	