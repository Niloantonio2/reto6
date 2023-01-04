package co.com.choucair.cetification.startsharp.questions;

import co.com.choucair.cetification.startsharp.userinterfaces.ReunionPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarReunion implements Question<String>{

    public static ValidarReunion programada() {
        return new ValidarReunion();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ReunionPage.LBL_NOMBRE_REUNION).viewedBy(actor).asString();
    }
}
