<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Склад медикаментов" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="storekeeper.html?typeMed=not&typeProd=not">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddStockMedicament.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty medExpired}">
<h4> Вышел срок годности </h4>
<table class="table table-danger">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID медикамента</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty medExpired}">
    <c:forEach items="${medExpired}" var="medicamentExpired">
    <tr class="table-light" style="color:black;">
      <th scope="row">${medicamentExpired.id}</th>
      <td>${medicamentExpired.medicament.id}</td>
      <td>${medicamentExpired.quantity}</td>
      <td>${medicamentExpired.price}</td>
      <td>${medicamentExpired.shelfLife} дней</td>
      <td>${medicamentExpired.dateOfArrival}</td>
      <td>${medicamentExpired.criticalNorm}</td>
      <td>
      <a href="deleteStockMedicament.html?id=${medicamentExpired.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${not empty medWillSoonExpire}">
<h4> Истекает срок годности </h4>
<table class="table table-warning">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID медикамента</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty medWillSoonExpire}">
    <c:forEach items="${medWillSoonExpire}" var="medicamentWillSoonExpire">
    <tr class="table-light" style="color:black;">
      <th scope="row">${medicamentWillSoonExpire.id}</th>
      <td>${medicamentWillSoonExpire.medicament.id}</td>
      <td>${medicamentWillSoonExpire.quantity}</td>
      <td>${medicamentWillSoonExpire.price}</td>
      <td>${medicamentWillSoonExpire.shelfLife} дней</td>
      <td>${medicamentWillSoonExpire.dateOfArrival}</td>
      <td>${medicamentWillSoonExpire.criticalNorm}</td>
      <td>
        <a href="goAddStockMedicament.html?id=${medicamentWillSoonExpire.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteStockMedicament.html?id=${medicamentWillSoonExpire.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<h4> Все продукты на складе </h4>
    <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID медикамента</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty medStock}">
    <c:forEach items="${medStock}" var="medicamentStock">
    <tr class="table-secondary">
      <th scope="row">${medicamentStock.id}</th>
      <td>${medicamentStock.medicament.id}</td>
      <td>${medicamentStock.quantity}</td>
      <td>${medicamentStock.price}</td>
      <td>${medicamentStock.shelfLife} дней</td>
      <td>${medicamentStock.dateOfArrival}</td>
      <td>${medicamentStock.criticalNorm}</td>
      <td>
        <a href="goAddStockMedicament.html?id=${medicamentStock.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteStockMedicament.html?id=${medicamentStock.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>


</div>
</body>
</ui:html>