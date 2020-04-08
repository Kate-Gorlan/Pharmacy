<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Пользователи" thema="flatly">
    <body>
        <c:forEach items="${users}" var="user">
            <ul>
                <li>${user.id}:    ${user.login}</li>
            </ul>
        </c:forEach>
    </body>
</ui:html>