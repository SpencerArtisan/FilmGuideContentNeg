<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
	<a href="#" onclick="addOrUpdateUrlParam('format', 'json')"><fmt:message key="films.list.command.asJson"/></a>
</div>

<hr/>

<div id="entityDetails">
	<div id="films">
		<h2>Films</h2>
		<table style="margin-left: 3em">
			<thead>
				<tr>
					<th>Title</th>
					<th>Votes</th>
					<th>Rating</th>
				</tr>
			</thead>
			<c:forEach var="film" items="${films}">
				<tr>
		 			<td>
						<spring:url var="showUrl" value="films/{id}">
							<spring:param name="id" value="${film.id}" />
						</spring:url>
						<a href="${showUrl}">${film.title}</a>
					</td>
					<td style="text-align: center">
						${film.votes}
					</td>
					<td style="text-align: right">
						${film.rating}
					</td>
				</tr>
			</c:forEach>	
		</table>
	</div>
</div>