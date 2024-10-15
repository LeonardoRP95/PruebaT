package com.prueba.stepDefinitions;

import com.prueba.steps.AlertsFrameWindowsStep;
import com.prueba.steps.ElementsStep;
import com.prueba.steps.FormsStep;
import com.prueba.steps.HomeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class PruebasStepDefinition {
    @Steps
    HomeStep homeStep;
    @Steps
    ElementsStep elementsStep;
    @Steps
    FormsStep formsStep;
    @Steps
    AlertsFrameWindowsStep alertsFrameWindowsStep;
    @Given("^navego en la aplicación$")
    public void navegoEnLaAplicacion() throws InterruptedException {
        homeStep.abrirWeb();
    }
    @When("^ingreso a textBox y lleno el formulario \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" (.*)$")
    public void ingresoATextBoxYLlenoElFormulario(String nombre, String correo, String direccionActual, String direccionPermanente) throws InterruptedException {
        homeStep.seleccionarElements();
        elementsStep.interacciónTextBox(nombre,correo,direccionActual,direccionPermanente);
    }
    @Then("^valido la informacion ingresada \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void validoLaInformacionIngresada(String nombre, String correo, String direccionActual, String direccionPermanente) throws InterruptedException {
        elementsStep.validarInformacion(nombre,correo,direccionActual,direccionPermanente);
    }
    @When("^marco las casillas indicadas$")
    public void marcoLasCasillasIndicadas() throws InterruptedException {
        homeStep.seleccionarElements();
        elementsStep.seleccionarItems();
    }
    @Then("^valido que las casillas esten seleccionadas$")
    public void validoQueLasCasillasEstenSeleccionadas() throws InterruptedException {
        elementsStep.validarSeleccionDeItems();
    }
    @When("^selecciono el botón de opción yes$")
    public void seleccionoElBotónDeOpciónYes() throws InterruptedException {
        homeStep.seleccionarElements();
        elementsStep.interactuarRadioButton();
    }
    @Then("^valido que la opcion yes este seleccionada$")
    public void validoQueLaOpcionYesEsteSeleccionada() throws InterruptedException {
        elementsStep.validarSeleccionRadioButton();
    }
    @When("^annado un registro \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void annadoUnRegistro(String firstName, String lastName, String	email,String age, String salary,String departament) throws InterruptedException {
        homeStep.seleccionarElements();
        elementsStep.accederAWebTables();
        elementsStep.llenarFormulario(firstName,lastName,email,age,salary,departament);
    }
    @Then("^deberia mostrarse en la tabla la informacion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void deberiaMostrarseEnLaTablaLaInformacion(String firstName, String lastName, String	email,String age, String salary,String departament) throws InterruptedException {
        elementsStep.validarRegistro(firstName,lastName,email,age,salary,departament);
    }
    @When("^edito el registro \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void editoElRegistro(String firstNameE, String lastNameE, String	emailE,String ageE, String salaryE, String departamentE) throws InterruptedException {
        elementsStep.editarFormulario();
        elementsStep.llenarFormulario(firstNameE,lastNameE,emailE,ageE,salaryE,departamentE);
    }
    @Then("^deberia actualizarse en la tabla la informacion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void deberiaActualizarseEnLaTablaLaInformacion(String firstNameE, String lastNameE, String	emailE,String ageE, String salaryE, String departamentE) throws InterruptedException {
        elementsStep.validarRegistro(firstNameE,lastNameE,emailE,ageE,salaryE,departamentE);
    }
    @When("^elimino el registro$")
    public void eliminoElRegistro() throws InterruptedException {
        elementsStep.eliminacionRegistro();
    }
    @Then("^no deberia mostrarse en la tabla \"([^\"]*)\"$")
    public void noDeberiaMostrarseEnLaTabla(String firstName) throws InterruptedException {
        elementsStep.validarEliminacion(firstName);
    }
    @When("^interactuo con los botones$")
    public void interactuoConLosBotones() throws InterruptedException {
        homeStep.seleccionarElements();
    elementsStep.interaccionBotones();
    }
    @Then("^valido la interaccion$")
    public void validoLaInteraccion() {
    elementsStep.validacionInteracciones();
    }
    @When("^subo el archivo csv y realizo la descarga$")
    public void suboElArchivoCsvYRealizoLaDescarga() throws IOException, InterruptedException {
        homeStep.seleccionarElements();
        elementsStep.descargarArchivo();
        elementsStep.crearArchivoCsvYCargarlo();
    }
    @Then("^la carga y descarga deberia ser exitosa$")
    public void laCargaYDescargaDeberiaSerExitosa() throws IOException, InterruptedException {
        elementsStep.validarCargaYDescarga();
    }
    @When("^completo el formulario y lo envio \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\"$")
    public void completoElFormularioYLoEnvio(String firstName, String lastName, String email, String mobille, String currentAddres) throws IOException, InterruptedException {
       formsStep.ingresoAForms();
       formsStep.llenoElFormulario(firstName,lastName,email,mobille,currentAddres);
    }
    @Then("^deberia validar el envio del formulario$")
    public void deberiaValidarElEnvioDelFormulario() throws IOException, InterruptedException {
        formsStep.confirmacion();
    }
}