<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Заказ" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="pendingOrders.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    
    <c:choose>
    <c:when test="${empty pendingOrder.employee}">
    <h5 style="border: 10px solid white;"> 
    Добавить медикамент </h5>
    <a href="goAddOrderMed.html?id=-1&pendOrderId=${pendingOrder.getId()}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    </c:when>
    <c:otherwise>
    <c:if test="${empty orderMeds}">
    <h5 style="border: 10px solid white;"> 
    Добавить медикамент </h5>
    <a href="goAddOrderMed.html?id=-1&pendOrderId=${pendingOrder.getId()}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    </c:if>
    </c:otherwise>
    </c:choose>
    
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty pendingOrder}">
    <div class="col-md-8">
        <div class="card-body">
        
        <c:if test="${empty pendingOrder.employee}">
        <h3>Отложенный заказ</h3>
        </c:if>
        
        <c:if test="${not empty pendingOrder.employee}">
        <h3>Заказ на изготовление</h3>
        </c:if>


            <p class="card-text" style="color: #800000;">Медикаменты</p>
            <c:if test="${not empty orderMeds}">
            
            <table class="table table-success">
            <thead>
            <tr>
                <th scope="col">Медикамент</th>
                <th scope="col">Количество</th>
                <th scope="col">Рецепт от врача</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orderMeds}" var="orderMed">
                <tr class="table-light" style="color:black;">
                    <td>${orderMed.medicament.name}</td>
                    <td>${orderMed.quantity} шт</td>
                    <c:if test="${orderMed.medicament.availabilityOfPrescription == 1}">
                    <td><a href="prescription.html?id=${orderMed.prescription.getId()}&idPO=${pendingOrder.getId()}">Рецепт</a></td>
                    </c:if>
                    <td>
                    <a href="goAddOrderMed.html?id=${orderMed.getId()}&pendingOrderId=${pendingOrder.getId()}">
                    <button type="button" class="btn btn-warning">Изменить</button>
                    </a>
                    </td>
                    <td>
                    <a href="deleteOrderMed.html?id=${orderMed.getId()}&pendingOrderId=${pendingOrder.getId()}">
                    <button type="button" class="btn btn-danger">Удалить</button></a>
                    </td>
                    
                </tr>
                </c:forEach>
            </tbody>
            </table>
            </c:if>

            
            <p class="card-text" style="color: #800000;">Заказ: ID <span style="color: black;">${pendingOrder.order.getId()}</span></p>
            
            <p class="card-text" style="color: #800000;">Дата регистрации: <span style="color: black;">${pendingOrder.order.date}</span></p>

            <p class="card-text" style="color: #800000;">Дата взятия: <span style="color: black;">${pendingOrder.availabilityDate}</span></p>

            <p class="card-text" style="color: #800000;">Статус взятия: <span style="color: black;">${pendingOrder.takeStatus}</span></p>
            
            <c:if test="${not empty pendingOrder.employee}">
            <p class="card-text" style="color: #800000;">ФИО изготовителя: <span style="color: black;">${pendingOrder.employee.fullName}</span></p>
            </c:if>
            
        </div>
    <a href="goAddPendingOrder.html?id=${pendingOrder.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
    </a>
    <a href="deletePendingOrder.html?id=${pendingOrder.getId()}">
        <button type="button" class="btn btn-danger">Удалить</button>
    </a>
    </div>
</c:if>

<c:if test="${empty pendingOrder}">
<h4> Заказ не найден. </h4>
</c:if>
    
</div>

</ui:html>