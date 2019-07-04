<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   String message = pageContext.getException().getMessage();
   String exception = pageContext.getException().getClass().toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception</title>
</head>
<body>
<h2>Exception occurred while processing the request</h2>
<p>Type: <%= exception%></p>
<p>Message: <%= message %></p>
<a href="<c:url value="/getNotes"/>">К списку!</a>
</body>
</html>