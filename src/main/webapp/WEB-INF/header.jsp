<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="header" class="clearfix">
	<div id="nav">
		<div style="padding-top: 30px"></div>
	</div>
</div>

<div>
    <a href="#" onclick="addOrUpdateUrlParam('format', 'json')"><fmt:message key="films.list.command.asJson"/></a>
</div>

<hr/>