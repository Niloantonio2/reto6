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
