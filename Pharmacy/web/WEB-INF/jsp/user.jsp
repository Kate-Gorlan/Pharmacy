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
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <p>ЗАКАЗ 1</p>
                </div>
            </div>
        </div>
    </div>
</ui:indexTag>