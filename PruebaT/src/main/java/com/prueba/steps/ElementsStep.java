package com.prueba.steps;


import com.prueba.pageObject.ElementsObject;
import com.prueba.utils.LectorExcel;
import com.prueba.utils.Utilidades;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ElementsStep {
    ElementsObject elementsObject;
    Utilidades utilidades;
    LectorExcel lectorExcel;

    @Step
    public void interacciónTextBox(String nombre, String correo, String direccionActual, String direccionPermanente) throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getBtnTextBox()).click();
        elementsObject.getDriver().findElement(elementsObject.getTxtFullName()).sendKeys(nombre);
        elementsObject.getDriver().findElement(elementsObject.getTxtEmail()).sendKeys(correo);
        elementsObject.getDriver().findElement(elementsObject.getTxtCurrentAddress()).sendKeys(direccionActual);
        elementsObject.getDriver().findElement(elementsObject.getTxtPermanentAddress()).sendKeys(direccionPermanente);
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnSubmit());
        elementsObject.getDriver().findElement(elementsObject.getBtnSubmit()).click();
        Thread.sleep(6000);
    }
    @Step
    public void validarInformacion(String nombre, String correo, String direccionActual, String direccionPermanente) throws InterruptedException {
        String name = elementsObject.getDriver().findElement(elementsObject.getValName()).getText();
        String email = elementsObject.getDriver().findElement(elementsObject.getValEmail()).getText();
        String currentAddress = elementsObject.getDriver().findElement(elementsObject.getValCurrentAddress()).getText();
        String permanentAddress = elementsObject.getDriver().findElement(elementsObject.getValPermanentAddress()).getText();
        Assert.assertTrue(name,name.contains(nombre));
        Assert.assertTrue(email,email.contains(correo));
        Assert.assertTrue(currentAddress, currentAddress.contains(direccionActual));
        Assert.assertTrue(permanentAddress, permanentAddress.contains(direccionPermanente));
        Thread.sleep(6000);
    }

    @Step
    public void seleccionarItems() throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getBtnCheckBox()).click();
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnExpan());
        elementsObject.getDriver().findElement(elementsObject.getBtnExpan()).click();
        elementsObject.getDriver().findElement(elementsObject.getCheckNotes()).click();
        elementsObject.getDriver().findElement(elementsObject.getCheckWorkSpace()).click();
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getCheckOffice());
        elementsObject.getDriver().findElement(elementsObject.getCheckOffice()).click();
        elementsObject.getDriver().findElement(elementsObject.getCheckWordFile()).click();
    }

    @Step
    public void validarSeleccionDeItems() throws InterruptedException {
        String seleccion =elementsObject.getDriver().findElement(elementsObject.getLstSelect()).getText();
        Assert.assertTrue(seleccion,seleccion.contains("notes"));
        Assert.assertTrue(seleccion,seleccion.contains("workspace"));
        Assert.assertTrue(seleccion, seleccion.contains("office"));
        Assert.assertTrue(seleccion, seleccion.contains("wordFile"));
        Thread.sleep(6000);
    }
    @Step
    public void interactuarRadioButton() throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getBtnRadioButton()).click();
        Thread.sleep(2000);
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnYesRadio());
        elementsObject.getDriver().findElement(elementsObject.getBtnYesRadio()).click();
    }
    @Step
    public void validarSeleccionRadioButton() throws InterruptedException {
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getValRadio()).getText(),"Yes");
    }
    @Step
    public void accederAWebTables() throws InterruptedException {
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnWebTables());
        elementsObject.getDriver().findElement(elementsObject.getBtnWebTables()).click();
        Thread.sleep(2000);
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnAdd());
        elementsObject.getDriver().findElement(elementsObject.getBtnAdd()).click();
    }
    public void editarFormulario() throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getBtnEdit()).click();
    }
    public void llenarFormulario(String firstName, String lastName, String email, String age, String salary, String departament) throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getTxtfirstName()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtfirstName()).sendKeys(firstName);
        elementsObject.getDriver().findElement(elementsObject.getTxtlastName()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtlastName()).sendKeys(lastName);
        elementsObject.getDriver().findElement(elementsObject.getTxtemail()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtemail()).sendKeys(email);
        elementsObject.getDriver().findElement(elementsObject.getTxtage()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtage()).sendKeys(age);
        elementsObject.getDriver().findElement(elementsObject.getTxtsalary()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtsalary()).sendKeys(salary);
        elementsObject.getDriver().findElement(elementsObject.getTxtdepartament()).clear();
        elementsObject.getDriver().findElement(elementsObject.getTxtdepartament()).sendKeys(departament);
        elementsObject.getDriver().findElement(elementsObject.getBtnSubmit()).click();
        Thread.sleep(2000);
    }
    public void validarRegistro(String firstName, String lastName, String email, String age, String salary, String departament) throws InterruptedException {
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtFirstName()).getText(),firstName);
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtLastName()).getText(),lastName);
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtEmail()).getText(),email);
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtAge()).getText(),age);
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtSalary()).getText(),salary);
        Assert.assertEquals(elementsObject.getDriver().findElement(elementsObject.getExtDepartament()).getText(),departament);
    }
    public void validarEliminacion(String firstName) throws InterruptedException {
        String cFirstName = elementsObject.getDriver().findElement(elementsObject.getExtFirstName()).getText();
        Assert.assertFalse(cFirstName.equals(firstName));
    }
    public void eliminacionRegistro() throws InterruptedException {
        elementsObject.getDriver().findElement(elementsObject.getBtnEliminar()).click();
    }
    public void interaccionBotones() throws InterruptedException {
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnButtons());
        elementsObject.getDriver().findElement(elementsObject.getBtnButtons()).click();
        Actions actions = new Actions(elementsObject.getDriver());
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnDoubleClick());
        actions.click(elementsObject.getDriver().findElement(elementsObject.getBtnDoubleClick())).click(elementsObject.getDriver().findElement(elementsObject.getBtnDoubleClick())).perform();
        actions.contextClick(elementsObject.getDriver().findElement(elementsObject.getBtnRightClickMe())).perform();
        elementsObject.getDriver().findElement(elementsObject.getBtnClickMe()).click();
    }
    public void validacionInteracciones(){
        Assert.assertTrue(elementsObject.getDriver().findElement(elementsObject.getMsnDoubleClick()).isDisplayed());
        Assert.assertTrue(elementsObject.getDriver().findElement(elementsObject.getMsnRightClickMe()).isDisplayed());
        Assert.assertTrue(elementsObject.getDriver().findElement(elementsObject.getMsnClickMe()).isDisplayed());
    }
    public void crearArchivoCsvYCargarlo() throws IOException, InterruptedException {
        String rutaArchivo = "D:\\PruebaT\\PruebaT\\src\\test\\resources\\Data\\datos.csv";
        utilidades.eliminarArchivo(rutaArchivo);
        String[][] datos = utilidades.generarDatosAleatorios(5, 4);
        lectorExcel.crearCSV(rutaArchivo,datos);
        File file = new File(rutaArchivo);
        String path = file.getPath();
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnFile());
        elementsObject.getDriver().findElement(elementsObject.getBtnFile()).sendKeys(path);
        Thread.sleep(2000);
    }
    public void descargarArchivo() throws IOException, InterruptedException {
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnUpload());
        elementsObject.getDriver().findElement(elementsObject.getBtnUpload()).click();
        utilidades.scrollElemento(elementsObject.getDriver(),elementsObject.getBtnDownload());
        elementsObject.getDriver().findElement(By.cssSelector("#downloadButton")).click();
        Thread.sleep(2000);
    }
    public void validarCargaYDescarga() throws IOException, InterruptedException {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        entrada = new FileInputStream("./serenity.properties");
        propiedades.load(entrada);
        String rutaDescarga =propiedades.getProperty("rutaDescargas");
        boolean estado =utilidades.validarDescarga(rutaDescarga);
        Assert.assertTrue(estado);
        Assert.assertTrue(elementsObject.getDriver().findElement(elementsObject.getMsjFile()).isDisplayed());
    }
}