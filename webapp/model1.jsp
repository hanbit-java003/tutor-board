<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int x = Integer.valueOf(request.getParameter("x"));
	int y = Integer.valueOf(request.getParameter("y"));
	
	int result = x + y;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model 1</title>
</head>
<body>
결과는 <%=result %>
</body>
</html>