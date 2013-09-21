<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1><fmt:message key="welcome.title" /></h1>

<form name="form1" method="get" action="films">
    <div class="control-group">
        <label cssClass="control-label">Title:</label>
        <div class="controls">
            <input id="film" name="title"/>
        </div>
        <a href="javascript:document.form1.submit();">Search</a>
    </div>
</form>

