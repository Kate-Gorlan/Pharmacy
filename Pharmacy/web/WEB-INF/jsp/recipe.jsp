<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Рецепты" thema="flatly">
<body style="width:100%;height:100%;">

<div style="width: 15%; height: 100vh; overflow:auto; float:left;">
    <a href="recipes.html">
    <button type="button" class="btn btn-info" style="width: 100%; height: 50px; font-size: 150%;">
    Назад</button></a>
</div>
<div style="width: 2%; height: 100vh; overflow:auto; float:left;"></div>
<div style="width: 83%; overflow:auto;">

<c:if test="${not empty recipe}">
    <div class="col-md-8">
        <div class="card-body">
            <h3>${recipe.medicament.name}</h3>
            
            <p class="card-text" style="color: #800000;">Ингредиенты</p>
            <c:if test="${not empty recipe.ingredients}">
            
            <table class="table table-success">
            <thead>
            <tr>
                <th scope="col">Продукт</th>
                <th scope="col">Количество</th>
                <th scope="col">Время изготовления</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${recipe.ingredients}" var="ingredient">
                <tr class="table-light" style="color:black;">
                    <td>${ingredient.product.name}</td>
                    <td>${ingredient.quantity} мг/мл</td>
                    <td>${ingredient.timeForPreparing} мин</td>
                </tr>
                </c:forEach>
            </tbody>
            </table>
            </c:if>
            
            <p class="card-text" style="color: #800000;">Технология</p>
            <p class="card-text">${recipe.technology}</p>
            <p class="card-text" style="color: #800000;">Время изготовления </p>
            <p class="card-text">Не включая подготовку ингредиентов ${recipe.settlingTime} мин</p>
            <p class="card-text" style="color: #800000;">Количество готового медикамента </p>
            <p class="card-text">${recipe.quantity} мг/мл</p>
        </div>
    <a href="goAddRecipe.html?id=${recipe.getId()}">
        <button type="button" class="btn btn-warning">Изменить</button>
    </a>
    <a href="deleteRecipe.html?id=${recipe.getId()}">
        <button type="button" class="btn btn-danger">Удалить</button>
    </a>
    </div>
</c:if>

<c:if test="${empty recipe}">
<h4> Рецепт не найден. </h4>
</c:if>
    
</div>

</body>
</ui:html>