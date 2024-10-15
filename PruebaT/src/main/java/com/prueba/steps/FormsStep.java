package com.prueba.steps;

import com.prueba.pageObject.FormsObject;
import com.prueba.pageObject.HomeObject;
import com.prueba.utils.Utilidades;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class FormsStep {
    FormsObject formsObject;
    HomeObject homeObject;
    Utilidades utilidades;
    public void ingresoAForms() throws IOException, InterruptedException {
        utilidades.scrollElemento(homeObject.getDriver(),homeObject.getIdCardForms());
        homeObject.getDriver().findElement(homeObject.getIdCardForms()).click();
        Thread.sleep(2000);
    }
    public void llenoElFormulario(String firstName, String lastName, String email, String mobille,  String currentAddres) throws IOException, InterruptedException {

        utilidades.scrollElemento(formsObject.getDriver(),formsObject.getBtnForms());
        formsObject.getDriver().findElement(formsObject.getBtnForms()).click();
        utilidades.scrollElemento(formsObject.getDriver(),formsObject.getTxtFirstName());
        formsObject.getDriver().findElement(formsObject.getTxtFirstName()).sendKeys(firstName);
        formsObject.getDriver().findElement(formsObject.getTxtLastName()).sendKeys(lastName);
        formsObject.getDriver().findElement(formsObject.getTxtEmail()).sendKeys(email);
        formsObject.getDriver().findElement(formsObject.getCheckGender()).click();
        formsObject.getDriver().findElement(formsObject.getTxtMobille()).sendKeys(mobille);
        formsObject.getDriver().findElement(formsObject.getCheckHobbies()).click();
        utilidades.scrollElemento(formsObject.getDriver(),formsObject.getTxtCurrentAddres());
        formsObject.getDriver().findElement(formsObject.getTxtCurrentAddres()).sendKeys(currentAddres);
        formsObject.getDriver().findElement(formsObject.getBtnSubmit()).click();
        Thread.sleep(2000);
    }
    public void confirmacion() throws IOException, InterruptedException {
        Assert.assertTrue(formsObject.getDriver().findElement(formsObject.getTxtConfirm()).isDisplayed());
    }


}
