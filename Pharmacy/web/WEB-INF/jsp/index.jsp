<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Главная страница" thema="flatly">
<body style="width:100%;height:100%;">

<div style="width: 85%; overflow:auto; overflow-x:hidden;">
    <c:if test="${not empty positions}">
         <div class="card-deck">
            <c:forEach items="${positions}" var="position">
                <div class="card mb-3" style="max-width: 300px; min-width: 300px;">
                    <div class="row no-gutters">
                        <div class="col-md-8">
                            <div class="card-body">
                            <c:choose>
                            <c:when test="${position.title == 'Администратор'}">
                            <a href="admin.html">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Фармацевт'}">
                            <a href="pharmacist.html">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Провизор-технолог'}">
                            <a href="pharmacistTechnologist').html">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Кладовщик'}">
                            <a href="storekeeper.html">${position.title}</a>
                            </c:when>
                            <c:otherwise>
                            <p>${position.title}</p>
                            </c:otherwise>
                            </c:choose>
                             </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>   
        </c:if>
</div>
</body>
</ui:html>