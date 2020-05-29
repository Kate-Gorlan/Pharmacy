<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Заказы" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="pharmacist.html?idMed=-1">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddOrder.html?pendingOrder=0&id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<!-- ordersNotSale -->
<c:if test="${not empty ordersNotSale}">
<h4> Неоплаченные продажи </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Дата регистрации</th>
      <th scope="col">Зарегистрировал</th>
      <th scope="col">Клиент</th>
      <th scope="col"></th> 
      <th scope="col"></th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty ordersNotSale}">
    <c:forEach items="${ordersNotSale}" var="orderNotSale">
    <tr class="table-light" style="color:black;">
      <th scope="row">${orderNotSale.id}</th>
      <td>${orderNotSale.date}</td>
      <td>${orderNotSale.employee.fullName}</td>
      <td>${orderNotSale.client.fullName}</td>
      
      <td><a href="order.html?id=${orderNotSale.getId()}&pendingOrder=0">Подробнее</a></td>
      <td> 
        <c:if test="${not empty pendOrders}">
        <c:forEach items="${pendOrders}" var="po">
        <c:if test="${po.order.getId()==orderNotSale.getId()}">
        Отложенный заказ
        </c:if>
        </c:forEach> 
        </c:if>
      </td>
      <td>
      <a href="goAddOrder.html?id=${orderNotSale.getId()}&pendingOrder=0">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteOrder.html?id=${orderNotSale.getId()}&pendingOrder=0">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${empty ordersNotSale}">
<h4> Нет неоплаченных продаж. </h4>
</c:if>

<c:if test="${not empty orders}">
<h4> Все продажи </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Дата регистрации</th>
      <th scope="col">Зарегистрировал</th>
      <th scope="col">Клиент</th>
      <th scope="col"></th> 
      <th scope="col"></th> 
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty orders}">
    <c:forEach items="${orders}" var="order">
    <tr class="table-light" style="color:black;">
      <th scope="row">${order.id}</th>
      <td>${order.date}</td>
      <td>${order.employee.fullName}</td>
      <td>${order.client.fullName}</td>
      
      <td><a href="order.html?id=${order.getId()}&pendingOrder=0">Подробнее</a></td>
      <td> 
        <c:if test="${not empty pendOrders}">
        <c:forEach items="${pendOrders}" var="po">
        <c:if test="${po.order.getId()==order.getId()}">
        Отложенный заказ
        </c:if>
        </c:forEach> 
        </c:if>
      </td>
      <td>
      <a href="goAddOrder.html?id=${order.getId()}&pendingOrder=0">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteOrder.html?id=${order.getId()}&pendingOrder=0">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${empty orders}">
<h4> Нет продаж в базе данных аптеки. </h4>
</c:if>

</div>
</ui:html>