<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul>
    <c:forEach var="node" items="${nodes != null ? nodes : categoryTree}">
        <li>
                ${node.category.name}
            <c:if test="${not empty node.children}">
                <c:set var="nodes" value="${node.children}" scope="request"/>
                <jsp:include page="/WEB-INF/view/categories/tree.jsp"/>
            </c:if>
        </li>
    </c:forEach>
</ul>