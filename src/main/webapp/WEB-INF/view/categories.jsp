<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Список продуктов</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      padding: 6px;
      border: 1px solid #ccc;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }

    .hidden {
      color: red;
    }
  </style>
</head>
<body>

<h2>Список продуктов</h2>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>URL</th>
    <th>Название</th>
    <th>Бренд</th>
    <th>Аннотация</th>
    <th>Видимость</th>
    <th>Позиция</th>
    <th>Рейтинг</th>
    <th>Голосов</th>
    <th>Спец. пометка</th>
    <th>Избранное</th>
    <th>Категория</th>
    <th>Изображение</th>
    <th>Дата создания</th>
    <th>Изменено</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>
      <td>${product.url}</td>
      <td>${product.name}</td>
      <td>${product.brandId}</td>
      <td>${product.annotation}</td>
      <td>
        <c:choose>
          <c:when test="${product.visible}">✅</c:when>
          <c:otherwise><span class="hidden">❌</span></c:otherwise>
        </c:choose>
      </td>
      <td>${product.position}</td>
      <td>${product.rating}</td>
      <td>${product.votes}</td>
      <td>${product.special}</td>
      <td>
        <c:if test="${product.featured}">🌟</c:if>
      </td>
      <td>${product.mainCategoryId}</td>
      <td>${product.mainImageId}</td>
      <td>${product.created}</td>
      <td>${product.lastModify}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
