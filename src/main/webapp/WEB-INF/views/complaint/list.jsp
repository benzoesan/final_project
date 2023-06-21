<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista reklamacji</title>
</head>
<body>
<h3>Lista reklamacji</h3>

<table>
    <tr>
        <th>Numer reklamacji</th>
        <th>Imię i nazwisko</th>
        <th>Data złożenia reklamacji</th>
        <th>Nazwa produktu</th>
        <th>Indeks</th>
        <th>Dni do przeterminowania</th>
        <th>Status reklamacji</th>
    </tr>
    <c:forEach items="${complaints}" var="complaint">
        <tr>
            <td>${complaint.id}</td>
            <td>${complaint.customer.firstName} ${complaint.customer.lastName}</td>
            <td>${complaint.dateOfComplaint}</td>
            <td>${complaint.product.name}</td>
            <td>${complaint.product.produceCode}</td>
            <td>${complaint.daysToDetermination}</td>
            <td>${complaint.status}</td>
        </tr>

        <td><a href="edit?id=${complaint.id}">Edit</a></td>
        <td><a href="remove?id=${complaint.id}" onclick="return confirm('Are you sure?')">Usuń</a></td>
    </c:forEach>
</table>

<a href="<c:url value='/complaint/add'/> ">Dodaj nową reklamację</a>
</body>
</html>