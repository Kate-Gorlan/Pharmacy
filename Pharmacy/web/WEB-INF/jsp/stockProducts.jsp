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
<body style="width:100%;height:100%;">
<div style="width: 85%; overflow:auto; overflow-x:hidden;">
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
</body>
</ui:html>