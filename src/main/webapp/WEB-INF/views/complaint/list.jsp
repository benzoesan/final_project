<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista reklamacji</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>Lista reklamacji</h3>

    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Numer reklamacji</th>
            <th scope="col">Imię i nazwisko</th>
            <th scope="col">Data złożenia reklamacji</th>
            <th scope="col">Nazwa produktu</th>
            <th scope="col">Indeks</th>
            <th scope="col">Data przeterminowania</th>
            <th scope="col">Oczekiwania klienta</th>
            <th scope="col">Status reklamacji</th>
            <th scope="col">Akcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${complaints}" var="complaint">
            <tr>
                <td>${complaint.id}</td>
                <td>${complaint.customer.firstName} ${complaint.customer.lastName}</td>
                <td>${complaint.dateOfComplaint}</td>
                <td>${complaint.product.name}</td>
                <td>${complaint.product.produceCode}</td>
                <td>${complaint.dateOfDetermination}</td>
                <td>${complaint.advertiserExpectations}</td>
                <td>${complaint.state}</td>
                <td>
                    <a href="edit?id=${complaint.id}" class="btn btn-primary btn-sm">Edytuj</a>
                    <a href="remove?id=${complaint.id}" class="btn btn-danger btn-sm" onclick="return confirm('Czy na pewno chcesz usunąć?')">Usuń</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value='/complaint/add'/>" class="btn btn-primary">Dodaj nową reklamację</a>
    <a href="<c:url value='/complaint/search'/>" class="btn btn-success">Wyszukaj</a>
    <a href="<c:url value='/complaint/home'/>" class="btn btn-secondary">Powrót</a>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
