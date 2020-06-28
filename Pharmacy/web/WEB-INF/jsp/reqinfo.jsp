<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Заявки" thema="flatly">
<div class="container" style="">
    <ul class="list-group" style="border: 0; width: 80%">
        <li class="list-group-item2">Идентификатор заявки: ${req.id}</li>
        <li class="list-group-item2">Идентификатор клиента: ${req.client.id}</li>
        <li class="list-group-item2">ФИО: ${req.client.fullName}</li>
        <li class="list-group-item2">Адрес: ${req.client.address}</li>
        <li class="list-group-item2">Номер телефона: ${req.client.phone}</li>
        <li class="list-group-item2">Идентификатор медикамента: ${req.medicament.id}</li>
        <li class="list-group-item2">Название медикамента: ${req.medicament.name}</li>
        <li class="list-group-item2">Количество медикамента: ${req.quantity}</li>
        <li class="list-group-item2">Необходимость рецепта: ${req.medicament.availabilityOfPrescription >= 1 ? 'Да' : 'Нет'}</li>
    </ul>
    <c:if test = "${not empty req.img}">
        <img alt="" src="${pic}"style="margin-top: 40px; margin-bottom: 80px;">
    </c:if>
</div>
</ui:html>