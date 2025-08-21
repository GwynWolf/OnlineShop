<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Редактировать фильтр</title>
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

    .form-group {
      margin-bottom: 15px;
    }

    label {
      font-weight: bold;
      display: block;
      margin-bottom: 5px;
    }

    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 8px;
      box-sizing: border-box;
    }

    .checkbox-inline {
      display: flex;
      align-items: center;
    }

    .checkbox-inline input[type="checkbox"] {
      margin-right: 8px;
    }

    .btn {
      padding: 8px 14px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      text-decoration: none;
      margin-right: 10px;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #0056b3;
    }

    .btn-danger {
      background-color: #dc3545;
    }

    .btn-danger:hover {
      background-color: #c82333;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 30px;
    }

    th, td {
      padding: 8px;
      border: 1px solid #ccc;
    }

    .actions {
      white-space: nowrap;
    }

    .inline-form {
      display: flex;
      gap: 10px;
      margin-top: 20px;
      align-items: flex-end;
    }

    .inline-form input {
      flex: 1;
    }
  </style>
</head>
<body>

<h2>Редактирование фильтра</h2>

<!-- Форма редактирования самого фильтра -->
<form method="post" action="${pageContext.request.contextPath}/admin/filters">
  <input type="hidden" name="id" value="${filterOption.id}" />

  <div class="form-group">
    <label for="name">Название фильтра</label>
    <input type="text" name="name" id="name" value="${filterOption.name}" required />
  </div>

  <div class="form-group">
    <label for="categoryId">ID категории</label>
    <select name="categoryId" id="categoryId" required>
      <c:forEach var="category" items="${categoryList}">
        <option value="${category.id}" ${category.id == filterOption.categoryId ? "selected" : ""}>
            ${category.name}
        </option>
      </c:forEach>
    </select>

  </div>

  <div class="checkbox-inline">
    <input type="checkbox" name="isMain" id="isMain" value="true"
    ${filterOption.isMain ? "checked" : ""} />
    <label for="isMain">Основной фильтр</label>
  </div>

  <button type="submit" class="btn">💾 Сохранить</button>
  <a href="${pageContext.request.contextPath}/admin/filters" class="btn">← Назад</a>
</form>

<hr />

<h3>Значения фильтра</h3>

<!-- Таблица значений -->
 <c:if test="${not empty filterValueList}">
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Значение</th>
      <th>Дата создания</th>
      <th class="actions">Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="value" items="${filterValueList}">
      <tr>
        <td>${value.id}</td>
        <td>${value.value}</td>
        <td>${value.createdAt}</td>
        <td class="actions">
          <form method="post" action="${pageContext.request.contextPath}/admin/filters/value/${value.id}" style="display:inline;">
            <input type="hidden" name="_method" value="delete"/>
            <button type="submit" class="btn btn-danger">Удалить</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<!-- Форма добавления нового значения -->
<h4>Добавить новое значение</h4>
<form class="inline-form" method="post" action="${pageContext.request.contextPath}/admin/filters/value">
  <input type="hidden" name="optionId" value="${filterOption.id}" />
  <input type="text" name="value" placeholder="Например: Красный" required />
  <button type="submit" class="btn">Добавить</button>
</form>

</body>
</html>
