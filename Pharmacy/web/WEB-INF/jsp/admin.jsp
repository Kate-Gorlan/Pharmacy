<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Главная страница" thema="flatly">

<div style="width: 85%; overflow:auto; overflow-x:hidden; margin:0 auto;">

    <c:if test="${not empty message}">
    <div class="alert alert-warning" role="alert"> ${message} </div>
    </c:if>
    
    <h4 style="align:center">Добавление пользователя в систему</h4>
    <c:url value="/addlogin.html" var="href1" />
    <form action="${href1}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input required maxlength="80" type="text" 
    name="login" class="form-control" id="login" placeholder="Введите логин"/>
    <input required maxlength="16" type="text" 
    name="pass" class="form-control" id="pass" placeholder="Введите пароль"/>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Добавить
    </button>
    </form>
    
    <h4 style="align:center">Удаление пользователя из системы</h4>
    <c:url value="/deletelogin.html" var="href2" />
    <form action="${href2}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input required maxlength="80" type="text" 
    name="login" class="form-control" id="login" placeholder="Введите логин"/>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Удалить
    </button>
    </form>
    
    
    <h4 style="align:center">Добавление прав пользователю</h4>
    <c:url value="/grantlogin.html" var="href3" />
    <form action="${href3}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input required maxlength="80" type="text" 
    name="login" class="form-control" id="login" placeholder="Введите логин"/>
    </div>
    
    <div class="input-group mb-3">
    <div style="margin: 0 auto;">
    <select class="custom-select" name="func" id="func">
        <option value="INSERT"> Вставка </option>
        <option value="UPDATE"> Изменение </option>
        <option value="DELETE"> Удаление </option>
    </select>
    </div>
    </div>
    
    <div class="input-group mb-3">
    <div style="margin: 0 auto;">
    <select class="custom-select" name="table" id="table">
        <option value="client"> Клиент </option>
        <option value="doctor"> Врач </option>
        <option value="prescription"> Рецепт от врача </option>
        <option value="employee"> Работник </option>
        <option value="position"> Должность </option>
        <option value="ingredient"> Ингредиент </option>
        <option value="medicament"> Медикамент </option>
        <option value="product"> Компонент </option>
        <option value="recipe_medicament"> Рецепт </option>
        <option value="order_medicament"> Товар </option>
        <option value="order"> Заказ </option>
        <option value="pending_order"> Отложенный заказ </option>
        <option value="sale"> Продажа </option>
        <option value="medicament_stock"> Склад медикаментов </option>
        <option value="product_stock"> Склад компонентов </option>
    </select>
    </div>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Добавить
    </button>
    </form>
     
         <h4 style="align:center">Удаление прав пользователю</h4>
    <c:url value="/revokelogin.html" var="href4" />
    <form action="${href4}" accept-charset="UTF-8" method="POST">
    <div class="input-group mb-3">
    <input required maxlength="80" type="text" 
    name="login" class="form-control" id="login" placeholder="Введите логин"/>
    </div>
    
    <div class="input-group mb-3">
    <div style="margin: 0 auto;">
    <select class="custom-select" name="func" id="func">
        <option value="INSERT"> Вставка </option>
        <option value="UPDATE"> Изменение </option>
        <option value="DELETE"> Удаление </option>
    </select>
    </div>
    </div>
    
    <div class="input-group mb-3">
    <div style="margin: 0 auto;">
    <select class="custom-select" name="table" id="table">
        <option value="client"> Клиент </option>
        <option value="doctor"> Врач </option>
        <option value="prescription"> Рецепт от врача </option>
        <option value="employee"> Работник </option>
        <option value="position"> Должность </option>
        <option value="ingredient"> Ингредиент </option>
        <option value="medicament"> Медикамент </option>
        <option value="product"> Компонент </option>
        <option value="recipe_medicament"> Рецепт </option>
        <option value="order_medicament"> Товар </option>
        <option value="order"> Заказ </option>
        <option value="pending_order"> Отложенный заказ </option>
        <option value="sale"> Продажа </option>
        <option value="medicament_stock"> Склад медикаментов </option>
        <option value="product_stock"> Склад компонентов </option>
    </select>
    </div>
    </div>
    <button style="margin: 0 auto;" type="submit" class="btn btn-primary">
    Удалить
    </button>
    </form>           
</div>

</ui:html>