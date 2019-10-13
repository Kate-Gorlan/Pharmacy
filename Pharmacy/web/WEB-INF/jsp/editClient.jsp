<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-sketchy.min.css">
<title>Добавление клиента</title>
</head>
<meta charset="utf-8"/>
<body>
    <div class="container" style="width: 70%;">
        <!--  div class="row"-->
        
        <c:choose>
        <c:when test="${empty errors}">
        </c:when>
        <c:otherwise>
        <c:forEach items="${errors}" var="e">
        <!--<c:set var="error" value="${errors}"/>-->
                        
            <div class="alert alert-warning" role="alert">Error: ${e}
            </div>
        </c:forEach>         
        </c:otherwise>
        </c:choose>
        
            <c:url value="/clientAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty clients}">
                        <c:set var="client" value="${clients}"/>
                        <input type="hidden" name="id" value="${client.id}" />
                        </c:if>
                </div>
                <!-- fullName -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">ФИО</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty clients}">
                            <input required maxlength="80" type="text" name="fullName" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите фио">
                        </c:when>
                    <c:otherwise>
                        <c:set var="client" value="${clients}"/>
                        <input required maxlength="80" type="text" name="fullName" value="${client.fullName}" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите фио">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- age -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F;">Возраст</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty clients}">
                            <input required maxlength="3" type="text" name="age" class="form-control" placeholder="Введите возраст"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="client" value="${clients}"/>
                        <input required maxlength="3" type="text" name="age" value="${client.age}" class="form-control" placeholder="Введите возраст"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- address -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Адрес</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty clients}">
                            <input required maxlength="80" type="text" name="address" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите адрес">
                        </c:when>
                    <c:otherwise>
                        <c:set var="client" value="${clients}"/>
                        <input required maxlength="80" type="text" name="address" value="${client.address}" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите адрес">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- phone -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Телефон  +375...</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty clients}">
                            <input required maxlength="9" type="text" name="phone" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите 9 цифр телефона">
                        </c:when>
                    <c:otherwise>
                        <c:set var="client" value="${clients}"/>
                        <input required maxlength="9" type="text" name="phone" value="${client.phone}" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите 9 цифр телефона">
                    </c:otherwise>
                    </c:choose>
                </div>
             
                
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
    <!--  /div-->

</body>
</html>
