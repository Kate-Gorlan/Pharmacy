<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<ui:html title="login" thema="flatly">
<div class="container" align="center">
    <div class="card" style="width: 20rem; margin-top: 30px; border: 0; margin-bottom: 30px">
        <div class="card-body">
            <h5 class="card-title">Регистрация</h5>
            <c:url value="reg.html" var="href" />
            <form:form action="${href}" method="POST" modelAttribute="form">
                <spring:hasBindErrors name="form">
                    <div class="alert alert-danger" role="alert">
                        <ul>
                            <form:errors path="*" element="li" delimiter="</li><li>" />
                        </ul>
                    </div>
                </spring:hasBindErrors>

                <!-- <div class="form-group">
                    <form:hidden path="user.id" cssClass="form-control" />
                </div>-->

                <div class="form-group">
                    <label for="user.login" style="float: left; padding-left: 5px;">Логин</label>
                    <spring:bind path="user.login"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="user.login" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Login" />
                    <form:errors path="user.login" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="user.password" style="float: left; padding-left: 5px;">Пароль</label>
                    <spring:bind path="user.password"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="user.password" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Password" />
                    <form:errors path="user.password" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="password" style="float: left; padding-left: 5px;">Повторите пароль</label> 
                    <spring:bind path="password"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="password" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Password" />
                    <form:errors path="password" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="client.fullName" style="float: left; padding-left: 5px;">ФИО</label> 
                    <spring:bind path="client.fullName"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="client.fullName" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Full name" />
                    <form:errors path="client.fullName" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="client.age" style="float: left; padding-left: 5px;">Возраст</label> 
                    <spring:bind path="client.age"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="client.age" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Age" />
                    <form:errors path="client.age" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="client.address" style="float: left; padding-left: 5px;">Адрес</label> 
                    <spring:bind path="client.address"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="client.address" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Address" />
                    <form:errors path="client.address" cssClass="invalid-feedback" element="div" />
                </div>
                <div class="form-group">
                    <label for="client.phone" style="float: left; padding-left: 5px;">Телефон</label> 
                    <spring:bind path="client.phone"><c:if test="${status.error}" var="hasError" /></spring:bind>
                    <form:input path="client.phone" cssClass="form-control${hasError ? ' is-invalid' : ''}" placeholder="Number" />
                    <form:errors path="client.phone" cssClass="invalid-feedback" element="div" />
                </div>
                <button type="submit" class="btn btn-primary">Регистрация</button>
            </form:form>
        </div>
    </div>
</div>
</ui:html>