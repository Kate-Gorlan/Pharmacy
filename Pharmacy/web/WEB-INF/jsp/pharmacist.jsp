<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">
<ui:html title="Фармацевт" thema="flatly">

<div class="container text-center">

    <div class="mt-4">
        <div class="container text-center">
            <div class="card-deck">
            
                <div class="card border-primary mb-4 " style="max-width: 250px;">
                    <img src="resources/mainSite/sell.png" class="card-img-top" alt="Продажа">
                    <div class="card-body">
                        <h5 class="card-title text-center ">Продажа</h5>
                        <p class="card-text">Оформить\Оплатить продажу</p>
                    </div>
                    <div class="card-footer">
                        <div class="card text-center">
                            <a href="books.html?view=all&category=to do" class="btn btn-primary">Перейти</a>
                        </div>
                    </div>
                </div>
                
                <div class="card border-primary mb-4 " style="max-width: 250px;">
                    <img src="resources/mainSite/pendingOrder.png" class="card-img-top" alt="Заказ">
                    <div class="card-body">
                        <h5 class="card-title text-center">Заказ</h5>
                        <p class="card-text">Оформить\Оплатить отложенный заказ</p>
                    </div>
                    <div class="card-footer">
                        <div class="card text-center">
                            <a href="pendingOrders.html" class="btn btn-primary">Перейти</a>
                        </div>
                    </div>
                </div>
                
                <div class="card border-primary mb-4 " style="max-width: 250px;">
                    <img src="resources/mainSite/clients.png" class="card-img-top" alt="Клиенты">
                    <div class="card-body">
                        <h5 class="card-title text-center">Клиенты</h5>
                        <p class="card-text">Управление клиентами</p>
                    </div>
                    <div class="card-footer">
                        <div class="card text-center">
                            <a href="clients.html" class="btn btn-primary">Перейти</a>
                        </div>
                    </div>
                </div>
            

                    <div class="card border-primary mb-4 " style="max-width: 250px;">
                        <img src="resources/mainSite/request.png" class="card-img-top" alt="Заявки">
                        <div class="card-body">
                            <h5 class="card-title text-center ">Заявки</h5>
                            <p class="card-text">Управление заявками на заказ</p>
                        </div>
                        <div class="card-footer">
                            <div class="card text-center">
                                <a href="authors.html?view=all" class="btn btn-primary">Перейти</a>
                            </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div style="background-color: white; border-bottom: 5px solid #bed2f7; text-align: left;">
    <c:if test="${not empty medInfo}">
    <h5>${medInfo.name}</h5>
    <h6>Количество: ${medInfo.quantity}</h6>
    <h6>Цена: ${medInfo.price}</h6>
    <h6>Изготовляемость: 
    <c:if test="${medInfo.manufacturability == 1}">Изготовляется</c:if>
    <c:if test="${medInfo.manufacturability == 0}">Не изготовляется</c:if>
    </h6>
    </c:if>
    </div>
    
    <div style="background-color: #bed2f7; border-bottom: 5px solid white;">

   <h5 style="border: 10px solid #bed2f7;"> Проверить медикамент</h5> 
   <c:url value="/pharmacistInfo.html" var="href" />
   <form action="${href}" accept-charset="UTF-8" method="POST">
   <div class="input-group mb-3" style="border: 5px solid #bed2f7; text-align: left;">
   
        <select class="livesearch" name="idMed" style="width: 100%;">
        <c:forEach items="${meds}" var="med">
        <option value="${med.id}">${med.name}</option>
        </c:forEach>
        </select>
                    
   </div>
   <button style="margin: 0 auto; border: 5px solid #bed2f7;" type="submit" class="btn btn-primary">Проверить</button>
   </form>
    
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.jquery.min.js"></script>
<script type="text/javascript">
      $(".livesearch").chosen();
</script>
</ui:html>