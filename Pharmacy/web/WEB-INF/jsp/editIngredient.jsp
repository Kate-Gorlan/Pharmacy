<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>

<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">

<title>Добавление ингредиента рецепта</title>
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
        
            <c:url value="/ingredientAdd.html?recipeId=${recipeId}" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty ingrs}">
                        <c:set var="ingr" value="${ingrs}"/>
                        <input type="hidden" name="id" value="${ingr.id}" />
                        </c:if>
                        
                </div>
                <div class="input-group mb-3">
                <input type="hidden" name="recipeMedicament.id" value="${recipeId}" />
                </div>
                <!-- product.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Продукт</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty ingrs}">
                    <select class="livesearch" name="product.id" style="width: 100%;">
                    <c:forEach items="${prods}" var="prod">
                    <option value="${prod.id}">${prod.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="ingr" value="${ingrs}"/>
                    <select class="livesearch" name="product.id" style="width: 100%;">
                    
                    <option selected value="${ingr.product.id}">
                    
                    <c:forEach items="${prods}" var="prod">
                    <c:if test="${prod.id == ingr.product.id}">${prod.name}</c:if>
                    </c:forEach>
                    
                    </option>
                    
                    <c:forEach items="${prods}" var="prod">
                    <option value="${prod.id}">${prod.name}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    
                </div>
                
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Количество продукта</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty ingrs}">
                            <input required type="text" name="quantity" class="form-control" placeholder="Введите количество (мг/мл)"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="ingr" value="${ingrs}"/>
                        <input required type="text" name="quantity" value="${ingr.quantity}" class="form-control" placeholder="Введите количество (мг/мл)"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <!-- timeForPreparing -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Время изготовления</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty ingrs}">
                            <input required type="text" name="timeForPreparing" class="form-control" placeholder="Введите время изготовления ингредиента (мин)"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="ingr" value="${ingrs}"/>
                        <input required type="text" name="timeForPreparing" value="${ingr.timeForPreparing}" class="form-control" placeholder="Введите время изготовления ингредиента (мин)"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <!-- money -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Цена изготовления</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty ingrs}">
                            <input required type="text" name="money" class="form-control" placeholder="Введите цену изготовления ингредиента"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="ingr" value="${ingrs}"/>
                        <input required type="text" name="money" value="${ingr.money}" class="form-control" placeholder="Введите цену изготовления ингредиента"/>
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<div style="height: 50px;"></div>
</body>
</html>