<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Врачи" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="prescriptions.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    <a href="goAddDoctor.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<span style="overflow:auto; display: inline-block;">

<c:if test="${not empty doctors}">
<h4> Врачи, зарегистрированные в базе </h4>
<table class="table table-info">
  <thead>
    <tr>
      <th scope="col">ФИО</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${doctors}" var="doc">
    <tr class="table-light" style="color:black;">
      <td>${doc.doctorFullName}</td>
      
      <td>
        <a href="goAddDoctor.html?id=${doc.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
        </a>
      </td>
      <td>
      <a href="deleteDoctor.html?id=${doc.getId()}">
      <button type="button" class="btn btn-danger">Удалить</button></a>
      </td>
      
    </tr>
    </c:forEach> 
  </tbody>
</table>
</c:if>

<c:if test="${empty doctors}">
<h4> В базе нет врачей. </h4>
</c:if>
    
</span>

</ui:html>