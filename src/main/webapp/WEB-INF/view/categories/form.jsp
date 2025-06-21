<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category.id == null ? "Нова категорія" : "Редагування категорії"}</title>
</head>
<body>
<h1>${category.id == null ? "Нова категорія" : "Редагування категорії"}</h1>

<form action="${pageContext.request.contextPath}/admin/categories/save" method="post">
    <input type="hidden" name="id" value="${category.id}"/>

    <p>
        <label for="name">Назва:</label><br/>
        <input type="text" id="name" name="name" value="${category.name}" required/>
    </p>

    <p>
        <label for="url">URL:</label><br/>
        <input type="text" id="url" name="url" value="${category.url}"/>
    </p>

    <p>
        <label for="parentId">Батьківська категорія:</label><br/>
        <select name="parentId" id="parentId">
            <option value="0">-- Немає --</option>
            <c:forEach var="cat" items="${allCategories}">
                <c:if test="${cat.id != category.id}">
                    <option value="${cat.id}" ${cat.id == category.parentId ? "selected" : ""}>
                            ${cat.name}
                    </option>
                </c:if>
            </c:forEach>
        </select>
    </p>

    <p>
        <label>
            <input type="checkbox" name="visible" value="true"
            ${category.visible ? "checked" : ""} />
            Видима категорія
        </label>
    </p>

    <p>
        <button type="submit">Зберегти</button>
        <a href="${pageContext.request.contextPath}/admin/categories">Скасувати</a>
    </p>
</form>
</body>
</html>
