<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Склад продуктов" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="storekeeper.html?typeMed=not&typeProd=not">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddStockProduct.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty prodExpired}">
<h4> Вышел срок годности </h4>
<table class="table table-danger">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID продукта</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${prodExpired}" var="productExpired">
    <tr class="table-light" style="color:black;">
      <th scope="row">${productExpired.id}</th>
      <td>${productExpired.product.id}</td>
      <td>${productExpired.quantity}</td>
      <td>${productExpired.price}</td>
      <td>${productExpired.shelfLife} дней</td>
      <td>${productExpired.dateOfArrival}</td>
      <td>${productExpired.criticalNorm}</td>
      <td>
      <a href="deleteStockProduct.html?id=${productExpired.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${not empty prodWillSoonExpire}">
<h4> Истекает срок годности </h4>
<table class="table table-warning">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID продукта</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${prodWillSoonExpire}" var="productWillSoonExpire">
    <tr class="table-light" style="color:black;">
      <th scope="row">${productWillSoonExpire.id}</th>
      <td>${productWillSoonExpire.product.id}</td>
      <td>${productWillSoonExpire.quantity}</td>
      <td>${productWillSoonExpire.price}</td>
      <td>${productWillSoonExpire.shelfLife} дней</td>
      <td>${productWillSoonExpire.dateOfArrival}</td>
      <td>${productWillSoonExpire.criticalNorm}</td>
      <td>
        <a href="goAddStockProduct.html?id=${productWillSoonExpire.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteStockProduct.html?id=${productWillSoonExpire.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<h4> Все продукты на складе </h4>
    <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">ID продукта</th>
      <th scope="col">Количество</th>
      <th scope="col">Цена за поставку</th>
      <th scope="col">Срок хранения</th>
      <th scope="col">Дата привоза</th>
      <th scope="col">Критическая норма</th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty prodStock}">
    <c:forEach items="${prodStock}" var="productStock">
    <tr class="table-secondary">
      <th scope="row">${productStock.id}</th>
      <td>${productStock.product.id}</td>
      <td>${productStock.quantity}</td>
      <td>${productStock.price}</td>
      <td>${productStock.shelfLife} дней</td>
      <td>${productStock.dateOfArrival}</td>
      <td>${productStock.criticalNorm}</td>
      <td>
        <a href="goAddStockProduct.html?id=${productStock.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteStockProduct.html?id=${productStock.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>

</div>
</ui:html>