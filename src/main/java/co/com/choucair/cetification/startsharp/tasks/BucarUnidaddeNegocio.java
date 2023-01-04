package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CrearUnidadModels;
import co.com.choucair.cetification.startsharp.userinterfaces.UnidadNegocioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

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
