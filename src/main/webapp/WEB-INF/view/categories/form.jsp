<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category.id == null ? "Нова категорія" : "Редагування категорії"}</title>
</head>
<body>
<h1>${category.id == null ? "Нова категорія" : "Редагування категорії"}</h1>

<form method="post" action="${pageContext.request.contextPath}/admin/categories/save">
    <input type="hidden" name="id" value="${category.id}" />

    <label>Назва:</label><br/>
    <input type="text" name="name" id="name" value="${category.name}" required/><br/>

    <label>Slug:</label><br/>
    <input type="text" name="slug" id="slug" value="${category.slug}"/><br/>

    <label>Батьківська категорія:</label><br/>
    <select name="parentId">
        <option value="">—</option>
        <c:forEach var="cat" items="${allCategories}">
            <c:if test="${cat.id ne category.id}">
                <option value="${cat.id}" ${cat.id == category.parentId ? 'selected' : ''}>
                        ${cat.name}
                </option>
            </c:if>
        </c:forEach>
    </select><br/>

    <label>Статус:</label>
    <input type="checkbox" name="visible" value="true" ${category.visible ? 'checked' : ''}/> Active<br/>

    <button type="submit">Зберегти</button>
    <c:if test="${category.id != null}">
        <a href="${pageContext.request.contextPath}/admin/categories/delete?id=${category.id}"
           onclick="return confirm('Видалити категорію?');">Видалити</a>
    </c:if>
</form>

<script>
    document.getElementById('name').addEventListener('input', function () {
        const slug = this.value.toLowerCase()
            .replace(/\s+/g, '-')
            .replace(/[^a-z0-9\-а-яіїєґ]/gi, '')
            .replace(/\-+/g, '-')
            .replace(/^\-+|\-+$/g, '');
        document.getElementById('slug').value = slug;
    });
</script>
</body>
</html>
