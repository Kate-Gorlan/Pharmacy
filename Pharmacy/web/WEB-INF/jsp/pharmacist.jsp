<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Фармацевт" thema="flatly">
<body style="width:100%;height:100%;">
<div class="container text-center">

    <div class="mt-4">
        <div class="container text-center">
            <div class="card-deck">
            
                <div class="card border-primary mb-4 " style="max-width: 250px;">
                    <img src="resources/mainSite/sell.png" class="card-img-top" alt="Продажа">
                    <div class="card-body">
                        <h5 class="card-title text-center ">Продажа</h5>
                        <p class="card-text">Оформить продажу</p>
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
                        <p class="card-text">Оформить отложенный заказ</p>
                    </div>
                    <div class="card-footer">
                        <div class="card text-center">
                            <a href="serials.html?view=all&category=to do" class="btn btn-primary">Перейти</a>
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
                            <a href="mangas.html?view=all&category=to do" class="btn btn-primary">Перейти</a>
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
</div>
</body>
</ui:html>