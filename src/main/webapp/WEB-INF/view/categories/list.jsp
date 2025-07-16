<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Категорії</title>
    <style>
        .back-button {
            display: inline-block;
            margin: 20px 0;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>Категорії</h1>
<p><a href="${pageContext.request.contextPath}/admin/categories/new">+ Додати категорію</a></p>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Slug</th>
        <th>Parent</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categoryTree}">
        <tr>
            <td>${category.category.id}</td>
            <td>${category.category.name}</td>
            <td>${category.category.slug}</td>
            <td>
                <c:choose>
                    <c:when test="${category.category.parent != null}">
                        ${category.category.parent.name}
                    </c:when>
                    <c:otherwise>—</c:otherwise>
                </c:choose>
            </td>
            <td>${category.category.visible ? 'Active' : 'Inactive'}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/categories/edit?id=${category.category.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/categories/delete?id=${category.category.id}"
                   onclick="return confirm('Ви впевнені?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>