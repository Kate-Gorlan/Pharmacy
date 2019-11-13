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
                                <p>${position.title}</p>
                             </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>   
        </c:if>
</div>

<div class="bottom">
    <a href="clients.html" style="font-size: 130%; width: 300px;" class="btn btn-success">Клиенты</a>
</div>

</body>
</ui:html>