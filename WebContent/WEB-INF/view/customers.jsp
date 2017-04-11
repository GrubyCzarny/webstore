<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of customers</title>
</head>
<body>
<h1>List of customers</h1>
<c:forEach var="klient" items="${customers }">
<c:out value="${klient.id }"></c:out><br/>
<c:out value="${klient.name }"></c:out><br/>
<c:out value="${klient.address }"></c:out><br/>
<c:out value="${klient.orders }"></c:out><br/>
</c:forEach>
</body>
</html>