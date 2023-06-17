<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h3>Formularz reklamacyjny</h3>

<form:form method="post" modelAttribute="complaint">
    <label>Dane klienta:</label>
    <div> Imię: <form:input path="customer.firstName"/><form:errors path="customer.firstName" cssClass="error"/></div>
    <div> Nazwisko: <form:input path="customer.lastName"/><form:errors path="customer.lastName" cssClass="error"/></div>
    <div> E-mail: <form:input type="email" path="customer.email"/><form:errors path="customer.email" cssClass="error"/></div>
    <div> Numer telefonu: <form:input path="customer.phone"/><form:errors path="customer.phone" cssClass="error"/></div>

    <label>Informacje o produkcie:</label>
    <div> Nazwa produktu: <form:input path="product.name"/><form:errors path="product.name" cssClass="error"/></div>
    <div> Opis produktu: <form:textarea path="product.description" rows="4" cols="6"/><form:errors path="product.description" cssClass="error"/></div>
    <div> Indeks: <form:input path="product.produceCode"/><form:errors path="product.produceCode" cssClass="error"/></div>
    <div> Cena: <form:input path="product.price" type="number" step="0.01"/><form:errors path="product.price" cssClass="error"/></div>
    <div> Data zakupu : <form:input path="product.purchaseDate" type="date"/><form:errors path="product.purchaseDate" cssClass="error"/></div>
    <div> Numer dokumentu sprzedaży : <form:input path="product.salesDocumentNumber" type="numer"/><form:errors path="product.salesDocumentNumber" cssClass="error"/></div>
    <div> Typ dokumentu sprzedaży :
        <form:select path="product.salesDocumentType">
        <form:option value="paragon">Paragon</form:option>
        <form:option value="faktura">Faktura</form:option>
        <form:option value="paragonZastepczy">Paragon zastępczy</form:option>
        <form:option value="numerZamowienia">Numer zamówienia</form:option>
        </form:select>
        <form:errors path="product.salesDocumentType" cssClass="error"/></div>

    <label>Informacje o wadzie:</label>

    <div>
        <label for="status">Status:</label>
        <form:select path="status" items="${status}" required="true">
        </form:select>
    </div>



    <input type="submit" value="Zapisz reklamację">
</form:form>

</body>
</html>