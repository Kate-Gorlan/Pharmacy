<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Заказ" thema="flatly">

<div style="width: 20%; height: 100vh; overflow:auto; float:left;">
</div>

<div style="width: 63%; overflow:auto;">

<c:if test="${not empty order}">
    <div class="col-md-8">
        <div class="card-body">

            <p class="card-text" style="color: black; text-align: center">Подтверждение оплаты</p>
            <c:if test="${not empty orderMeds}">
            
            <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Товар</th>
                <th scope="col">Количество</th>
                <th scope="col">Цена</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orderMeds}" var="orderMed">
                <tr class="table-active">
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
                    
                </tr>
                </c:forEach>
            </tbody>
            </table>
            </c:if>

            <c:if test="${not empty costAll}">
            <h5>К оплате: ${costAll}</h5>
            </c:if>

            <p class="card-text" style="color: #800000;">Кассир: <span style="color: black;">${order.employee.fullName}</span></p>
            
            <p class="card-text" style="color: #800000;">Дата: <span style="color: black;">${order.date}</span></p>

        </div>


        <a href="order.html?id=${order.getId()}&pendingOrder=0">
            <button type="button" class="btn btn-danger">Отменить</button>
        </a>

        <a href="goAddSale.html?id=${order.getId()}">
            <button type="button" class="btn btn-success">Подтвердить оплату</button>
        </a>

    </div>
</c:if>

    
</div>

<div style="width: 20%; height: 100vh; overflow:auto; float:right;">
</div>
</ui:html>