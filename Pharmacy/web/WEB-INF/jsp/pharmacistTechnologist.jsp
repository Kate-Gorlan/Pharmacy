<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Технолог" thema="flatly">
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
      <td><a href="recipe.html?id=${medsFM.recipeId}">Открыть рецепт</a></td>
      <td>
          <a href="doneMed.html?name=${medsFM.getMedicamentName()}&id=${medsFM.getId()}&recipe=${medsFM.getRecipeId()}">
        <button type="button" class="btn btn-warning">Изготовлено</button>
        </a>
      </td>
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty medsForManufacture}">
<h4> Нет медикаментов на изготовление. </h4>
</c:if>
    
</div>
</ui:html>