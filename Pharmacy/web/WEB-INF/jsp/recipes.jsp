<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Рецепты" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="pharmacistTechnologist.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddRecipe.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    <a href="medicaments.html?view=all&typeTopMed=not&page=1">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Медикаменты</button></a>
    <a href="products.html?view=all&prodNumByPeriod=not&name=not&page=1">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Продукты</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty recipes}">
<h4> Рецепты изготовления медикаментов </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Медикамент</th>
      <th scope="col">Время изготовления</th>
      <th scope="col">Количество</th>
      <th scope="col"></th>  
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${recipes}" var="recipe">
    <tr class="table-light" style="color:black;">
      <th scope="row">${recipe.id}</th>
      <td>${recipe.medicament.name}</td>
      <td>${recipe.settlingTime}</td>
      <td>${recipe.quantity}</td>
      <td><a href="recipe.html?id=${recipe.id}">Подробнее</a></td>
      
      <td>
        <a href="goAddRecipe.html?id=${recipe.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteRecipe.html?id=${recipe.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
      
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty recipes}">
<h4> Нет рецептов изготовления медикаментов. </h4>
</c:if>
    
</div>

</ui:html>