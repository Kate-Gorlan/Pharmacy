<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>

<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">

<title>Добавление поставки медикамента</title>
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
        
            <c:url value="/stockMedicamentAdd.html?page=1" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty medicamentStocks}">
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input type="hidden" name="id" value="${medicamentStock.id}" />
                        </c:if>
                </div>
                <!-- medicament.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Медикамент</div>
                    </div>
                    <!--  
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required type="text" name="medicament.id" class="form-control" placeholder="Введите ID медикамента">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required type="text" name="medicament.id" value="${medicamentStock.medicament.id}" class="form-control" placeholder="Введите ID медикамента">
                    </c:otherwise>
                    </c:choose> -->
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <option selected value="${medicamentStock.medicament.id}">${medicamentStock.medicament.name}</option>
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
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Количество (штук)</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required type="text" name="quantity" class="form-control" placeholder="Введите количество"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required type="text" name="quantity" value="${medicamentStock.quantity}" class="form-control" placeholder="Введите количество"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- price -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Цена за поставку</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required type="text" name="price" class="form-control" placeholder="Введите цену за поставку">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required type="text" name="price" value="${medicamentStock.price}" class="form-control" placeholder="Введите цену за поставку">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- shelfLife -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Срок годности в днях</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required type="text" name="shelfLife" class="form-control" placeholder="Введите срок годности в днях">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required type="text" name="shelfLife" value="${medicamentStock.shelfLife}" class="form-control" placeholder="Введите срок годности в днях">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- dateOfArrival -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Дата поставки</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required maxlength="10" type="text" name="dateOfArrival" class="form-control" placeholder="Введите дату поставки">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required maxlength="10" type="text" name="dateOfArrival" value="${medicamentStock.dateOfArrival}" class="form-control" placeholder="Введите дату поставки">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- criticalNorm -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Критическая норма</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicamentStocks}">
                            <input required type="text" name="criticalNorm" class="form-control" placeholder="Введите количество дней">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${medicamentStocks}"/>
                        <input required type="text" name="criticalNorm" value="${medicamentStock.criticalNorm}" class="form-control" placeholder="Введите количество дней">
                    </c:otherwise>
                    </c:choose>
                </div>     
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.jquery.min.js"></script>
<script type="text/javascript">
      $(".livesearch").chosen();
</script>
<div style="height: 50px;"></div>
</body>
</html>