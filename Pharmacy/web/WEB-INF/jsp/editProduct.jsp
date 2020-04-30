<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление продукта</title>
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
        
            <c:url value="/productAdd.html?page=${page}" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty products}">
                        <c:set var="product" value="${products}"/>
                        <input type="hidden" name="id" value="${product.id}" />
                        </c:if>
                </div>
                <!-- name -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Название продукта</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty products}">
                            <input required maxlength="80" type="text" name="name" class="form-control" placeholder="Введите название продукта">
                        </c:when>
                    <c:otherwise>
                        <c:set var="product" value="${products}"/>
                        <input required maxlength="80" type="text" name="name" value="${product.name}" class="form-control" placeholder="Введите название продукта">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- type -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Тип продукта</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty products}">
                            <input required maxlength="40" type="text" name="type" class="form-control" placeholder="Введите тип продукта"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="product" value="${products}"/>
                        <input required maxlength="40" type="text" name="type" value="${product.type}" class="form-control" placeholder="Введите тип продукта"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>

</body>
</html>