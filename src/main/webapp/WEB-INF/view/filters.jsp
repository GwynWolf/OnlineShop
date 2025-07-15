<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список фильтров</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        .create-button {
            display: inline-block;
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-bottom: 20px;
        }

        .create-button:hover {
            background-color: #218838;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 8px 12px;
            border: 1px solid #ccc;
            text-align: left;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .center {
            text-align: center;
        }
    </style>
</head>
<body>

<h2>Фильтры</h2>

<a href="${pageContext.request.contextPath}/admin/filters/new" class="create-button">+ Создать новый фильтр</a>

<c:choose>
    <c:when test="${not empty filterOptionList}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>ID категории</th>
                <th>Основной?</th>
                <th>Создан</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="filter" items="${filterOptionList}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/filters/${filter.id}">
                                ${filter.id}
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/filters/${filter.id}">
                                ${filter.name}
                        </a>
                    </td>
                    <td>${filter.categoryId}</td>
                    <td>${filter.isMain ? "Да" : "Нет"}</td>
                    <td>${filter.createdAt}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p class="center">Нет доступных фильтров.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
