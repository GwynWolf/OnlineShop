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

        h2 {
            margin-bottom: 20px;
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
    </style>
</head>
<body>

<div class="container">
    <h2>${product.id != null ? "Редактировать товар" : "Создать новый товар"}</h2>

    <form method="post" action="${pageContext.request.contextPath}/admin/products">
        <input type="hidden" name="id" value="${product.id}" />

        <div class="form-group">
            <label for="name">Название</label>
            <input type="text" name="name" id="name" value="${product.name}" required />
        </div>

        <div class="form-group">
            <label for="slug">Слаг (URL)</label>
            <input type="text" name="slug" id="slug" value="${product.slug}" required />
        </div>

        <div class="form-group">
            <label for="description">Описание</label>
            <textarea name="description" id="description" rows="5">${product.description}</textarea>
        </div>

        <div class="form-group">
            <label for="price">Цена</label>
            <input type="number" name="price" id="price" value="${product.price}" min="0" step="0.01" required />
        </div>

        <div class="form-group">
            <label for="categoryId">Категория</label>
            <select name="categoryId" id="categoryId" required>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}" ${category.id == product.categoryId ? "selected" : ""}>
                            ${category.name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>
                <input type="checkbox" name="isActive" value="true" ${product.isActive ? "checked" : ""} />
                Отображать товар на сайте
            </label>
        </div>



        <form method="post" action="${pageContext.request.contextPath}/admin/products/" style="display:inline;">
            <input type="hidden" name="_method" value="post"/>
            <button type="submit" class="btn btn-danger">Сохранить</button>
        </form>
        <form method="post" action="${pageContext.request.contextPath}/admin/products/${product.id}" style="display:inline;">
            <input type="hidden" name="_method" value="delete"/>
            <button type="submit" class="btn btn-danger">Удалить</button>
        </form>
        <a class="btn" href="${pageContext.request.contextPath}/admin/products">← Назад</a>
    </form>
</div>

</body>
</html>
