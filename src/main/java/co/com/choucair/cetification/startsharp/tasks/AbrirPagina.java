package co.com.choucair.cetification.startsharp.tasks;

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
