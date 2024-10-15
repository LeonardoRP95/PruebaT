package com.prueba.steps;

import net.thucydides.core.annotations.Step;
import com.prueba.pageObject.HomeObject;
import com.prueba.utils.Utilidades;

public class HomeStep {
    HomeObject homeObject;
    Utilidades utilidades;

    @Step
    public void abrirWeb() {
        homeObject.open();
    }
    @Step
    public void seleccionarElements() throws InterruptedException {
        utilidades.scrollElemento(homeObject.getDriver(),homeObject.getIdCardElements());
        homeObject.getDriver().findElement(homeObject.getIdCardElements()).click();
    }
    public void seleccionarAlerts() throws InterruptedException {
        utilidades.scrollElemento(homeObject.getDriver(),homeObject.getIdCardAlertsFrameAndWindows());
        homeObject.getDriver().findElement(homeObject.getIdCardAlertsFrameAndWindows()).click();
    }
    public void seleccionarForms() throws InterruptedException {
        utilidades.scrollElemento(homeObject.getDriver(),homeObject.getIdCardForms());
        homeObject.getDriver().findElement(homeObject.getIdCardForms()).click();
    }
}
