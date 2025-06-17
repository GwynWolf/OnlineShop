<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Список заказов</title>
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
  </style>
</head>
<body>

<h2>Список заказов</h2>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Имя клиента</th>
    <th>Email</th>
    <th>Телефон</th>
    <th>Адрес</th>
    <th>Итоговая сумма</th>
    <th>Дата</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="order" items="${orders}">
    <tr>
      <td>${order.id}</td>
      <td>${order.customerName}</td>
      <td>${order.email}</td>
      <td>${order.phone}</td>
      <td>${order.address}</td>
      <td>${order.total}</td>
      <td>${order.date}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
