<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取教程</title>
</head>
<body style="margin:30px">
	<table border="1" cellpadding="10px">
		<tr><th>id</th><th>Name</th></tr>
		<tr><td><c:out value="${course.id}"/></td><td><c:out value="${course.name}"/></td></tr>
	</table>
</body>
</html>