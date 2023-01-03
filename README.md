# StartShap

Se realiza la automatización en la pagina [StartShap](https://serenity.is/demo/) de los procesos de Registro y Login, Business Unit y New Meeting, gestionando dependencicias con [Gradle](https://gradle.org/) en su version 7.4, [Java](https://www.java.com/es/) jdk en su version 1.8.0_221, [SerenityBDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html), [Cucumber](https://cucumber.io/) y patron de diseño Screenplay, las clases se llaman de acuerdo a UpperCamiCase y las variables lowerCamiCase.


## Data
Se utilizan datos estaticos enviados mediante el feature hecho con  Cucumber, escrito en lenguaje [Gerking](https://cucumber.io/docs/gherkin/); para el correo se crea scrit que genera dato de manera dinamica en cada ejecucion, sin embargo se deja documentada la manera de como utilizar el dato del feature.

## Estructura Codigo Fuente

La estructura del codigo fue realizada con Screenplay de la siguiente forma:
<table>
<tr>
  <th>Tasks</th>
  <td>
    <h6>Contiene todas las tareas que se ejecutaran en la automatizacion</h6>
  </td>
</tr>
  <tr>
  <th>Interactions</th>
  <td>
    <h6>Contiene todas las interaciones que se ejecutaran en la automatizacion</h6> 
  </td>
</tr>
  <tr>
  <th>Models</th>
  <td>
    <h6>Contiene todos los modelos que se utilizaran para la construccion de la automatizacion</h6>
  </td>
</tr>
  <tr>
  <th>interfas de usuario</th>
  <td>
    <h6>Contiene todos los elementos de la interface usuario mapeados en la pagina</h6>
  </td>
</tr>
  <tr>
  <th>Drivers</th>
  <td>
    <h6>Contiene 3  drivers de los navegadores Chrome, Edge y firefox</h6>
  </td>
</tr>
  <tr>
  <th>Runners</th>
  <td>
    <h6>Contiene el ejecutor de la prueba automatizada</h6>
  </td>
</tr>
  <tr>
  <th>Steps Definitions</th>
  <td>
    <h6>Contiene todos los pasos de la ejecucion de la prueba automatizada</h6>
  </td>
</tr>
  <tr>
  <th>Features</th>
  <td>
    <h6>Contiene todos los esenarios codificados en lenguaje Gherking</h6>
  </td>
</tr>
</table>

#### Tasks

##### AbrirPagina

Realiza el inicio de sesion al sistema de la pagina de la Libreria Nacional, esta tarea implementa la interfaz Task y sobreescribe su metodo.
```java
import co.com.choucair.cetification.startsharp.userinterfaces.StartSharpPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPagina implements Task {

    private StartSharpPage startSharpPage;
    public static AbrirPagina starSharp() {
        return Tasks.instrumented(AbrirPagina.class);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(startSharpPage)

        );
    }
}

```
##### IniciarSesion
```java
public class IniciarSesion implements Task {

    private CredencialesModels credencialesModels;

    public IniciarSesion(CredencialesModels credencialesModels) {
        this.credencialesModels = credencialesModels;
    }

    public static IniciarSesion conLosDatos(CredencialesModels credencialesModels) {
        return Tasks.instrumented(IniciarSesion.class,credencialesModels);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(InicioSesionPage.TXT_NOMBRE_USUARIO),
                Clear.field(InicioSesionPage.TXT_CLAVE),

                Enter.theValue(credencialesModels.getStrUsuario()).into(InicioSesionPage.TXT_NOMBRE_USUARIO),
                Enter.theValue(credencialesModels.getStrClave()).into(InicioSesionPage.TXT_CLAVE),
                Click.on(InicioSesionPage.BTN_INICIAR_SESION)

        );
    }
}
```

##### AbrirUnidad
```java
public class AbrirUnidad implements Task {


    public static AbrirUnidad deNegocio() {
        return Tasks.instrumented(AbrirUnidad.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InicioPage.BTN_ORGANIZACION),
                Click.on(InicioPage.BTN_UNIDAD),
                Click.on(InicioPage.BTN_NUEVA_UNIDAD)
        );

    }

}
```

##### CreaUnidaddeNegocio
```java
public class CreaUnidaddeNegocio implements Task {

    private CrearUnidadModels crearUnidadModels;

    public CreaUnidaddeNegocio(CrearUnidadModels crearUnidadModels) {
        this.crearUnidadModels = crearUnidadModels;
    }


    public static CreaUnidaddeNegocio conLosDatos(CrearUnidadModels crearUnidadModels) {
        return Tasks.instrumented(CreaUnidaddeNegocio.class,crearUnidadModels );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(crearUnidadModels.getStrNombreUnidad()).into(UnidadNegocioPage.INPUT_NOMBRE),
                Click.on(UnidadNegocioPage.DROPDOWN_UNIDAD_PADRE),
                Enter.theValue(crearUnidadModels.getStrUnidadPadre()).into(UnidadNegocioPage.INPUT_UNIDAD_PADRE),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_UNIDAD_PADRE),
                Click.on(UnidadNegocioPage.BTN_GUARDAR)

        );
    }
}

```

##### BucarUnidaddeNegocio
```java
public class BucarUnidaddeNegocio implements Task {
    private CrearUnidadModels crearUnidadModels;

    public BucarUnidaddeNegocio(CrearUnidadModels crearUnidadModels) {
        this.crearUnidadModels = crearUnidadModels;
    }

    public static BucarUnidaddeNegocio conLosDatos(CrearUnidadModels crearUnidadModels) {
        return Tasks.instrumented(BucarUnidaddeNegocio.class, crearUnidadModels);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(UnidadNegocioPage.INPUT_BUSCAR),
                Enter.theValue(crearUnidadModels.getStrNombreUnidad()).into(UnidadNegocioPage.INPUT_BUSCAR),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_BUSCAR),
                Click.on(UnidadNegocioPage.LABEL_ID),
                Click.on(UnidadNegocioPage.LABEL_ID) );


    }
}

```


### CreaNuevaRunionconNegocio

#### Esperar

```java
public class CreaNuevaRunionconNegocio implements Task {

    private CrearReunionModels crearReunionModels;

    public CreaNuevaRunionconNegocio(CrearReunionModels crearReunionModels) {
        this.crearReunionModels = crearReunionModels;
    }


    public static CreaNuevaRunionconNegocio conLosDatos(CrearReunionModels crearReunionModels) {
        return Tasks.instrumented(CreaNuevaRunionconNegocio.class,crearReunionModels);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InicioPage.BTN_REUNION),
                Click.on(InicioPage.BTN_REUNIONES),
                Click.on(InicioPage.BTN_NUEVA_REUNION),

                Enter.theValue(crearReunionModels.getStrNombreReunion()).into(ReunionPage.INPUT_NOMBRE_REUNION),
                Enter.theValue(crearReunionModels.getIntNumeroReunion()).into(ReunionPage.INPUT_NUMERO_REUNION),
                Click.on(ReunionPage.DROPDOWN_TIPO_REUNION),
                Enter.theValue(crearReunionModels.getStrTipo()).into(ReunionPage.INPUT_TIPO_REUNION).thenHit(Keys.ENTER),
                Enter.theValue(crearReunionModels.getDateFechaInicio()).into(ReunionPage.INPUT_FECHA_INICIO),
                Enter.theValue(crearReunionModels.getDateFechaFin()).into(ReunionPage.INPUT_FECHA_FIN),
                SelectFromOptions.byVisibleText(crearReunionModels.getStrHoraInicio()).from(ReunionPage.SELECT_HORA_INICIO),
                SelectFromOptions.byVisibleText(crearReunionModels.getStrHoraFin()).from(ReunionPage.SELECT_HORA_FIN),
                Click.on(ReunionPage.DROPDOWN_UBICACION),
                Enter.theValue(crearReunionModels.getStrUbicacion()).into(ReunionPage.INPUT_UBICACION).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_ORGANIZADOR),
                Enter.theValue(crearReunionModels.getStrOrganizador()).into(ReunionPage.INPUT_ORGANIZADOR).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_UNIDAD),
                Enter.theValue(crearReunionModels.getStrUnidadPadre()).into(ReunionPage.INPUT_UNIDAD).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_REPORTRTO),
                Enter.theValue(crearReunionModels.getStrReportero()).into(ReunionPage.INPUT_REPORTERO).thenHit(Keys.ENTER),
                Click.on(ReunionPage.DROPDOWN_ASISTENTE),
                Enter.theValue(crearReunionModels.getStrAsistentes()).into(ReunionPage.INPUT_ASISTENTE).thenHit(Keys.ENTER),
                Click.on(ReunionPage.BTN_GUARDAR)


        );
    }
}
```
### BucarReunioncreada
```java
public class BucarReunioncreada implements Task {
    private CrearReunionModels crearReunionModels;

    public BucarReunioncreada(CrearReunionModels crearReunionModels) {
        this.crearReunionModels = crearReunionModels;
    }

    public static BucarReunioncreada conLosDatos(CrearReunionModels crearReunionModels) {
        return Tasks.instrumented(BucarReunioncreada.class, crearReunionModels);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ReunionPage.INPUT_BUSCAR),
                Enter.theValue(crearReunionModels.getStrNombreReunion()).into(ReunionPage.INPUT_BUSCAR),
                Hit.the(Keys.ENTER).into(UnidadNegocioPage.INPUT_BUSCAR),
                Click.on(UnidadNegocioPage.LABEL_ID),
                Click.on(UnidadNegocioPage.LABEL_ID)

        );
    }
}
```


### Models

### Interfas de usuario


#### CredencialesModels
Esta clase contiene todos  los elementos de inicio de sesion de la pagina de la pagina principal.

```java
public class CredencialesModels {

    private String strUsuario, strClave;

    public String getStrUsuario() {
        return strUsuario;
    }

    public String getStrClave() {
        return strClave;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    public void setStrClave(String strClave) {
        this.strClave = strClave;
    }

    public static List<CredencialesModels> escribirData(DataTable dataTable) {

        List<CredencialesModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CredencialesModels.class));
        }
        return data;
    }
}
```

#### CrearUnidadModels

Esta clase contiene todos los mapeos de los elementos de la pagina del proceso de creacion de unidad de negocio.

```java
public class CrearUnidadModels {

    private String strNombreUnidad, strUnidadPadre ;

    public String getStrNombreUnidad() {
        return strNombreUnidad;
    }

    public void setStrNombreUnidad(String strNombreUnidad) {
        this.strNombreUnidad = strNombreUnidad;
    }

    public String getStrUnidadPadre() {
        return strUnidadPadre;
    }

    public void setStrUnidadPadre(String strUnidadPadre) {
        this.strUnidadPadre = strUnidadPadre;
    }

    public static List<CrearUnidadModels> escribirData(DataTable dataTable) {

        List<CrearUnidadModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CrearUnidadModels.class));
        }
        return data;
    }
}
```
#### CrearReunionModels

Esta clase contiene todos los mapeos de los elementos de la pagina del proceso de creacion de reuniones.

```java
public class CrearReunionModels {
    private String strNombreNegocio, strUnidadPadre,    strNombreReunion,  strTipo,dateFechaInicio,strHoraInicio,dateFechaFin;
    private String strHoraFin,    strUbicacion ,   strOrganizador ,  strReportero ,   strAsistentes , intNumeroReunion  ;

    public String getStrNombreNegocio() {
        return strNombreNegocio;
    }

    public void setStrNombreNegocio(String strNombreNegocio) {
        this.strNombreNegocio = strNombreNegocio;
    }

    public String getStrUnidadPadre() {
        return strUnidadPadre;
    }

    public void setStrUnidadPadre(String strUnidadPadre) {
        this.strUnidadPadre = strUnidadPadre;
    }

    public String getStrNombreReunion() {
        return strNombreReunion;
    }

    public void setStrNombreReunion(String strNombreReunion) {
        this.strNombreReunion = strNombreReunion;
    }

    public String getStrTipo() {
        return strTipo;
    }

    public void setStrTipo(String strTipo) {
        this.strTipo = strTipo;
    }

    public String getDateFechaInicio() {
        return dateFechaInicio;
    }

    public void setDateFechaInicio(String dateFechaInicio) {
        this.dateFechaInicio = dateFechaInicio;
    }

    public String getStrHoraInicio() {
        return strHoraInicio;
    }

    public void setStrHoraInicio(String strHoraInicio) {
        this.strHoraInicio = strHoraInicio;
    }

    public String getDateFechaFin() {
        return dateFechaFin;
    }

    public void setDateFechaFin(String dateFechaFin) {
        this.dateFechaFin = dateFechaFin;
    }

    public String getStrHoraFin() {
        return strHoraFin;
    }

    public void setStrHoraFin(String strHoraFin) {
        this.strHoraFin = strHoraFin;
    }

    public String getStrUbicacion() {
        return strUbicacion;
    }

    public void setStrUbicacion(String strUbicacion) {
        this.strUbicacion = strUbicacion;
    }

    public String getStrOrganizador() {
        return strOrganizador;
    }

    public void setStrOrganizador(String strOrganizador) {
        this.strOrganizador = strOrganizador;
    }

    public String getStrReportero() {
        return strReportero;
    }

    public void setStrReportero(String strReportero) {
        this.strReportero = strReportero;
    }

    public String getStrAsistentes() {
        return strAsistentes;
    }

    public void setStrAsistentes(String strAsistentes) {
        this.strAsistentes = strAsistentes;
    }

    public String getIntNumeroReunion() {
        return intNumeroReunion;
    }

    public void setIntNumeroReunion(String intNumeroReunion) {
        this.intNumeroReunion = intNumeroReunion;
    }

    public static List<CrearReunionModels> escribirData(DataTable dataTable) {

        List<CrearReunionModels> data = new ArrayList<>();
        List<Map<String, String>> mapIfo = dataTable.asMaps();
        for (Map<String, String> map : mapIfo) {
            data.add(new ObjectMapper().convertValue(map, CrearReunionModels.class));
        }
        return data;
    }
}
```


### Questions

#### ValidarDasboard

Realiza la validacion de que exista texto Dasboard dentro de la pagina, esta tarea implementa la interfaz Question y sobreescribe su metodo, tambien recibe un parametro de tipo Target y retorna un valor `Boolean`.

```java
package co.com.choucair.cetification.startsharp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarDasboard implements Question<String> {


    public static ValidarDasboard pagina() {
        return new ValidarDasboard();
    }

    @Override
    public String answeredBy(Actor actor) {
        return null;
    }
}
```

#### ValidarNombreUnidad
```java
public class ValidarNombreUnidad implements Question<String> {


    public static ValidarNombreUnidad creada() {
        return new ValidarNombreUnidad();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UnidadNegocioPage.LABEL_NOMBRE).viewedBy(actor).asString();
    }
}
```
#### ValidarReunion
```java
public class ValidarReunion implements Question<String>{

    public static ValidarReunion programada() {
        return new ValidarReunion();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ReunionPage.LBL_NOMBRE_REUNION).viewedBy(actor).asString();
    }
}
```

### Runners

#### StartSharpE2ERunner

Ejecuta y llama los pasos asignados en el feature `RegistroUsuario.feature` y los busca los metodos correspondientes en el paquete de `stepDefinitios` para realizar la ejecucion. Esta clase corre mediante el `@RunWith` de la clase `CucumberWithSerenity.class` y mediante el `@CucumberOptions` llama al feature correspondiente, el paquete que contiene los `Steps Definitions` y el `CamelCase`.

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/startSharpE2E.feature",
        tags = "",
        glue = "co.com.choucair.cetification.startsharp.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE )

public class StartSharpE2ERunner {
}
```

### StepsDefinitions

Los steps definitions contienen todos los metodos llamados mediante el `Runner` al `Feature`. Los metodos ejecutan las `tasks`,`interactions` y `questions` mediante un `actor`.

#### StartSharpE2EstepDefinition

Contiene todos los pasos a pasos de la ejecucion de Buscar Tema, este llama a la tarea `BuscarTemaLibreriaNacional` y le envia un String con el valor del tema y ejecuta la questions `ValidarExistenciaElemento`.

```java
public class StartSharpE2EstepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());

    }

    @Dado("que el usuario se encuentra en la pagina")
    public void queElUsuarioSeEncuentraEnLaPagina() {
        OnStage.theActorCalled("Nilo").wasAbleTo(AbrirPagina.starSharp());
    }
    @Cuando("ingresa sus credenciales de ingreso")
    public void ingresaSusCredencialesDeIngreso(DataTable dataTableCredenciales) {
        OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesion.conLosDatos(CredencialesModels.escribirData(dataTableCredenciales).get(0)));
    }

    @Cuando("que el usuario crea una unidad de negocio")
    public void queElUsuarioCreaUnaUnidadDeNegocio() throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(AbrirUnidad.deNegocio());
        Thread.sleep(3000);
    }
    @Cuando("ingresa los datos")
    public void ingresaLosDatos(DataTable dataTableNegocio) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(CreaUnidaddeNegocio.conLosDatos(CrearUnidadModels.escribirData(dataTableNegocio).get(0)));
        Thread.sleep(5000);

    }
    @Entonces("se visualizara unidad creada")
    public void seVisualizaraUnidadCreada(DataTable dataTableNegocio) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(BucarUnidaddeNegocio.conLosDatos(CrearUnidadModels.escribirData(dataTableNegocio).get(0)));
        Thread.sleep(2000);
        OnStage.theActorInTheSpotlight().should(seeThat("Validar que exista unidad creada", ValidarNombreUnidad.creada(), Matchers.equalTo((CrearUnidadModels.escribirData(dataTableNegocio).get(0).getStrNombreUnidad()))));
        Thread.sleep(2000);

    }

    @Cuando("el usuario crea nueva reunion")
    public void elUsuarioCreaNuevaReunion(DataTable dataTableReunion) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(CreaNuevaRunionconNegocio.conLosDatos(CrearReunionModels.escribirData(dataTableReunion).get(0)));
        Thread.sleep(2000);
    }
    @Entonces("podra ver creada la reunion")
    public void podraVerCreadaLaReunion(DataTable dataTableReunion) throws InterruptedException {
        OnStage.theActorCalled("Nilo").attemptsTo(BucarReunioncreada.conLosDatos(CrearReunionModels.escribirData(dataTableReunion).get(0)));
        Thread.sleep(2000);
        OnStage.theActorInTheSpotlight().should(seeThat("Validar que exista reunion programada", ValidarReunion.programada(), Matchers.equalTo(CrearReunionModels.escribirData(dataTableReunion).get(0).getStrNombreReunion())));

    }


}
```



### Features

#### startSharpE2E.feature

Contiene  escenario exitoso de registrarse en Utest y los datos a utilizar en cada escenario digitado en lenguaje Gherking. A su vez realizada el llamado del escenario de registro sin el paso de `Entonces`, se utiliza el formato"Tipodevariable).

```cucumber

