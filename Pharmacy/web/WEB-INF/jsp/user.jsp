<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<ui:indexTag title="Профиль" thema="flatly">
    <div class="container">
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-description" role="tab"
                    aria-controls="nav-home" aria-selected="true">Профиль</a> <a class="nav-item nav-link" id="nav-profile-tab"
                    data-toggle="tab" href="#nav-request" role="tab" aria-controls="nav-profile" aria-selected="false">Заказы</a>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-description" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="container">
                    <ul class="list-group" style="border: 0; width: 80%">
                        <li class="list-group-item2">ФИО: ${client.fullName}</li>
                        <li class="list-group-item2">Возраст: ${client.age}</li>
                        <li class="list-group-item2">Адрес: ${client.address}</li>
                        <li class="list-group-item2">Номер: ${client.phone}</li>
                    </ul>
                </div>
            </div>

            <div class="tab-pane fade" id="nav-request" role="tabpanel" aria-labelledby="nav-profile-tab">
                <div class="container" style="/*padding-left: 0; background-color: #ebebeb; border-bottom: ridge;*/">
                    <c:forEach items="${requests}" var="req">
                        <div class="row" style="height: 70px; align-items: center; border: 1px solid rgba(190, 197, 205, 0.5);">
                            <div class="col-md-auto">
                                <img alt="" src="${req.medicament.picture}" style="width: 50px; height: 50px">
                            </div>
                            <div class="col-md-auto">
                                <p style="margin-bottom: 0px">${req.medicament.name}</p>
                            </div>
                            <div class="col-md-auto">
                                <p style="margin-bottom: 0px">${req.quantity} шт.</p>
                            </div>
                            <div class="col-md" style="text-align: end;">
                                <p style="margin-bottom: 0px">${req.status}</p>
                            </div>
                            <c:if test = "${req.status == 'В обработке'}">
                            <div class="col-md-auto">
                                <a href="dltreq.html?id=${req.id}"><button class="btn btn-primary" type="button">Отменить</button></a>
                            </div>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</ui:indexTag>