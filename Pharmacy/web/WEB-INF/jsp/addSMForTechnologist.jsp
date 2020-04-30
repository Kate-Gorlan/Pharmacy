<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление изготовленного медикамента</title>
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
        
            <c:url value="/stockMedicamentAdd.html?page=2" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                </div>
                <!-- medicament.id -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">ID медикамента</div>
                    </div>
                    
                        <input required type="text" name="medicament.id" value="${medicamentId}" class="form-control" placeholder="Введите ID медикамента">
                
                </div>
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Количество (штук)</span>
                    </div>

                        <input required type="text" name="quantity" value="1" class="form-control" placeholder="Введите количество"/>

                </div>
                <!-- price -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Цена за поставку</div>
                    </div>

                        <input required type="text" name="price" value="${price}" class="form-control" placeholder="Введите цену за поставку">

                </div>
                <!-- shelfLife -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Срок годности в днях</div>
                    </div>

                            <input required type="text" name="shelfLife" class="form-control" placeholder="Введите срок годности в днях">
                        
                </div>
                <!-- dateOfArrival -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Дата поставки</div>
                    </div>

                            <input required maxlength="10" type="text" name="dateOfArrival" class="form-control" placeholder="Введите дату поставки">
                       
                </div>
                <!-- criticalNorm -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Критическая норма</div>
                    </div>

                            <input required type="text" name="criticalNorm" class="form-control" placeholder="Введите количество дней">
                       
                </div>     
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>

</body>
</html>