<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Edycja formularza</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h3>Edytuj formularz reklamacyjny</h3>

<form:form method="post" modelAttribute="complaint">
    <label>Dane klienta:</label>
    <div> Imię: <form:input path="customer.firstName"/><form:errors path="customer.firstName" cssClass="error"/></div>
    <div> Nazwisko: <form:input path="customer.lastName"/><form:errors path="customer.lastName" cssClass="error"/></div>
    <div> E-mail: <form:input type="email" path="customer.email"/><form:errors path="customer.email" cssClass="error"/></div>
    <div> Numer telefonu: <form:input type ="tel" path="customer.phone"/><form:errors path="customer.phone" cssClass="error"/></div>

    <label>Informacje o produkcie:</label>
    <div> Nazwa produktu: <form:input path="product.name"/><form:errors path="product.name" cssClass="error"/></div>
    <div> Opis produktu: <form:textarea path="product.description" rows="4" cols="20"/><form:errors path="product.description" cssClass="error"/></div>
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
    <div> Data powstania wady: <form:input path="dateOfDefect" type="date"/><form:errors path="dateOfDefect" cssClass="error"/></div>
    <div>
        <label>Rodzaj uszkodzenia:</label><br>
        Pękanie: <form:checkbox path="typeOfDamage" value="pękanie"/>
        Prucie: <form:checkbox path="typeOfDamage" value="prucie"/>
        Uszkodzenia mechaniczne:<form:checkbox path="typeOfDamage" value="uszkodzenia mechaniczne"/>
        Przecieranie: <form:checkbox path="typeOfDamage" value="przecieranie"/>
        Jakość nadruku: <form:checkbox path="typeOfDamage" value="jakość nadruku"/>
        Jakość materiału: <form:checkbox path="typeOfDamage" value="jakość materiału"/>
        Wadliwe akcesoria: <form:checkbox path="typeOfDamage" value="wadliwe akcesoria"/>
        Dziury: <form:checkbox path="typeOfDamage" value="dziury"/>
        Odbarwienia:<form:checkbox path="typeOfDamage" value="odbarwienia"/>
    </div>

    <div> Opis szczegółowy wady: <form:textarea path="defectDescription" rows="4" cols="50"/><form:errors path="defectDescription" cssClass="error"/></div>

    <div>
        <label>Oczekiwania klienta:</label><br>
        <input type="checkbox" id="option1" name="advertiserExpectations" value="Zwrot środków">
        <label for="option1">Zwrot środków</label><br>
        <input type="checkbox" id="option2" name="advertiserExpectations" value="Wymiana">
        <label for="option2">Wymiana</label><br>
        <input type="checkbox" id="option3" name="advertiserExpectations" value="Naprawa">
        <label for="option3">Naprawa</label><br>
    </div>


    <div> Dodatkowe uwagi: <form:textarea path="comments" rows="5" cols="50"/><form:errors path="comments" cssClass="error"/></div>

    <div> Data złożenia reklamacji: <form:input path="dateOfComplaint" type="date"/><form:errors path="dateOfComplaint" cssClass="error"/></div>

    <div>
    <label for="status">Status:</label>
    <form:select path="status" items="${status}" required="true">
    </form:select>
    </div>

    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>