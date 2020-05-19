<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<ui:indexTag title="Главная страница" thema="flatly">
    <body style="width: 100%; height: 100%;">
        <div class="container">
            <div class="row align-items-center" style="place-content: center">
                <ul class="list-group list-group-horizontal">
                    <c:forEach items="${medTypes}" var="types">
                        <li class="list-group-item" style="border: 0">
                            <div class="col" align="center">
                                <a class="btn btn-primary" href="category.html?category=${types.type}"
                                    style="background-color: #17bd9d; border: 0">${types.type}</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="container">
            <div class="row col-auto"
                style="color: #fff; background-color: #17bd9d; height: 40px; place-content: center; font-size: medium; font-weight: 400;">Рекомендуем
            </div>
            <div class="row">
                <c:forEach items="${topMed}" var="meds">
                    <div class="card" style="width: 222px;">
                        <div style="height: 222px">
                            <img src="${empty meds.picUri ? 'resources/mainSite/test.png' : meds.picUri }" class="card-img-top" alt="Картинка">
                        </div>
                        <div class="card-body">
                            <a class="card-text" href="medicamentinfo.html?id=${meds.id}">${meds.nameMed}</a>
                        </div>
                        <div class="card-footer">
                            <small class="text" style="color: black;">Price: ${meds.priceMed} руб.</small>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</ui:indexTag>