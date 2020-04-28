<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:indexTag title="Главная страница" thema="flatly">
    <body style="width: 100%; height: 100%;">
        <div class="container">
            <div class="row align-items-center" style="place-content: center">
                <ul class="list-group list-group-horizontal">
                    <c:forEach items="${medTypes}" var="types">
                        <li class="list-group-item" style="border: 0">
                            <div class="col" align="center">
                                <a class="btn btn-primary" href="category.html?category=${types.type}}"
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
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
                <div class="card" style="width: 222px;">
                    <img src="resources/mainSite/test.png" class="card-img-top" alt="">
                    <div class="card-body">
                        <a class="card-text" href="medicamentifno.html?id=-1">Medicament 1</a>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">Price: 10000000</small>
                    </div>
                </div>
            </div>
        </div>
    </body>
</ui:indexTag>