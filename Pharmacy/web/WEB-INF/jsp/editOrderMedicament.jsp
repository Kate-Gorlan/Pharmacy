<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление медикамента в заказ</title>
</head>
<meta charset="utf-8"/>
<body>
    <div class="container" style="width: 70%;">
        
        <c:choose>
        <c:when test="${empty errors}">
        </c:when>
        <c:otherwise>
        <c:forEach items="${errors}" var="e">
            <div class="alert alert-warning" role="alert">Error: ${e}
            </div>
        </c:forEach>         
        </c:otherwise>
        </c:choose>
        
            <c:url value="/orderMedAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty orderMeds}">
                        <c:set var="orderMed" value="${orderMeds}"/>
                        <input type="hidden" name="id" value="${orderMed.id}" />
                        </c:if>
                </div>
                
                <!--
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Фармацевт</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty orders}">
                    <select class="livesearch" name="employee.id" style="width: 100%;">
                    <c:forEach items="${empls}" var="employee">
                    <option value="${employee.id}">${employee.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="order" value="${orders}"/>
                    <select class="livesearch" name="employee.id" style="width: 100%;">
                    <option selected value="${order.employee.id}">${order.employee.fullName}</option>
                    <c:forEach items="${empls}" var="employee">
                    <option value="${employee.id}">${employee.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Дата</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty orders}">
                            <input maxlength="10" type="text" name="date" class="form-control" placeholder="Введите дату регистрации заказа">
                        </c:when>
                    <c:otherwise>
                        <c:set var="order" value="${orders}"/>
                        <input maxlength="10" type="text" name="date" value="${order.date}" class="form-control" placeholder="Введите дату регистрации заказа">
                    </c:otherwise>
                    </c:choose>
                </div>
                
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" 
                        <c:if test="${pendingOrder == 1}">style="width: 100%; color:black;"</c:if>
                        <c:if test="${pendingOrder != 1}">style="width: 100%; background-color: #F7819F; color:black;"</c:if> >Клиент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty orders}">
                    <select <c:if test="${pendingOrder == 1}">required</c:if> class="livesearch" name="client.id" style="width: 100%;">
                    <c:forEach items="${clients}" var="client">
                    <option value="${client.id}">${client.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="order" value="${orders}"/>
                    <select <c:if test="${pendingOrder == 1}">required</c:if> class="livesearch" name="client.id" style="width: 100%;">
                    <option selected value="${order.client.id}">${order.client.fullName}</option>
                    <c:forEach items="${clients}" var="client">
                    <option value="${client.id}">${client.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                -->
                

                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
<div style="height: 50px;"></div>
</body>
</html>