<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление медикамента</title>
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
        
            <c:url value="/medicamentAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty medicaments}">
                        <c:set var="medicament" value="${medicaments}"/>
                        <input type="hidden" name="id" value="${medicament.id}" />
                        </c:if>
                </div>
                
                <!-- name -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F;">Название</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicaments}">
                            <input required type="text" maxlength="40" name="name" class="form-control" placeholder="Введите название"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicament" value="${medicaments}"/>
                        <input required type="text" maxlength="40" name="name" value="${medicament.name}" class="form-control" placeholder="Введите название"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- modeOfApplication -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" >Применение</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicaments}">
                            <p><input type="radio" name="modeOfApplication" value="Внутреннее"/>Внутреннее</p>
                            <p><input type="radio" name="modeOfApplication" value="Наружное" />Наружное</p>
                            <p><input type="radio" name="modeOfApplication" value="Наружное и внутренее" />Наружное и внутренее</p>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicament" value="${medicaments}"/>
                        
                        <c:choose>
                        <c:when test="${medicament.modeOfApplication == 'Внутреннее'}">
                            <p><input type="radio" name="modeOfApplication" checked="checked" value="Внутреннее" />Внутреннее</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="modeOfApplication" value="Внутреннее"/>Внутреннее</p>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when test="${medicament.modeOfApplication == 'Наружное'}">
                            <p><input type="radio" name="modeOfApplication" checked="checked" value="Наружное" />Наружное</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="modeOfApplication" value="Наружное"/>Наружное</p>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when test="${medicament.modeOfApplication == 'Наружное и внутренее'}">
                            <p><input type="radio" name="modeOfApplication" checked="checked" value="Наружное и внутренее" />Наружное и внутренее</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="modeOfApplication" value="Наружное и внутренее"/>Наружное и внутренее</p>
                        </c:otherwise>
                        </c:choose>
                        
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- type -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Тип медикамента</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicaments}">
                            <input required type="text" maxlength="40" name="type" class="form-control" placeholder="Введите тип">
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicament" value="${medicaments}"/>
                        <input required type="text" maxlength="40" name="type" value="${medicament.type}" class="form-control" placeholder="Введите тип">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- availabilityOfPrescription -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Необходимость рецепта от врача</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicaments}">
                            <p><input type="radio" name="availabilityOfPrescription" value="1"/>Необходим</p>
                            <p><input type="radio" name="availabilityOfPrescription" checked="checked" value="0" />Не требуется</p>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicament" value="${medicaments}"/>
                        
                        <c:choose>
                        <c:when test="${medicament.availabilityOfPrescription == 1}">
                            <p><input type="radio" name="availabilityOfPrescription" checked="checked" value="1" />Необходим</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="availabilityOfPrescription" value="1"/>Необходим</p>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when test="${medicament.availabilityOfPrescription == 0}">
                            <p><input type="radio" name="availabilityOfPrescription" checked="checked" value="0" />Не требуется</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="availabilityOfPrescription" value="0"/>Не требуется</p>
                        </c:otherwise>
                        </c:choose>
                        
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- manufacturability -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text">Возможность изготовления</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty medicaments}">
                            <p><input type="radio" name="manufacturability" value="1"/>Изготовляется</p>
                            <p><input type="radio" name="manufacturability" value="0" />Не изготовляется</p>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicament" value="${medicaments}"/>
                        
                        <c:choose>
                        <c:when test="${medicament.manufacturability == 1}">
                            <p><input type="radio" name="manufacturability" checked="checked" value="1" />Изготовляется</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="manufacturability" value="1"/>Изготовляется</p>
                        </c:otherwise>
                        </c:choose>
                        <c:choose>
                        <c:when test="${medicament.manufacturability == 0}">
                            <p><input type="radio" name="manufacturability" checked="checked" value="0" />Не изготовляется</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="radio" name="manufacturability" value="0"/>Не изготовляется</p>
                        </c:otherwise>
                        </c:choose>
                        
                    </c:otherwise>
                    </c:choose>
                </div>
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>

</body>
</html>