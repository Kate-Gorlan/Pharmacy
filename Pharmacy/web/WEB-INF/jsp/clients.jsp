<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Клиенты" thema="flatly">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="goAddClient.html?id=-1">
    <button type="button" class="btn btn-outline-info" style="width: 100%; height: 100px; font-size: 300%;">
    +</button></a>
</div>
<!-- <div class="container"> -->
<body style="width:100%;height:100%;">
<div style="width: 85%; overflow:auto; overflow-x:hidden;">
    <c:if test="${not empty clients}">
         <div class="card-deck">
            <c:forEach items="${clients}" var="client">
                <div class="card mb-3" style="max-width: 300px; min-width: 300px;">
                    <div class="row no-gutters">
                        <div class="col-md-8">
                            <div class="card-body">
                                <h4>${client.fullName}</h4>
                                <p class="card-text">Возраст: ${client.age}</p>
                                <p class="card-text">Адрес: ${client.address}</p>
                                <p class="card-text">Телефон: +375${client.phone}</p>
                             </div>
                            <a href="goAddClient.html?id=${client.getId()}">
                            <button type="button" class="btn btn-warning" style="float: right;">Изменить</button>
                            </a>
                            <a href="deleteClient.html?id=${client.getId()}"><button type="button" style="float: right;" class="btn btn-outline-danger" data-toggle="modal" 
                            data-target="#exampleModalCenter">Удалить</button></a>
                       
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>   
        </c:if>
</div>
</body>
</ui:html>