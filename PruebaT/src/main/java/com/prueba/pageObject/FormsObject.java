package com.prueba.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class FormsObject extends PageObject {

    By btnForms = By.xpath("//*[contains (text(), 'Practice Form')]");
    By txtFirstName = By.xpath("//*[@id='firstName']");
    By txtLastName = By.xpath("//*[@id='lastName']");
    By txtEmail = By.xpath("//*[@id='userEmail']");
    By checkGender = By.xpath("(//*[@class='custom-control-label'])[1]");
    By txtMobille = By.xpath("//*[@id='userNumber']");
    By txtDateOfBirth = By.xpath("//*[@id='dateOfBirthInput']");
    By txtSubject = By.xpath("//*[@id='subjectsContainer']");
    By checkHobbies = By.xpath("(//*[@class='custom-control-label'])[6]");
    By txtCurrentAddres = By.xpath("//*[@id='currentAddress']");
    By lstState = By.xpath("//*[contains (text(),'Select State')]");
    By lstCity = By.xpath("//*[@id='city']");
    By txtConfirm = By.xpath("//*[@class='modal-content']");
    By btnSubmit = By.xpath("//*[@id='submit']");

    public By getBtnSubmit() {
        return btnSubmit;
    }

    public By getTxtFirstName() {
        return txtFirstName;
    }

    public By getTxtConfirm() {
        return txtConfirm;
    }

    public By getBtnForms() {
        return btnForms;
    }

    public By getTxtLastName() {
        return txtLastName;
    }

    public By getTxtEmail() {
        return txtEmail;
    }

    public By getCheckGender() {
        return checkGender;
    }

    public By getTxtMobille() {
        return txtMobille;
    }

    public By getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public By getTxtSubject() {
        return txtSubject;
    }

    public By getCheckHobbies() {
        return checkHobbies;
    }

    public By getTxtCurrentAddres() {
        return txtCurrentAddres;
    }

    public By getLstState() {
        return lstState;
    }

    public By getLstCity() {
        return lstCity;
    }
}
