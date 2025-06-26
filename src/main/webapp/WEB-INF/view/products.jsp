<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список товаров</title>
    <style>
        .product-card {
            display: inline-block;
            width: 200px;
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            vertical-align: top;
            text-align: center;
        }

        .product-card img {
            max-width: 100%;
            height: auto;
        }

        .product-card a {
            text-decoration: none;
            color: black;
            font-weight: bold;
        }

        .product-card a:hover {
            color: darkblue;
        }

        .back-button {
            display: inline-block;
            margin: 20px 0;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h2>Товары</h2>

<a href="/OnlineStore/admin" class="back-button">← Назад в админку</a>

<c:forEach var="product" items="${products}">
    <div class="product-card">
        <a href="/OnlineStore/admin/products/${product.id}">
            <!--<img src="/images/products/${product.mainImageId}.jpg" alt="${product.name}" />-->
            <div>${product.name}</div>
        </a>
        <div style="font-size: 12px; color: gray;">${product.url}</div>
    </div>
</c:forEach>

</body>
</html>
