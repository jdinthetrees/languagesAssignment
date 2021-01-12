<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ page isErrorPage="true" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styles.css" />
<title>Languages</title>
</head>
<body>


<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allLanguages}" var="language">
        <tr>
            
            <td><a href="/languages/${ language.id }">${ language.name }</a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td><a href="/languages/${ language.id }/edit">Edit</a>
				<form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<!-- <input type="submit" value="Delete"> -->
				<a href="/languages/${language.id}/delete"><button>Delete</button></a>
				</form>
			</td>
			
        </tr>
        </c:forEach>
    </tbody>
</table>
<div class="form">
<form:form action="/process" method="post" modelAttribute="language">
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
</div>
</body>
</html>