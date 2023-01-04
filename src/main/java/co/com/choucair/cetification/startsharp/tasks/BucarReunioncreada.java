package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearReunionModels;
import co.com.choucair.cetification.startsharp.userinterfaces.ReunionPage;
import co.com.choucair.cetification.startsharp.userinterfaces.UnidadNegocioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import java.util.List;


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
