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
        
            <c:url value="/pendingOrderAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty pendingOrders}">
                        <c:set var="pendingOrder" value="${pendingOrders}"/>
                        <input type="hidden" name="id" value="${pendingOrder.id}" />
                        </c:if>
                </div>
                
                <!-- employee -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; color:black;">Изготовитель</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty pendingOrders}">
                    <select class="livesearch" name="employee.id" style="width: 100%;">
                    <c:forEach items="${empls}" var="employee">
                    <option value="${employee.id}">${employee.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="pendingOrder" value="${pendingOrders}"/>
                    <select class="livesearch" name="employee.id" style="width: 100%;">
                    <option selected value="${pendingOrder.employee.id}">${pendingOrder.employee.fullName}</option>
                    <c:forEach items="${empls}" var="employee">
                    <option value="${employee.id}">${employee.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                <!-- order -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">ID заказа</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty pendingOrders}">
                            <input type="text" value="${idOrder}" name="order.id" class="form-control" placeholder="Введите id заказа">
                        </c:when>
                    <c:otherwise>
                        <c:set var="pendingOrder" value="${pendingOrders}"/>
                        <input type="text" name="order.id" value="${pendingOrder.order.id}" class="form-control" placeholder="Введите id заказа">
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <!-- availabilityDate -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Дата взятия</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty pendingOrders}">
                            <input maxlength="10" type="text" name="availabilityDate" class="form-control" placeholder="Введите дату, когда клиент может забрать заказ">
                        </c:when>
                    <c:otherwise>
                        <c:set var="pendingOrder" value="${pendingOrders}"/>
                        <input maxlength="10" type="text" name="availabilityDate" value="${pendingOrder.availabilityDate}" class="form-control" placeholder="Введите дату, когда клиент может забрать заказ">
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <!-- status -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Статус</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty pendingOrders}">
                            <select class="custom-select" name="takeStatus" id="inputGroupSelect01">
                                <option selected value="В ожидании"> В ожидании </option>
                                <option value="В ожидании"> В ожидании </option>
                                <option value="Взято"> Взято </option>
                                <option value="Взято с опозданием"> Взято с опозданием </option>
                                <option value="Не взято"> Не взято </option>
                                <option value="Изготовлено"> Изготовлено </option>
                            </select>
                        </c:when>
                    <c:otherwise>
                        <c:set var="pendingOrder" value="${pendingOrders}"/>
                            <select class="custom-select" name="takeStatus" id="inputGroupSelect01">
                                <option selected>${pendingOrder.takeStatus}</option>
                                <option value="В ожидании"> В ожидании </option>
                                <option value="Взято"> Взято </option>
                                <option value="Взято с опозданием"> Взято с опозданием </option>
                                <option value="Не взято"> Не взято </option>
                                <option value="Изготовлено"> Изготовлено </option>
                            </select>
                    </c:otherwise>
                    </c:choose>
                </div>
                

                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
<div style="height: 50px;"></div>
</body>
</html>