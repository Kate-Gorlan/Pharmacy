<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление заказа</title>
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
        
            <c:url value="/orderAdd.html?pendingOrder=${pendingOrder}" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty orders}">
                        <c:set var="order" value="${orders}"/>
                        <input type="hidden" name="id" value="${order.id}" />
                        </c:if>
                </div>
                
                <!-- employee -->
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
                    <option selected value="${order.employee.id}">
                    
                    <c:forEach items="${empls}" var="employee">
                    <c:if test="${employee.id == order.employee.id}">${employee.fullName}</c:if>
                    </c:forEach>
                    
                    </option>
                    <c:forEach items="${empls}" var="employee">
                    <option value="${employee.id}">${employee.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                <!-- date 
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="color:black;">Дата</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty orders}">
                            <input maxlength="10" type="text" name="date" value="${time}" class="form-control" placeholder="Введите дату регистрации заказа">
                        </c:when>
                    <c:otherwise>
                        <c:set var="order" value="${orders}"/>
                        <input maxlength="10" type="text" name="date" value="${order.date}" class="form-control" placeholder="Введите дату регистрации заказа">
                    </c:otherwise>
                    </c:choose>
                </div>-->
                
                <!-- client -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" 
                        <c:if test="${pendingOrder != 1}">style="width: 100%; color:black;"</c:if>
                        <c:if test="${pendingOrder == 1}">style="width: 100%; background-color: #F7819F; color:black;"</c:if> >Клиент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty orders}">
                    <select <c:if test="${pendingOrder == 1}">required</c:if> class="livesearch" name="client.id" style="width: 100%;">
                    
                    <c:if test="${pendingOrder != 1}"> 
                    <option value="0">Без клиента</option>
                    </c:if>
                    
                    <c:forEach items="${clients}" var="client">
                    <option value="${client.id}">${client.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="order" value="${orders}"/>
                    <select <c:if test="${pendingOrder == 1}">required</c:if> class="livesearch" name="client.id" style="width: 100%;">
                    
                    <option selected value="${order.client.id}">
                    
                    <c:forEach items="${clients}" var="client">
                    <c:if test="${client.id == order.client.id}">${client.fullName}</c:if>
                    </c:forEach>
                    
                    </option>
                    
                    <c:if test="${pendingOrder != 1}"> 
                    <option value="0">Без клиента</option>
                    </c:if>
                    
                    <c:forEach items="${clients}" var="client">
                    <option value="${client.id}">${client.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                

                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
<div style="height: 50px;"></div>
</body>
</html>