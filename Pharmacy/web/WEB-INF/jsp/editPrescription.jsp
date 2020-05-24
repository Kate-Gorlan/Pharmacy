<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>

<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">

<title>Добавление рецепта на медикамент</title>
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
        
            <c:url value="/prescriptionAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty prescriptions}">
                        <c:set var="prescription" value="${prescriptions}"/>
                        <input type="hidden" name="id" value="${prescription.id}" />
                        </c:if>
                </div>
                
                <!-- medicament.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Медикамент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <option selected value="${prescription.medicament.id}">${prescription.medicament.name}</option>
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    
                </div>
                
                <!-- client.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Клиент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                    <select class="livesearch" name="client.id" style="width: 100%;">
                    <c:forEach items="${cls}" var="cl">
                    <option value="${cl.id}">${cl.fullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                    <select class="livesearch" name="client.id" style="width: 100%;">
                    <option selected value="${prescription.client.id}">${prescription.client.fullName}</option>
                    <c:forEach items="${cls}" var="cl">
                    <option value="${cl.id}">${cl.fullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    
                </div>
                
                <!-- doctor.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F; color:black;">Врач</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                    <select class="livesearch" name="doctor.id" style="width: 100%;">
                    <c:forEach items="${dcs}" var="dc">
                    <option value="${dc.id}">${dc.doctorFullName}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                    <select class="livesearch" name="doctor.id" style="width: 100%;">
                    <option selected value="${prescription.doctor.id}">${prescription.doctor.doctorFullName}</option>
                    <c:forEach items="${dcs}" var="dc">
                    <option value="${dc.id}">${dc.doctorFullName}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    
                </div>
                
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Количество медикамента</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                            <input required type="text" name="amountOfMedicine" class="form-control" placeholder="Введите количество (мг/мл)"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                        <input required type="text" name="amountOfMedicine" value="${prescription.amountOfMedicine}" class="form-control" placeholder="Введите количество (мг/мл)"/>
                    </c:otherwise>
                    </c:choose>
                </div>

                <!-- diagnosis -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F; color:black;">Диагноз</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                            <input required type="text" maxlength="40" name="diagnosis" class="form-control" placeholder="Введите диагноз"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                        <input required type="text" maxlength="40" name="diagnosis" value="${prescription.diagnosis}" class="form-control" placeholder="Введите диагноз"/>
                    </c:otherwise>
                    </c:choose>
                </div>

                <!-- signature -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Роспись врача</div>
                    </div>
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                            <p><input type="checkbox" name="signature" value="1"/> Присутствует</p>
                        </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                        
                        <c:choose>
                        <c:when test="${prescription.seal == 1}">
                            <p><input type="checkbox" name="signature" checked="checked" value="1" /> Присутствует</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="checkbox" name="signature" value="1"/> Присутствует</p>
                        </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                    </c:choose>
                    </div>
                </div>
                
                <!-- seal -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F; color:black;">Печать</div>
                    </div>
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty prescriptions}">
                            <p><input type="checkbox" name="seal" value="1"/> Присутствует</p>
                        </c:when>
                    <c:otherwise>
                        <c:set var="prescription" value="${prescriptions}"/>
                        
                        <c:choose>
                        <c:when test="${prescription.seal == 1}">
                            <p><input type="checkbox" name="seal" checked="checked" value="1" /> Присутствует</p>
                        </c:when>
                        <c:otherwise>
                            <p><input type="checkbox" name="seal" value="1"/> Присутствует</p>
                        </c:otherwise>
                        </c:choose>
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