#language: es
#Author: Nilo Chaverra


Característica: E2E start sharp
  Descricion: El usuario puede ingresar a la pagina web con sus credenciales,
  crear unidades de negocios y programar reuniones


  Antecedentes:  inicio de sesion
    Dado que el usuario se encuentra en la pagina
    Cuando ingresa sus credenciales de ingreso
      | strUsuario | strClave  |
      | admin      | serenity  |


   Esquema del escenario: <Escenario>
      Cuando que el usuario crea una unidad de negocio
      Y ingresa los datos
        | strNombreUnidad   | strUnidadPadre   |
        | <strNombreUnidad> | <strUnidadPadre> |
      Entonces se visualizara unidad creada
        | strNombreUnidad   |
        | <strNombreUnidad> |

     Ejemplos:
      | Escenario                       | strNombreUnidad  | strUnidadPadre |
      | Crear unidad de negocio exitoso | Reto 67          | Administration |



  Esquema del escenario: <Escenario>
   Cuando el usuario crea nueva reunion
   | strNombreNegocio   | strUnidadPadre   | strNombreReunion   | intNumeroReunion   | strTipo     | dateFechaInicio   | strHoraInicio   | dateFechaFin    | strHoraFin   | strUbicacion   | strOrganizador  | strReportero   | strAsistentes     |
   | <strNombreNegocio> | <strUnidadPadre> | <strNombreReunion> | <intNumeroReunion> | <strTipo>   | <dateFechaInicio> | <strHoraInicio> | <dateFechaFin>  | <strHoraFin> | <strUbicacion> | <strOrganizador>| <strReportero> | <strAsistentes>   |
   Entonces podra ver creada la reunion
     | strNombreReunion   |
     | <strNombreReunion> |

   Ejemplos:
   | Escenario            | strNombreNegocio | strUnidadPadre  | strNombreReunion | intNumeroReunion | strTipo     | dateFechaInicio | strHoraInicio | dateFechaFin    | strHoraFin | strUbicacion | strOrganizador  | strReportero   | strAsistentes     |
   | Crear reunion exitoso| Reto 6           | Administration  | AutomationTest   | 123456789        | General     | 01/01/2023      | 14:20         | 01/01/2023      | 15:40      | HQ-01        | Aaron Taylor    | Amber Jenkins  | Allison Bell      |





```



## Ejecucion

Al momento de ejecutar el proyecto y obtener el reporte debemos ubicarnos en la carpeta del proyecto y abrir el `CMD` para ejecutar el siguiente comando

```yml
    gradle clean test aggregate
```

Este comando ejecutara todos los escenarios implementados en el proyecto

```cmd
    BUILD SUCCESSFUL in 2m 38s
6 actionable tasks: 2 executed, 4 up-to-date
11:48:54 a. m.: Execution finished ':test --tests "co.com.choucair.cetification.startsharp.runners.StartSharpE2ERunner"'.

```

Al finalizar debemos ingresar y abrir el archivo `index.html` que se encuentra en la siguiente ruta

```yml
  <ProyectoName>\target\site\serenity\index.html
```
