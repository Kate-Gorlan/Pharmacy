<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html title="Пользователи" thema="flatly">

<div class="container">

    <div class="" style="padding-bottom: 20px; padding-top: 20px">
        <form action="users.html" method="POST">
            <div class="form-group">
                <div class="row">
                    <input class="form-control col-md-5" type="search" name="login" class="form-control" placeholder="Логин" required="required">
                    <button class="btn btn-primary" type="submit" style="background: #18BC9C">Найти</button>
                </div>
            </div>
        </form>
    </div>

    <c:forEach items="${users}" var="user">
        <div class="row" style="height: 40px; align-items: center; border: 1px solid rgba(190, 197, 205, 0.5);">
            <!-- li>${user.id}:${user.login} ${user.roles}</li-->
            <div class="col-md-4">
                <a href="edituser.html?l=${user.login}">${user.login}</a>
            </div>
            <c:forEach items="${user.roles}" var="role">
                <div class="col-md-auto">${role.roleName}</div>
            </c:forEach>
        </div>
    </c:forEach>
</div>
</ui:html>