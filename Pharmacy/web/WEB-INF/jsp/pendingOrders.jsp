<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Заказы" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="pharmacist.html?idMed=-1">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddPO.html">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty pendOrders}">
<h4> Заказы </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Дата регистрации</th>
      <th scope="col">Дата взятия</th>
      <th scope="col">Статус взятия</th>
      <th scope="col"></th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty pendOrders}">
    <c:forEach items="${pendOrders}" var="pendOrder">
    <tr class="table-light" style="color:black;">
      <th scope="row">${pendOrder.id}</th>
      <td>${pendOrder.order.date}</td>
      <td>${pendOrder.availabilityDate}</td>
      <td>${pendOrder.takeStatus}</td>
      
      <td><a href="pendingOrder.html?id=${pendOrder.getId()}&idOrder=${pendOrder.order.id}">Подробнее</a></td>
      <td>
      <a href="goAddPendingOrder.html?id=${pendOrder.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deletePendingOrder.html?id=${pendOrder.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${empty pendOrders}">
<h4> Нет отложенных заказов и заказов на изготовления. </h4>
</c:if>

</div>
</ui:html>