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
<form:form method="post" modelAttribute="customer">
    <label>DANE REKLAMUJĄCEGO:</label>
    <br><br>
    <div> Imię: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></div>
    <div> Nazwisko: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></div>
    <div> E-mail: <form:input type="email" path="email"/><form:errors path="email" cssClass="error"/></div>
    <div> Numer telefonu: <form:input type ="tel" path="phone"/><form:errors path="phone" cssClass="error"/></div>
    <input type="submit" value="Zapisz reklamację">
</form:form>

</body>
</html>