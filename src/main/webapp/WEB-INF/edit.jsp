<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--   <%@ page isErrorPage="true" %>   --%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit language</h1>
<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="post">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>