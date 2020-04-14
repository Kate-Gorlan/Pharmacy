<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Технолог" thema="flatly">
<body style="width:100%;height:100%;">
<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="recipes.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Рецепты изготовлений</button></a>

</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty medsForManufacture}">
<h4> Медикаменты на изготовление </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Дата заказа</th>
      <th scope="col">Дата выдачи</th>
      <th scope="col">Медикамент</th>
      <th scope="col">Рецепт</th>  
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${medsForManufacture}" var="medsFM">
    <tr class="table-light" style="color:black;">
      <th scope="row">${medsFM.id}</th>
      <td>${medsFM.orderDate}</td>
      <td>${medsFM.availabilityDate}</td>
      <td>${medsFM.medicamentName}</td>
      <td>${medsFM.recipeId}</td>
     <!-- <td>
          <a href="goAddStockProduct.html?id=${productWillSoonExpire.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteStockProduct.html?id=${productWillSoonExpire.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td> -->
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty medsForManufacture}">
<h4> Нет медикаментов на изготовление. </h4>
</c:if>
    
</div>

</body>
</ui:html>