<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Lista reklamacji</title>
</head>
<body>
<h3>Lista reklamacji</h3>

<table>
    <tr>
        <th>Numer reklamacji</th>
        <th>Data złożenia reklamacji</th>
        <th>Imię i nazwisko</th>
        <th>Indeks</th>
        <th>Nazwa produktu</th>
        <th>Status reklamacji</th>
    </tr>
    <c:forEach var="complaint" items="${complaints}">
        <tr>
            <td>${complaint.id}</td>
            <td>${complaint.dateOfComplaint}</td>
            <td>${complaint.customer.firstName} ${complaint.customer.lastName}</td>
            <td>${complaint.product.produceCode}</td>
            <td>${complaint.product.id}</td>
            <td>${complaint.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>