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

<jsp:include page="/WEB-INF/view/categories/tree.jsp">
    <jsp:param name="nodes" value="${categoryTree}"/>
</jsp:include>


<a href="/OnlineStore/admin" class="back-button">← Назад в админку</a>

</body>
</html>