<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>
<%@ taglib prefix="fn" uri="http://pharmacy/jsp/functions"%>

<ui:html title="Заявки" thema="flatly">
<div class="container" style="">
                    <c:forEach items="${listReq}" var="req">
                        <div class="row" style="height: 70px; align-items: center; border: 1px solid rgba(190, 197, 205, 0.5);">
                            <div class="col-md-auto">
                                <img alt="" src="${req.medicament.picture}" style="width: 50px; height: 50px">
                            </div>
                            <div class="col-md-auto">
                                <p style="margin-bottom: 0px"><a href="reqinfo.html?id=${req.id}">${req.medicament.name}</a></p>
                            </div>
                            <div class="col-md" style="text-align: left;">
                                <p style="margin-bottom: 0px">${req.quantity} шт.</p>
                            </div>
                            <div class="col-md-auto" style="">
                                <a href="approve.html?id=${req.id}"><button class="btn btn-primary" type="button">Одобрить</button></a>
                            </div>
                            <div class="col-md-auto">
                                <a href="decline.html?id=${req.id}"><button class="btn btn-primary" type="button">Отклонить</button></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
</ui:html>