<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Рецепты на лекарство" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
<!--<c:if test="${not empty url}">
    <a href="${url}">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
</c:if>-->

    <a href="doctors.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Врачи</button></a>

    <a href="goAddPrescription.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">


<c:if test="${not empty prescriptionsNew}">
<h4> Свободные рецепты на медикаменты </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">Клиент</th>
      <th scope="col">Медикамент</th>
      <th scope="col">Врач</th>
      <th scope="col">Количество</th>
      <th scope="col"></th>  
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${prescriptionsNew}" var="prescriptionNew">
    <tr class="table-light" style="color:black;">

      <td>${prescriptionNew.client.fullName}</td>
      <td>${prescriptionNew.medicament.name}</td>
      <td>${prescriptionNew.doctor.doctorFullName}</td>
      <td>${prescriptionNew.amountOfMedicine}</td>
      
      <td><a href="prescription.html?id=${prescriptionNew.id}">Подробнее</a></td>
      
      <td>
        <a href="goAddPrescription.html?id=${prescriptionNew.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deletePrescription.html?id=${prescriptionNew.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
      
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty prescriptionsNew}">
<h4> Нет свободных рецептов на медикаменты </h4>
</c:if>


<c:if test="${not empty prescriptions}">
<h4> Рецепты на медикаменты </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">Клиент</th>
      <th scope="col">Медикамент</th>
      <th scope="col">Врач</th>
      <th scope="col">Количество</th>
      <th scope="col"></th>  
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${prescriptions}" var="prescription">
    <tr class="table-light" style="color:black;">
    
      <td>${prescription.client.fullName}</td>
      <td>${prescription.medicament.name}</td>
      <td>${prescription.doctor.doctorFullName}</td>
      <td>${prescription.amountOfMedicine}</td>
      
      <td><a href="prescription.html?id=${prescription.id}">Подробнее</a></td>
      
      <td>
        <a href="goAddPrescription.html?id=${prescription.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deletePrescription.html?id=${prescription.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
      
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty prescriptions}">
<h4> Нет рецептов на медикаменты </h4>
</c:if>
    
</div>

</ui:html>