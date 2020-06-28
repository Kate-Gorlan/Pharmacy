<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@ taglib prefix="fn" uri="http://pharmacy/jsp/functions"%>

<ui:html title="Пользователи" thema="flatly">
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="saveuser.html" method="post">
                <div class="form-group">
                    <input class="form-control" name="id" type="text" value="${user.id}" hidden="hidden">
                </div>
                <div class="form-group">
                    <input class="form-control" name="login" type="text" value="${user.login}" hidden="hidden">
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" value="${user.login}" disabled="disabled">
                </div>
                <c:forEach items="${roles}" var="role" varStatus="status">
                    <div class="form-group form-check">
                        <input class="form-check-input" name="roles[${status.index}].id" value="${role.id}" type="checkbox" ${fn:contains(role, user.roles)?'checked':''}> <label
                            class="form-check-label">${role.roleName}</label>
                    </div>
                </c:forEach>
                <button class="btn btn-primary" type="submit"  style="background: #18BC9C">Сохранить</button>
            </form>
        </div>
    </div>
</div>
</ui:html>