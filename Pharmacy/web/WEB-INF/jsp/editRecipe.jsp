<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<!doctype html>
<html>
<head>

<link rel="stylesheet" href="css/bootstrap-flatly.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.5.1/chosen.min.css">

<title>Добавление рецепта изготовления медикамента</title>
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
        
            <c:url value="/recipeAdd.html" var="href" />
            <form action="${href}" accept-charset="UTF-8" method="POST">
                <div class="input-group mb-3">
                        <c:if test="${not empty recipes}">
                        <c:set var="recipe" value="${recipes}"/>
                        <input type="hidden" name="id" value="${recipe.id}" />
                        <c:forEach items="${recipes.ingredients}" var="ingredient" varStatus="status">
                        <input type="hidden" name="ingredients[${status.index}].id" value="${ingredient.id}" />
                        <input type="hidden" name="ingredients[${status.index}].product.id" value="${ingredient.product.id}" />
                        </c:forEach>
                        </c:if>
                </div>
                
                <!-- medicament.id -->
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="width: 100%; background-color: #F7819F;">Медикамент</div>
                    </div>
                    
                    <div style="border: 10px solid white; width: 80%;">
                    <c:choose>
                        <c:when test="${empty recipes}">
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                    </c:when>
                    <c:otherwise>
                        <c:set var="recipe" value="${recipes}"/>
                    <select class="livesearch" name="medicament.id" style="width: 100%;">
                    <option selected value="${recipe.medicament.id}">${recipe.medicament.name}"</option>
                    <c:forEach items="${meds}" var="med">
                    <option value="${med.id}">${med.name}</option>
                    </c:forEach>
                    </select>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    
                </div>
                
                <!-- quantity -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="background-color: #F7819F;">Количество готового медикамента</span>
                    </div>
                    <c:choose>
                        <c:when test="${empty recipes}">
                            <input required type="text" name="quantity" class="form-control" placeholder="Введите количество (мг/мл)"/>
                        </c:when>
                    <c:otherwise>
                        <c:set var="medicamentStock" value="${recipes}"/>
                        <input required type="text" name="quantity" value="${recipe.quantity}" class="form-control" placeholder="Введите количество (мг/мл)"/>
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- settlingTime -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Время изготовления</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty recipes}">
                            <input required type="text" name="settlingTime" class="form-control" placeholder="Введите время изготовления (мин)">
                        </c:when>
                    <c:otherwise>
                        <c:set var="recipe" value="${recipes}"/>
                        <input required type="text" name="settlingTime" value="${recipe.settlingTime}" class="form-control" placeholder="Введите время изготовления (мин)">
                    </c:otherwise>
                    </c:choose>
                </div>
                <!-- technology -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <div class="input-group-text" style="background-color: #F7819F;">Технология изготовления</div>
                    </div>
                    <c:choose>
                        <c:when test="${empty recipes}">
                            <textarea maxlength="400" required aria-label="textarea" name="technology" class="form-control" placeholder="Введите технологию изготовления"></textarea> 
                        </c:when>
                    <c:otherwise>
                        <c:set var="recipe" value="${recipes}"/>
                        <textarea maxlength="400" required aria-label="textarea" name="technology" class="form-control" placeholder="Введите технологию изготовления">${recipe.technology}</textarea> 
                    </c:otherwise>
                    </c:choose>
                </div>
                     
                
                <!-- Add product -->
                <div class="element-wrapper">

                <c:choose>
                <c:when test="${empty recipes}">
                    <div class="ow input-group mb-3" index="0" style="border: 5px solid #F7819F">
                        <span class="input-group-text" id="inputGroup-sizing-default">Продукт</span>
                        <!--
                        <input name="ingredients[0].product.name" type="text" required maxlength="80" class="form-control">
                        -->
                        <select class="livesearch" name="ingredients[0].product.id">
                        <c:forEach items="${prods}" var="prod">
                        <option value="${prod.id}">${prod.name}</option>
                        </c:forEach>
                        </select>
                        
                        
                        <span class="input-group-text" id="inputGroup-sizing-default">Количество</span>
                        <input name="ingredients[0].quantity" type="text" required class="quantity form-control">
                        <span class="input-group-text" id="inputGroup-sizing-default">Время приготовления</span>
                        <input name="ingredients[0].timeForPreparing" type="text" required class="timeForPreparing form-control">
                        <span class="input-group-text" id="inputGroup-sizing-default">Стоимость работы</span>
                        <input name="ingredients[0].money" type="text" required class="money form-control">
                        <button type="button" class="btn btn-primary btn-remove-row" index="0">-</button>
                    </div>
                </c:when>
                <c:otherwise>
                <c:forEach items="${recipes.ingredients}" var="ingredient" varStatus="status">
                    <div class="ow input-group mb-3" index="${status.index}" style="border: 5px solid #F7819F">
                        <span class="input-group-text" id="inputGroup-sizing-default">Продукт</span>
                        <!--
                        <input name="ingredients[${status.index}].product.name" type="text" required maxlength="80"
                            value="${ingredient.product.name}" class="form-control">
                        -->
                        
                        <select class="livesearch" name="ingredients[${status.index}].product.id">
                        <option selected value="${ingredient.product.id}">${ingredient.product.name}"</option>
                        <c:forEach items="${prods}" var="prod">
                        <option value="${prod.id}">${prod.name}</option>
                        </c:forEach>
                        </select>
                        
                        <span class="input-group-text" id="inputGroup-sizing-default">Количество</span>
                        <input name="ingredients[${status.index}].quantity" type="text" required 
                            value="${ingredient.quantity}" class="quantity form-control">
                        <span class="input-group-text" id="inputGroup-sizing-default">Время приготовления</span>
                        <input name="ingredients[${status.index}].timeForPreparing" type="text" required 
                            value="${ingredient.timeForPreparing}" class="timeForPreparing form-control">
                        <span class="input-group-text" id="inputGroup-sizing-default">Стоимость работы</span>
                        <input name="ingredients[${status.index}].money" type="text" required 
                            value="${ingredient.money}" class="money form-control">
                        <button type="button" class="btn btn-primary btn-remove-row" index="0">-</button>
                    </div>
                </c:forEach>
                </c:otherwise>
                </c:choose>
                </div>
                <div class="input-group mb-3">
                    <button type="button" class="btn btn-primary btn-add-row">+</button>
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

<script type="text/javascript">
        $(document).ready(function(){
            $(".btn-add-row").click(function(e){

                var row = $(".ow:last").clone();
                var idx = parseInt($(".ow:last").attr("index"), 10) + 1;

                var row1 = $(".livesearch:last").clone();
                var row2 = $(".quantity:last").clone();
                var row3 = $(".timeForPreparing:last").clone();
                var row4 = $(".money:last").clone();
                
                var rowBtn = $(".btn-remove-row:last");

                $(row).attr("index", idx);
                $(row).attr("style", "");
                $(rowBtn).attr("index", idx);
                $(row1).attr("name", "ingredients[" + idx + "].product.id");
                $(row2).attr("name", "ingredients[" + idx + "].quantity");
                $(row3).attr("name", "ingredients[" + idx + "].timeForPreparing");
                $(row3).attr("name", "ingredients[" + idx + "].money");

                $(".element-wrapper").prepend(row);
            });

            $(document).on("click", ".btn-remove-row", function() {
                var index = $(".btn-remove-row").index(this);
                $(".ow").eq(index).remove();
            });
        });
</script>
</body>
</html>