<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<title>Добавление врача</title>
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
        
            <c:url value="/doctorAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty doctors}">
                        <c:set var="doctor" value="${doctors}"/>
                        <input type="hidden" name="id" value="${doctor.id}" />
                        </c:if>
                </div>
                <!-- fullName -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">ФИО</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty doctors}">
                            <input required maxlength="80" type="text" name="doctorFullName" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите фио">
                        </c:when>
                    <c:otherwise>
                        <c:set var="doctor" value="${doctors}"/>
                        <input required maxlength="80" type="text" name="doctorFullName" value="${doctor.doctorFullName}" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Введите фио">
                    </c:otherwise>
                    </c:choose>
                </div>
               
               
                <button style="font-size: 120%; width: 40%; margin: 0 auto;" type="submit" class="btn btn-primary">Добавить</button>
            </form>
        </div>
<div style="height: 50px;"></div>
</body>
</html>