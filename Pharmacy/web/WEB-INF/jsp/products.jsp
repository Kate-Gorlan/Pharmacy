<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Продукты" thema="flatly">
<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <c:choose>
        <c:when test="${page == 1}">
        <c:set var="back" value="recipes.html"/>
        </c:when>
        <c:otherwise>
        <c:set var="back" value="storekeeper.html?typeMed=not&typeProd=not"/>
        </c:otherwise>
    </c:choose>
    <a href="${back}">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddProduct.html?id=-1&page=${page}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    
    <a href="products.html?view=all&prodNumByPeriod=not&name=not&page=${page}">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Все продукты</button></a>
    
    <a href="products.html?view=progress&prodNumByPeriod=not&name=not&page=${page}">
    <button type="button" class="btn btn-primary" style="width: 100%; font-size: 100%;">
    Продукты, которые используются в изготовлении</button></a>
 
    <c:choose>
    <c:when test="${page == 1}">
    </c:when>
    <c:otherwise>
           
    <c:url value="/nameProd.html" var="href" />
    <form action="${href}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input maxlength="80" type="text" 
    name="name" class="form-control" id="name" placeholder="Введите название"/>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Количество продукта, данного названия, который используется в изготовлении
    </button>
    </form> 
    <c:if test="${not empty prodNumByName}">
    <p>Количество: ${prodNumByName} грамм</p>
    </c:if>  
     
    <a href="progressProd.html">
    <button type="button" class="btn btn-primary" style="width: 100%; font-size: 100%;">
    Количество продукта, который используется в изготовлении, по имени и периоду</button></a>
    <c:if test="${not empty prodNumByPeriod}">
    <p>Количество: ${prodNumByPeriod} грамм</p>
    </c:if> 
    
    </c:otherwise>
    </c:choose>
    
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${view == 'all'}">
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty prod}">
    <c:forEach items="${prod}" var="product">
    <tr class="table-secondary">
      <th scope="row">${product.id}</th>
      <td>${product.name}</td>
      <td>${product.type}</td>
      <td>
        <a href="goAddProduct.html?id=${product.getId()}&page=${page}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteProduct.html?id=${product.getId()}&page=${page}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${view == 'progress'}">
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty prod}">
    <c:forEach items="${prod}" var="product">
    <tr class="table-secondary">
      <td>${product.product}</td>
      <td>${product.productQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

</div>
</ui:html>