
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <title>Spring Security Example</title>
</head>
<body>
<h1>Witaj użytkowniku </h1>
<div></div>
<td><a href="add?id=${complaint.id}">Dodaj nową reklamację</a></td>
<td><a href="list?id=${complaint.id}">wyswietl liste</a></td>
</body>
