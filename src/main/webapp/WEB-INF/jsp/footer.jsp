<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<footer class="dashboard-footer">
	<br>
	<center>
		<p style="color: #ECECEC">
			Mobile Reviews is a Registred Trademark of Mobile Reviews Inc. All
			rights reserved.<a href="${s:mvcUrl('AC#formApp').build() }">Terms
				of Use</a> | <a href="${s:mvcUrl('AC#formApp').build() }">Privacy
				Policy</a>
		</p>
	</center>
</footer>
