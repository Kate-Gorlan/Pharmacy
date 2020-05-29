<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
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
        
            <c:url value="/orderMedAdd.html?pendingOrderId=${pendingOrderId}&orderId=${orderID}" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty oms}">
                        <c:set var="orderMed" value="${oms}"/>
                        <input type="hidden" name="id" value="${orderMed.id}" />
                        </c:if>
                        
                        <c:if test="${not empty orderID}">
                        <c:set var="orderId" value="${orderID}"/>
                        <input type="hidden" name="order.id" value="${orderId}" />
                        </c:if>
                </div>
                
                <!-- medicament.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Медикамент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty oms}">
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="orderMed" value="${oms}"/>
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <option selected value="${orderMed.medicament.id}">
                    
                    <c:forEach items="${meds}" var="med">
                    <c:if test="${med.id == orderMed.medicament.id}">${med.name}</c:if>
                    </c:forEach>
                    
                    </option>
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Количество</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty oms}">
                            <input required type="text" name="quantity" class="form-control" placeholder="Введите количество"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="om" value="${oms}"/>
                        <input required type="text" name="quantity" value="${om.quantity}" class="form-control" placeholder="Введите количество"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <!-- prescription.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; color:black;">Рецепт</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty oms}">
                    <select class="livesearch" name="prescription.id" style="width: 100%;">
                    <option value="0">Без рецепта</option>
                    <c:forEach items="${prs}" var="pr">
                    <option value="${pr.id}">Медикамент: ${pr.medicament.name} Клиент: ${pr.client.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="orderMed" value="${oms}"/>
                    <select class="livesearch" name="prescription.id" style="width: 100%;">
                    
                    <!-- option selected value="${orderMed.prescription.id}">
                    Медикамент: ${orderMed.prescription.medicament.name}
                     Клиент: ${orderMed.prescription.client.fullName}</option>-->
                    
                    <option selected value="${orderMed.prescription.id}">
                    
                    <c:forEach items="${prs}" var="pr">
                    <c:if test="${pr.id == orderMed.prescription.id}">Медикамент: ${pr.medicament.name} Клиент: ${pr.client.fullName}</c:if>
                    </c:forEach>
                    
                    </option>
                    
                    <option value="0">Без рецепта</option>
                    <c:forEach items="${prs}" var="pr">
                    <option value="${pr.id}">Медикамент: ${pr.medicament.name} Клиент: ${pr.client.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                

                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
        
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.jquery.min.js"></script>
<script type="text/javascript">
      $(".livesearch").chosen();
</script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<div style="height: 50px;"></div>
</body>
</html>