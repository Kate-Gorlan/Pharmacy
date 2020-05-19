<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Главная страница" thema="flatly">
<body style="width:100%;height:100%;">

<div style="width: 85%; overflow:auto; overflow-x:hidden;">
    <c:if test="${not empty positions}">
         <div class="card-deck">
            <c:forEach items="${positions}" var="position">
                <div class="card mb-3" style="max-width: 600px; min-width: 600px;">
                    <div class="row no-gutters">
                        <div class="col-md-8">
                            <div class="card-body">
                            <c:choose>
                            <c:when test="${position.title == 'Администратор'}">
                            <a href="admin.html?doBD=not&func=not&table=not&login=not&pass=not" style="font-size: 200%;">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Фармацевт'}">
                            <a href="pharmacist.html?idMed=-1" style="font-size: 200%;">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Провизор-технолог'}">
                            <a href="pharmacistTechnologist.html" style="font-size: 200%;">${position.title}</a>
                            </c:when>
                            <c:when test="${position.title == 'Кладовщик'}">
                            <a href="storekeeper.html?typeMed=not&typeProd=not" style="font-size: 200%;">${position.title}</a>
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