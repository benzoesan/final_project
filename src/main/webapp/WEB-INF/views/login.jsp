<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login form</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
            background-image: url("/images/shop.jpg"); /* Ścieżka do obrazu tła */
            background-size: cover;
            background-position: center;
            backdrop-filter: blur(10px); /* Mętność tła */
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Przezroczyste tło kontenera */
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .container p {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .container form {
            display: flex;
            flex-direction: column;
        }

        .container form input {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        .container form input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }

        .container form input[type="submit"]:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
<div class="container">
    <p>Formularz logowania</p>
    <form method="post">
        <label>Username:</label>
        <input type="text" name="username">

        <label>Password:</label>
        <input type="password" name="password">

        <sec:csrfInput/>

        <input type="submit" value="Zaloguj">
    </form>
</div>
</body>
</html>
