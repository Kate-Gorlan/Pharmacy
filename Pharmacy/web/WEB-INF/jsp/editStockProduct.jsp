<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление поставки продукта</title>
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
        
            <c:url value="/stockProductAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty productStocks}">
                        <c:set var="productStock" value="${productStocks}"/>
                        <input type="hidden" name="id" value="${productStock.id}" />
                        </c:if>
                </div>
                <!-- product.id -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">ID продукта</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required type="text" name="product.id" class="form-control" placeholder="Введите ID продукта">
                        </c:when>
                    <c:otherwise>
                        <c:set var="productStock" value="${productStocks}"/>
                        <input required type="text" name="product.id" value="${productStock.product.id}" class="form-control" placeholder="Введите ID продукта">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F;">Количество в граммах\миллилитрах</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required type="text" name="quantity" class="form-control" placeholder="Введите количество"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="productStock" value="${productStocks}"/>
                        <input required type="text" name="quantity" value="${productStock.quantity}" class="form-control" placeholder="Введите количество"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- price -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Цена за поставку</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required type="text" name="price" class="form-control" placeholder="Введите цену за поставку">
                        </c:when>
                    <c:otherwise>
                        <c:set var="productStock" value="${productStocks}"/>
                        <input required type="text" name="price" value="${productStock.price}" class="form-control" placeholder="Введите цену за поставку">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- shelfLife -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Срок годности в днях</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required type="text" name="shelfLife" class="form-control" placeholder="Введите срок годности в днях">
                        </c:when>
                    <c:otherwise>
                        <c:set var="productStock" value="${productStocks}"/>
                        <input required type="text" name="shelfLife" value="${productStock.shelfLife}" class="form-control" placeholder="Введите срок годности в днях">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- dateOfArrival -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Дата поставки</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required maxlength="10" type="text" name="dateOfArrival" class="form-control" placeholder="Введите дату поставки">
                        </c:when>
                    <c:otherwise>
                        <c:set var="mproductStock" value="${productStocks}"/>
                        <input required maxlength="10" type="text" name="dateOfArrival" value="${productStock.dateOfArrival}" class="form-control" placeholder="Введите дату поставки">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- criticalNorm -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Критическая норма</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty productStocks}">
                            <input required type="text" name="criticalNorm" class="form-control" placeholder="Введите количество дней">
                        </c:when>
                    <c:otherwise>
                        <c:set var="productStock" value="${productStocks}"/>
                        <input required type="text" name="criticalNorm" value="${productStock.criticalNorm}" class="form-control" placeholder="Введите количество дней">
                    </c:otherwise>
                    </c:choose>
                </div>     
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>

</body>
</html>