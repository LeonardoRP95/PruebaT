@PruebasUsuarios
Feature: Pruebas Usuarios

  @CP001
  Scenario Outline: : Interacción con el Cuadro de Texto
    Given navego en la aplicación
    When ingreso a textBox y lleno el formulario <Nombre> <Correo> <DireccionActual> <DireccionPermanente>
    Then valido la informacion ingresada <Nombre> <Correo> <DireccionActual> <DireccionPermanente>
    Examples:
      | Nombre | Correo | DireccionActual | DireccionPermanente |
        ##@externaldata@./src/test/resources/Data/Data.xlsx@CP001
|"Leonardo"|"leonardoprueba@gmail.com"|"Cr29 #19-38"|"Cr29 #19-39"|

  @CP002
  Scenario:seleccionar los apartados indicados y generar la validación que corresponde.
    Given navego en la aplicación
    When marco las casillas indicadas
    Then valido que las casillas esten seleccionadas

  @CP003
  Scenario:Interactuar con la opcion Radio Buttom, seleccionar alguna de las opciones y generar la respectiva validación.
  Given navego en la aplicación
  When selecciono el botón de opción yes
  Then valido que la opcion yes este seleccionada

  @CP004
  Scenario Outline:Interactuar con Tabla Web y Crear, Editar y Eliminar Registro
  Given navego en la aplicación
  When annado un registro <firstName> <lastName> <email> <age> <salary> <departament>
  Then deberia mostrarse en la tabla la informacion <firstName> <lastName> <email> <age> <salary> <departament>
  When edito el registro <firstNameE> <lastNameE> <emailE> <ageE> <salaryE> <departamentE>
  Then deberia actualizarse en la tabla la informacion <firstNameE> <lastNameE> <emailE> <ageE> <salaryE> <departamentE>
  When elimino el registro
  Then no deberia mostrarse en la tabla <firstName>
    Examples:
      | firstName | lastName | email | age | salary | departament | firstNameE | lastNameE | emailE | ageE | salaryE | departamentE |
    ##@externaldata@./src/test/resources/Data/Data.xlsx@CP004
|"Leonardo"|"Rodriguez"|"leonardo@gmail.com"|"29"|"3500000"|"calidad"|"Jason"|"Rodriguez"|"jason@gmail.com"|"1"|"1000"|"Guarderia"|

    @CP005
  Scenario: : Interacción con Botones
  Given navego en la aplicación
  When interactuo con los botones
  Then valido la interaccion

    @CP006
  Scenario: Carga de Archivo
  Given navego en la aplicación
  When subo el archivo csv y realizo la descarga
  Then la carga y descarga deberia ser exitosa

  @CP007
  Scenario Outline: completar el formulario y agregar la respectiva validación.
    Given navego en la aplicación
    When completo el formulario y lo envio <FirstName> <Lastname> <Email> <Mobille>  <CurrentAddres>
    Then deberia validar el envio del formulario
    Examples:
      | FirstName | Lastname | Email | Mobille | CurrentAddres |
      ##@externaldata@./src/test/resources/Data/Data.xlsx@CP007
|"Leonardo"|"Rodriguez"|"leonardo@gmail.com"|"1212121212"|"cr29#19-38"|





