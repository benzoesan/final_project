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
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>nr tel</th>
        <th>email</th>
    </tr>
    <c:forEach items="${customer}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.phone}</td>
            <td>${customer.email}</td>

        </tr>

        <td><a href="edit?id=${customer.id}">Edit</a></td>
    </c:forEach>
</table>
</body>
</html>