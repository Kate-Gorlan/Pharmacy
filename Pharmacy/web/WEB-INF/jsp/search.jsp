<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:indexTag title="Профиль" thema="flatly">
    <div class="container">
    <div class="list-group" style="width: 100%; margin-top: 20px">
            <c:forEach items="${result}" var="med">
                <li class="list-group-item list-group-item-action"><img src="${med.picture}" alt="" style="width: 35px; height: 35px"><a
                    href="medicamentinfo.html?id=${med.id}">${med.name}</a> Способ применения: ${med.modeOfApplication} Отпуск: ${med.availabilityOfPrescription == 0 ? 'Без рецепта':'По рецепту'}</li>
            </c:forEach>
        </div>
    </div>
</ui:indexTag>