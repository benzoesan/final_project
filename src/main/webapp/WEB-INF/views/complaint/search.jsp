<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wyszukiwanie reklamacji</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>Wyszukiwanie reklamacji</h3>
    <div class="row">
        <div class="col-md-6">
            <h5>Znajdź po nazwisku klienta</h5>
            <form action="<c:url value='/complaint/search/customer'/>" method="GET">
                <div class="form-group">
                    <label for="lastName">Nazwisko</label>
                    <input id="lastName" name="lastName" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
        <div class="col-md-6">
            <h5>Znajdź po statusie</h5>
            <form action="<c:url value='/complaint/search'/>" method="GET">
                <div class="form-group">
                    <label for="state">Status reklamacji</label>
                    <input id="state" name="state" type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
    <hr/>
    <a href="<c:url value='/complaint/list'/>" class="btn btn-secondary">Powrót do listy</a>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
