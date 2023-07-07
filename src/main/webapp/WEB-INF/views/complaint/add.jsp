<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nowa reklamacja</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <style>
        input[type="text"], textarea {
            width: 100%;
            box-sizing: border-box;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body style="background-color: #f2f2f2;">
<div class="container" style="max-width: 600px; margin: 0 auto;">
    <h3>Formularz reklamacyjny</h3>

    <form:form method="post" modelAttribute="complaint">
        <div class="form-group">
            <br><br>
            <label>DANE REKLAMUJĄCEGO:</label>
            <br><br>
            <div class="form-group" style="display: none;">
                <label for="customerId">ID klienta:</label>
                <form:input path="customer.id" id="customerId" type="hidden"/>
            </div>
            <div>
                <label for="firstName">Imię:</label>
                <form:input path="customer.firstName" id="firstName"/>
                <form:errors path="customer.firstName" cssClass="error"/>
            </div>
            <div>
                <label for="lastName">Nazwisko:</label>
                <form:input path="customer.lastName" id="lastName"/>
                <form:errors path="customer.lastName" cssClass="error"/>
            </div>
            <div>
                <label for="email">E-mail:</label>
                <form:input type="email" path="customer.email" id="email"/>
                <form:errors path="customer.email" cssClass="error"/>
            </div>
            <div>
                <label for="phone">Numer telefonu:</label>
                <form:input type="tel" path="customer.phone" id="phone"/>
                <form:errors path="customer.phone" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <br><br>
            <label>INFORMACJE O PRODUKCIE:</label>
            <br><br>
            <div class="form-group" style="display: none;">
                <label for="productId">ID produktu:</label>
                <form:input path="product.id" id="productId" type="hidden"/>
            </div>
            <div>
                <label for="productName">Nazwa produktu:</label>
                <form:input path="product.name" id="productName"/>
                <form:errors path="product.name" cssClass="error"/>
            </div>
            <div>
                <label for="productDescription">Opis produktu:</label>
                <form:textarea path="product.description" rows="4" cols="20" id="productDescription"/>
                <form:errors path="product.description" cssClass="error"/>
            </div>
            <div>
                <label for="productCode">Indeks:</label>
                <form:input path="product.produceCode" id="productCode"/>
                <form:errors path="product.produceCode" cssClass="error"/>
            </div>
            <div>
                <label for="productPrice">Cena:</label>
                <form:input path="product.price" type="number" step="0.01" id="productPrice"/>
                <form:errors path="product.price" cssClass="error"/>
            </div>
            <div>
                <label for="purchaseDate">Data zakupu:</label>
                <form:input path="product.purchaseDate" type="date" id="purchaseDate"/>
                <form:errors path="product.purchaseDate" cssClass="error"/>
            </div>
            <div>
                <label for="salesDocumentNumber">Numer dokumentu sprzedaży:</label>
                <form:input path="product.salesDocumentNumber" type="text" id="salesDocumentNumber"/>
                <form:errors path="product.salesDocumentNumber" cssClass="error"/>
            </div>
            <div>
                <label for="salesDocumentType">Typ dokumentu sprzedaży:</label>
                <form:select path="product.salesDocumentType" id="salesDocumentType">
                    <form:option value="paragon">Paragon</form:option>
                    <form:option value="faktura">Faktura</form:option>
                    <form:option value="paragonZastepczy">Paragon zastępczy</form:option>
                    <form:option value="numerZamowienia">Numer zamówienia</form:option>
                </form:select>
                <form:errors path="product.salesDocumentType" cssClass="error"/>
            </div>
        </div>

        <div class="form-group">
            <br><br>
            <label>PRZYCZYNY REKLAMACJI:</label>
            <br><br>
            <div>
                <label for="defectDate">Data powstania wady:</label>
                <form:input path="dateOfDefect" type="date" id="defectDate"/>
                <form:errors path="dateOfDefect" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="complaintStatus">Rodzaj uszkodzeń:</label><br>
                <form:select path="typeOfDamage" items="${typeOfDamage}" required="true" id="typeOfDamage"></form:select>
            </div>

        <div class="form-group">
            <label for="complaintStatus">Oczekiwania klienta:</label><br>
            <form:select path="advertiserExpectations" items="${advertiserExpectations}" required="true" id="advertiserExpectations"></form:select>
        </div>

        <div class="form-group">
            <label for="comments">Dodatkowe uwagi/oczekiwania:</label>
            <form:textarea path="comments" rows="5" cols="50" id="comments"/>
            <form:errors path="comments" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="complaintDate">Data złożenia reklamacji:</label>
            <form:input path="dateOfComplaint" type="date" id="complaintDate"/>
            <form:errors path="dateOfComplaint" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="complaintStatus">Status reklamacji:</label>
            <form:select path="state" items="${state}" required="true" id="complaintStatus"></form:select>
        </div>

        <div class="form-group">
            <input type="submit" value="Zapisz reklamację" class="btn btn-primary">
        </div>
        </div>
    </form:form>
    <a href="<c:url value='/complaint/home'/>" class="btn btn-secondary">Powrót</a>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>
</body>
</html>
