<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Главная страница" thema="flatly">
<body style="width:100%;height:100%;">

<div style="width: 50%; float: left; overflow:auto; overflow-x:hidden; overflow-x: scroll; border:5px solid white;">
    <h3 style="align:center"> Медикаменты </h3>
    <a href="stockMedicaments.html">
    <button type="button" class="btn btn-success">Перейти к складу медикаментов</button>
    </a>
    <a href="medicaments.html?view=all&typeTopMed=not">
    <button type="button" class="btn btn-success">Перейти к медикаментам</button>
    </a>
    <h5> Медикаменты, которые закончились </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Название</th>
      <th scope="col">Применение</th>
      <th scope="col">Тип</th>
      <th scope="col">Необходимость рецепта</th>
      <th scope="col">Возможность изготовления</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty medOver}">
    <c:forEach items="${medOver}" var="medicamentOver">
    <tr class="table-secondary">
      <th scope="row">${medicamentOver.id}</th>
      <td>${medicamentOver.name}</td>
      <td>${medicamentOver.modeOfApplication}</td>
      <td>${medicamentOver.type}</td>
      <td>${medicamentOver.availabilityOfPrescription}</td>
      <td>${medicamentOver.manufacturability}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 

    <h5> Медикаменты, которые заканчиваются </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty criticalNormMedicament}">
    <c:forEach items="${criticalNormMedicament}" var="criticalNormMed">
    <tr class="table-secondary">
      <td>${criticalNormMed.medicament}</td>
      <td>${criticalNormMed.medicamentType}</td>
      <td>${criticalNormMed.medicamentQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 
    <h5> Медикамент, которого меньше всего на складе </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty minMedicament}">
    <c:forEach items="${minMedicament}" var="minMed">
    <tr class="table-secondary">
      <td>${minMed.medicament}</td>
      <td>${minMed.medicamentType}</td>
      <td>${minMed.medicamentQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 
   <h5> Медикамент определенного типа, которого меньше всего на складе </h5> 
   <c:url value="/typeMed.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
   <input maxlength="40" type="text" 
   name="typeMed" class="form-control" id="typeMed" placeholder="Введите тип медикамента"/>
   </div>
   <button style="margin: 0 auto;" type="submit" class="btn btn-primary">Найти</button>
   </form>
  <c:if test="${not empty typeMed}">
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty minMedicamentByType}">
    <c:forEach items="${minMedicamentByType}" var="minMedByType">
    <tr class="table-secondary">
      <td>${minMedByType.medicament}</td>
      <td>${minMedByType.medicamentType}</td>
      <td>${minMedByType.medicamentQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>  
</c:if> 
</div>

<div style="width: 50%; float: right; overflow:auto; overflow-x:hidden; overflow-x: scroll; border:5px solid white;">
    <h3 style="align:center"> Продукты </h3>
    <a href="stockProducts.html">
    <button type="button" class="btn btn-success">Перейти к складу продуктов</button>
    </a>
    <a href="products.html?view=all&prodNumByPeriod=not&name=not">
    <button type="button" class="btn btn-success">Перейти к продуктам</button>
    </a>
        <h5> Продукты, которые закончились </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty prodOver}">
    <c:forEach items="${prodOver}" var="pOver">
    <tr class="table-secondary">
      <th scope="row">${pOver.id}</th>
      <td>${pOver.name}</td>
      <td>${pOver.type}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 

    <h5> Продукты, которые заканчиваются </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty criticalNormProduct}">
    <c:forEach items="${criticalNormProduct}" var="criticalNormProd">
    <tr class="table-secondary">
      <td>${criticalNormProd.product}</td>
      <td>${criticalNormProd.productType}</td>
      <td>${criticalNormProd.productQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 
    <h5> Продукт, которого меньше всего на складе </h5> 
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty minProduct}">
    <c:forEach items="${minProduct}" var="minProd">
    <tr class="table-secondary">
      <td>${minProd.product}</td>
      <td>${minProd.productType}</td>
      <td>${minProd.productQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table> 
   <h5> Продукт определенного типа, которого меньше всего на складе </h5> 
   <c:url value="/typeProd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
   <input maxlength="40" type="text" 
   name="typeProd" class="form-control" id="typeProd" placeholder="Введите тип продукта"/>
   </div>
   <button style="margin: 0 auto;" type="submit" class="btn btn-primary">Найти</button>
   </form>
  <c:if test="${not empty typeMed}">
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
      <th scope="col">Количество</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty minProductByType}">
    <c:forEach items="${minProductByType}" var="minProdByType">
    <tr class="table-secondary">
      <td>${minProdByType.product}</td>
      <td>${minProdByType.productType}</td>
      <td>${minProdByType.productQuantity}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>  
</c:if> 
</div>

</body>
</ui:html>