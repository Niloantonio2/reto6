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




