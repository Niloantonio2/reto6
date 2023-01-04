package co.com.choucair.cetification.startsharp.stepdefinitions;


import co.com.choucair.cetification.startsharp.models.CrearReunionModels;
import co.com.choucair.cetification.startsharp.models.CrearUnidadModels;
import co.com.choucair.cetification.startsharp.models.CredencialesModels;
import co.com.choucair.cetification.startsharp.questions.ValidarNombreUnidad;
import co.com.choucair.cetification.startsharp.questions.ValidarReunion;
import co.com.choucair.cetification.startsharp.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


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


