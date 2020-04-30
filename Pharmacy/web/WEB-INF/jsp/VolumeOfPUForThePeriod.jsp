<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
<title>Ввод данных</title>
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
        
            <c:url value="/productProgress.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                </div>
                <!-- name 
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Название продукта</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty name}">
                            <input required type="text" name="name" class="form-control" placeholder="Введите название продукта">
                        </c:when>
                    <c:otherwise>
                        <input required type="text" name="name" value="${name}" class="form-control" placeholder="Введите название продукта">
                    </c:otherwise>
                    </c:choose>
                </div> -->
                <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Продукт</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty name}">
                    <select class="livesearch" name="name" style="width: 100%;">
                    <c:forEach items="${prods}" var="product">
                    <option value="${product.name}">${product.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${productStocks}"/>
                    <select class="livesearch" name="name" style="width: 100%;">
                    <option selected value="${name}">${name}"</option>
                    <c:forEach items="${prods}" var="product">
                    <option value="${product.name}">${product.name}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                
                <!-- fd -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Дата начала периода</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty fd}">
                            <input required type="text" maxlength="10" name="fd" class="form-control" placeholder="Введите дату"/>
                        </c:when>
                    <c:otherwise>
                        <input required type="text" maxlength="10" name="fd" value="${fd}" class="form-control" placeholder="Введите дату"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- sd -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Дата конца периода</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty sd}">
                            <input required type="text" maxlength="10" name="sd" class="form-control" placeholder="Введите дату">
                        </c:when>
                    <c:otherwise>
                        <input required type="text" maxlength="10" name="sd" value="${sd}" class="form-control" placeholder="Введите дату">
                    </c:otherwise>
                    </c:choose>
                </div>
                  
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Найти</button>
            </form>
        </div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.jquery.min.js"></script>
<script type="text/javascript">
      $(".livesearch").chosen();
</script>

</body>
</html>