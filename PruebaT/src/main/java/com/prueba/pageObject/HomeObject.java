package com.prueba.pageObject;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")

public class HomeObject extends PageObject {
    By idCardElements = By.xpath("//h5[contains(text(),'Elements')]");
    By idCardForms = By.xpath("//h5[contains(text(),'Forms')]");
    By idCardAlertsFrameAndWindows = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");

    public By getIdCardForms() {
        return idCardForms;
    }

    public By getIdCardAlertsFrameAndWindows() {
        return idCardAlertsFrameAndWindows;
    }

    public By getIdCardElements() {
        return idCardElements;
    }
}
