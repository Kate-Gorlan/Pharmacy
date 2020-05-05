<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Рецепт от врача" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    
    <c:choose>
        <c:when test="${idPO != -1}">
        <c:set var="back" value="pendingOrder.html?id=${idPO}"/>
        </c:when>
        <c:otherwise>
        <c:set var="back" value="prescriptions.html"/>
        </c:otherwise>
    </c:choose>
    <a href="${back}">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>

</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty prescription}">
    <div class="col-md-8">
        <div class="card-body">
            <h3>${prescription.medicament.name}</h3>
            
            <p class="card-text" style="color: #800000;">Клиент: <span style="color: black;">${prescription.client.fullName}</span></p>
            
            <p class="card-text" style="color: #800000;">Врач: <span style="color: black;">${prescription.doctor.doctorFullName}</span></p>

            <p class="card-text" style="color: #800000;">Количество: <span style="color: black;">${prescription.amountOfMedicine}</span></p>

            <p class="card-text" style="color: #800000;">Диагноз: <span style="color: black;">${prescription.diagnosis}</span></p>
            
            <c:if test="${prescription.signature == 1}">
            <p class="card-text" style="color: #800000;">Роспись присутствует</p>
            </c:if>
            
            <c:if test="${prescription.seal == 1}">
            <p class="card-text" style="color: #800000;">Печать присутствует</p>
            </c:if>
            
        </div>
    <a href="goAddPrescription.html?id=${prescription.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
    </a>
    <a href="deletePrescription.html?id=${prescription.getId()}">
        <button type="button" class="btn btn-danger">Удалить</button>
    </a>
    </div>
</c:if>

<c:if test="${empty prescription}">
<h4> Рецепт от врача не найден. </h4>
</c:if>
    
</div>

</ui:html>