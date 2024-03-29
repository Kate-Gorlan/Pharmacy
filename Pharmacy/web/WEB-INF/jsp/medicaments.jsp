<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Медикаменты" thema="flatly">

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
    <a href="goAddMedicament.html?id=-1&page=${page}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    
    <a href="medicaments.html?view=all&typeTopMed=not&page=${page}">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Все медикаменты</button></a>
    
    <a href="medicaments.html?view=top&typeTopMed=not&page=${page}">
    <button type="button" class="btn btn-primary" style="width: 100%; height: 50px; font-size: 150%;">
    Топ 10 покупаемых медикаментов</button></a>
   
   <c:choose>
        <c:when test="${page == 1}">
        </c:when>
        <c:otherwise>
    <c:url value="/typeTopMed.html" var="href" />
    <form action="${href}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input maxlength="40" type="text" 
    name="typeTopMed" class="form-control" id="typeTopMed" placeholder="Введите тип медикамента"/>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Топ 10 покупаемых медикаментов, данного типа
    </button>
    </form>
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
      <th scope="col">Применение</th>
      <th scope="col">Тип</th>
      <th scope="col">Необходимость рецепта</th>
      <th scope="col">Возможность изготовления</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty med}">
    <c:forEach items="${med}" var="medicament">
    <tr class="table-secondary">
      <th scope="row">${medicament.id}</th>
      <td>${medicament.name}</td>
      <td>${medicament.modeOfApplication}</td>
      <td>${medicament.type}</td>
      <td>${medicament.availabilityOfPrescription}</td>
      <td>${medicament.manufacturability}</td>
      <td>
        <a href="goAddMedicament.html?id=${medicament.getId()}&page=${page}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteMedicament.html?id=${medicament.getId()}&page=${page}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

<c:if test="${view == 'top'}">
  <table class="table table-primary">
  <thead>
    <tr>
      <th scope="col">Количество заказов</th>
      <th scope="col">Название</th>
      <th scope="col">Тип</th>
    </tr>
  </thead>
  <tbody>
    <c:if test="${not empty med}">
    <c:forEach items="${med}" var="medicament">
    <tr class="table-secondary">
      <td>${medicament.quantity}</td>
      <td>${medicament.medicament}</td>
      <td>${medicament.medicamentType}</td>
    </tr>
    </c:forEach> 
    </c:if>
  </tbody>
</table>
</c:if>

</div>
</ui:html>