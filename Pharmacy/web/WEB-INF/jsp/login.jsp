<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>

<ui:html title="login" thema="flatly">
<div class="container" align="center">
    <div class="card" style="width: 20rem; margin-top: 60px; border: 0">
        <div class="card-body">
            <h5 class="card-title">
                <spring:message code="login" text="Авторизация" />
            </h5>
            <c:url value="/j_spring_security_check" var="href" />
            <form action="${href}" method="POST">
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <div class="form-group">
                        <p class="form-control-static text-danger">
                            <fmt:message key="login.error">
                                <fmt:param value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                            </fmt:message>
                        </p>
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="username" style="float: left; padding-left: 5px;">Логин</label> <input id="username" type="text"
                        name="j_username" class="form-control" placeholder="Login" value="${sessionScope.LAST_USERNAME}" />
                </div>

                <div class="form-group">
                    <label for="password" style="float: left; padding-left: 5px;">Пароль</label> <input id="password" type="password"
                        name="j_password" class="form-control" placeholder="Password" />
                </div>

                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <div class="card-body" style="padding-top: 10px;">
                 <ul class="list-group">
                    <li class="list-group-item2"><a href="registration.html">Регистрация</a></li>
                    <li class="list-group-item2"><a href="resetpass.html">Забыли пароль?</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</ui:html>