<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Film details</h1>

<div id="entityDetails">
	<div id="filmDetails">
		<ul>
			<li>Title: ${film.title}</li>
			<li>Rating: ${film.rating} (${film.votes} votes)</li>
		</ul>
	</div>
</div>