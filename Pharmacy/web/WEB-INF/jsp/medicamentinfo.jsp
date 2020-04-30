<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:indexTag title="${medicament.name}" thema="flatly">

    <div class="container">
        <nav>
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-description" role="tab"
                    aria-controls="nav-home" aria-selected="true">Описание</a> <a class="nav-item nav-link" id="nav-profile-tab"
                    data-toggle="tab" href="#nav-instruction" role="tab" aria-controls="nav-profile" aria-selected="false">Инструкция</a>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="nav-description" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="row" style="margin-left: 0; width: 100%; height: 100%">
                    <div class="card" style="width: 20%; height: 20%">
                        <img src="${medicament.picture}" class="card-img-bottom" alt="Картинка">
                    </div>
                    <ul class="list-group" style="border: 0; width: 80%">
                        <li class="list-group-item2">Название: ${medicament.name}</li>
                        <li class="list-group-item2">Форма выпуска: ${medicament.type}</li>
                        <li class="list-group-item2">Внешний вид: ${medicament.description}</li>
                    </ul>
                </div>
            </div>
            <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                        style="height: 40px; padding-top: 15px; padding-left: 10px;">Показания к применению</div>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset" style="">
                        <div class="dropdown-item">
                            <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.indications}</p>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Способ применения и дозы</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.dosesAndMethodOfAppl}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Противопоказания</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.contraindications}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Особые указания и меры предосторожности</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.precautions}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Взаимодействие с другими лекарственными
                            препаратами и другими видами взаимодействия</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.interaction}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Беременность и грудное вскармливание</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.pregnancyAndBreastfeeding}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Влияние на управление транспортом и работу с
                            механизмами</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.influenceTM}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Побочное действие</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.sideEffect}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container" style="padding-left: 0; background-color: #ebebeb; border-bottom: ridge;">
                    <div class="tab-pane fade" id="nav-instruction" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <div class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"
                            style="height: 40px; padding-top: 15px; padding-left: 10px;">Передозировка</div>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">
                            <div class="dropdown-item">
                                <p class="text-break" style="white-space: break-spaces; color: #604f4f">${medicament.overdose}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</ui:indexTag>