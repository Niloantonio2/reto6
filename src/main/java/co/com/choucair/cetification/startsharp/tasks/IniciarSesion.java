package co.com.choucair.cetification.startsharp.tasks;

import co.com.choucair.cetification.startsharp.models.CredencialesModels;
import co.com.choucair.cetification.startsharp.userinterfaces.InicioSesionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

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
