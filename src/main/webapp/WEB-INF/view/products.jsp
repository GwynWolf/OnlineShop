<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список товаров</title>
    <style>
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }

        .product-list {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .product-card {
            border: 1px solid #ccc;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .product-info {
            flex-grow: 1;
        }

        .product-card a {
            text-decoration: none;
            color: black;
            font-weight: bold;
        }

        .product-card a:hover {
            color: darkblue;
        }

        .back-button, .create-button {
            display: inline-block;
            margin: 10px 5px 20px 0;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .back-button:hover,
        .create-button:hover {
            background-color: #0056b3;
        }

        .slug {
            font-size: 12px;
            color: gray;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Список товаров</h2>

    <a href="/OnlineStore/admin" class="back-button">← Назад в админку</a>
    <a href="/OnlineStore/admin/products/new" class="create-button">+ Создать товар</a>

    <div class="product-list">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                <div class="product-info">
                    <a href="/OnlineStore/admin/products/${product.id}">
                            ${product.name}
                    </a>
                    <div class="slug">${product.slug}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
