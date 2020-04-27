<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Продукты" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="storekeeper.html?typeMed=not&typeProd=not">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddProduct.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    
    <a href="products.html?view=all&prodNumByPeriod=not&name=not">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Все продукты</button></a>
    
    <a href="products.html?view=progress&prodNumByPeriod=not&name=not">
    <button type="button" class="btn btn-primary" style="width: 100%; font-size: 100%;">
    Продукты, которые используются в изготовлении</button></a>
    
    <c:url value="/nameProd.html" var="href" />
    <form action="${href}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input maxlength="80" type="text" 
    name="name" class="form-control" id="name" placeholder="Введите название"/>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Количество продукта, данного названия, которые используются в изготовлении
    </button>
    </form> 
    <c:if test="${not empty prodNumByName}">
    <p>Количество: ${prodNumByName} грамм</p>
    </c:if>  
     
    <a href="progressProd.html">
    <button type="button" class="btn btn-primary" style="width: 100%; font-size: 100%;">
    Количество продуктов, которые используются в изготовлении, по имени и периоду</button></a>
    <c:if test="${not empty prodNumByPeriod}">
    <p>Количество: ${prodNumByPeriod} грамм</p>
    </c:if> 
    
</div>
<body style="width:100%;height:100%;">
<div style="width: 85%; overflow:auto; overflow-x:hidden;">

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
        <a href="goAddProduct.html?id=${product.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteProduct.html?id=${product.getId()}">
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
</body>
</ui:html>