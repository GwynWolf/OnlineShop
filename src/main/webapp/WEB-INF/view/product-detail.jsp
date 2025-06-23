<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Редактировать товар</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }

        h2, h3 {
            margin-bottom: 15px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="number"], textarea, select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .image-thumb {
            width: 100px;
            height: auto;
            display: block;
            margin-top: 10px;
        }

        .btn {
            padding: 8px 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            margin-right: 5px;
            margin-top: 10px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 8px 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        .actions {
            white-space: nowrap;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Редактирование товара</h2>

    <form action="${pageContext.request.contextPath}/admin/products/save" method="post">
        <input type="hidden" name="id" value="${product.id}" />

        <div class="form-group">
            <label for="name">Название</label>
            <input type="text" name="name" id="name" value="${product.name}" required />
        </div>

        <div class="form-group">
            <label for="url">URL</label>
            <input type="text" name="url" id="url" value="${product.url}" required />
        </div>

        <div class="form-group">
            <label for="description">Описание</label>
            <textarea name="description" id="description" rows="5">${product.description}</textarea>
        </div>

        <div class="form-group">
            <label>
                <input type="checkbox" name="visible" value="1" ${product.visible ? "checked" : ""} />
                Отображать товар на сайте
            </label>
        </div>


        <button type="submit" class="btn">Сохранить изменения</button>
        <a class="btn" href="${pageContext.request.contextPath}/admin/products">← Назад</a>
    </form>

    <h3>Варианты товара</h3>

    <a class="btn" href="${pageContext.request.contextPath}/admin/variants/add?productId=${product.id}">+ Добавить вариант</a>

    <c:if test="${not empty variants}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Цена</th>
                <th>SKU</th>
                <th class="actions">Действия</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="variant" items="${variants}">
                <tr>
                    <td>${variant.id}</td>
                    <td>${variant.name}</td>
                    <td>${variant.price}</td>
                    <td>${variant.sku}</td>
                    <td class="actions">
                        <a class="btn" href="${pageContext.request.contextPath}/admin/variants/edit/${variant.id}">Редактировать</a>
                        <a class="btn" href="${pageContext.request.contextPath}/admin/variants/delete/${variant.id}">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

</body>
</html>
