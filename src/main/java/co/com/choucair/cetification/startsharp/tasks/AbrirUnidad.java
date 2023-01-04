package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.userinterfaces.InicioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

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
