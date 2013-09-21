<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Film details</h1>

<div>
    <a href="#" onclick="addOrUpdateUrlParam('format', 'json')"><fmt:message key="films.list.command.asJson"/></a>
</div>

<div id="entityDetails">
	<div id="filmDetails">
		<ul>
			<li>Title: ${film.title}</li>
			<li>Rating: ${film.rating} (${film.votes} votes)</li>
		</ul>
	</div>
</div>