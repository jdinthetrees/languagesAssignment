<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${language.name}"/></h1>
<p>Name: <c:out value="${language.name}"/></p>
<p>Creator: <c:out value="${language.creator}"/></p>
<p>Version: <c:out value="${language.version}"/></p>
<a href="/languages/${language.id}/edit">Edit language</a>
<a href="/languages">Back to home</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>