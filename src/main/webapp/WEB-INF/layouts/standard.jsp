<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<script>
    function addOrUpdateUrlParam(name, value)
    {
        var href = window.location.href;
        var regex = new RegExp("[&\\?]" + name + "=");
        if(regex.test(href))
        {
            regex = new RegExp("([&\\?])" + name + "=\\d+");
            window.location.href = href.replace(regex, "$1" + name + "=" + value);
        }
        else
        {
            if(href.indexOf("?") > -1)
                window.location.href = href + "&" + name + "=" + value;
            else
                window.location.href = href + "?" + name + "=" + value;
        }
    }
</script>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>
		<fmt:message>
			<tiles:insertAttribute name="title" />
		</fmt:message>
	</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/styles/springsource.css"/>" ></link>
</head>
<body>
	<div id="page">
		<tiles:insertAttribute name="header" />
		<div id="content" class="clearfix">
			<div id="main">
				<tiles:insertAttribute name="main" />
			</div>

			<tiles:importAttribute name="navigationTab" />
			<c:if test="${navigationTab ne 'login'}">
				<div id="nav">
					<ul class="clearfix">
						<c:choose>
							<c:when test="${navigationTab ne 'home'}">
								<li><strong> <a href="<c:url value="/"/>"> <fmt:message
												key="navigate.home" />
									</a>
								</strong></li>
							</c:when>
							<c:otherwise>
								<!-- Not needed -->
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</c:if>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>