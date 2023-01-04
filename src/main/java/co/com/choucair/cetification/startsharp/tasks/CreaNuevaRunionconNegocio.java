package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearReunionModels;
import co.com.choucair.cetification.startsharp.userinterfaces.InicioPage;
import co.com.choucair.cetification.startsharp.userinterfaces.ReunionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

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
