<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Продажа" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="orders.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
    
    <c:if test="${idPO == 0}">
    <h5 style="border: 10px solid white;"> 
    Добавить медикамент </h5>
    <a href="goAddOrderMed.html?id=-1&pendingOrderId=0&orderId=${order.getId()}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
    <h5 style="border: 10px solid white;"> 
    Отложить заказ</h5>
    <a href="goAddPendingOrder.html?id=-1&idOrder=${order.getId()}">
    <button type="button" class="btn btn-outline-warning" style="width: 100%; height: 100px; font-size: 130%;">
    Отложить</button></a>
    </c:if>
    
    <c:if test="${idPO != 0}">
    <h5 style="border: 10px solid white;"> 
    Данный заказ отложен</h5>
    <a href="pendingOrder.html?id=${idPO}&idOrder=${order.getId()}">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 130%;">
    Перейти к отложенному заказу</button></a>
    </c:if>
    
    <h5 style="border: 10px solid white;"> 
    Перейти к рецептам на медикаменты </h5>
    <a href="prescriptions.html" target="_blank">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    К рецептам</button></a>


</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty order}">
    <div class="col-md-8">
        <div class="card-body">

            <p class="card-text" style="color: #800000;">Медикаменты</p>
            <c:if test="${not empty orderMeds}">
            
            <table class="table table-success">
            <thead>
            <tr>
                <th scope="col">Медикамент</th>
                <th scope="col">Количество</th>
                <th scope="col">Цена</th>
                <th scope="col">Рецепт от врача</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orderMeds}" var="orderMed">
                <tr class="table-light" style="color:black;">
                    <td>${orderMed.medicament.name}</td>
                    <td>${orderMed.quantity} шт</td>
                    <c:if test="${not empty medCosts}">
                    <td>
                    <c:forEach items="${medCosts}" var="medCost">
                        <c:if test="${medCost.getId()==orderMed.getId()}">
                        ${medCost.cost}
                        </c:if>
                    </c:forEach>
                    </td>
                    </c:if>
                    <td>
                    <c:if test="${orderMed.medicament.availabilityOfPrescription == 1}">
                    <a href="prescription.html?id=${orderMed.prescription.getId()}&idPO=-1" target="_blank">Рецепт</a>
                    </c:if>
                    </td>
                    <td>
                    <a href="goAddOrderMed.html?id=${orderMed.getId()}&pendingOrderId=0&orderId=${order.getId()}">
                    <button type="button" class="btn btn-warning">Изменить</button>
                    </a>
                    </td>
                    <td>
                    <a href="deleteOrderMed.html?id=${orderMed.getId()}&pendingOrderId=0&orderId=${order.getId()}">
                    <button type="button" class="btn btn-danger">Удалить</button></a>
                    </td>
                    
                </tr>
                </c:forEach>
            </tbody>
            </table>
            </c:if>

            <c:if test="${not empty costAll}">
            <h5>Итоговая цена: ${costAll}</h5>
            </c:if>
            
            <p class="card-text" style="color: #800000;">Заказ: ID <span style="color: black;">${order.getId()}</span></p>
            
            <p class="card-text" style="color: #800000;">Клиент: <span style="color: black;">${fullName}</span></p>
            
            <p class="card-text" style="color: #800000;">Дата регистрации: <span style="color: black;">${order.date}</span></p>

            
        </div>

    <a href="goAddOrder.html?id=${order.getId()}&pendingOrder=0">
        <button type="button" class="btn btn-warning">Изменить</button>
    </a>
    <a href="deleteOrder.html?id=${order.getId()}&pendingOrder=0">
        <button type="button" class="btn btn-danger">Удалить</button>
    </a>
    
        
        <c:if test="${not empty sale}">
        <a href="goSaleOrder.html?id=${order.getId()}">
        <button type="button" class="btn btn-success">Оплатить</button>
        </a>
        </c:if>
        
    </div>
</c:if>

<c:if test="${empty order}">
<h4> Заказ не найден. </h4>
</c:if>
    
</div>

</ui:html>