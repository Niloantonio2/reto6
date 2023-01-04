package co.com.choucair.cetification.startsharp.questions;


import co.com.choucair.cetification.startsharp.userinterfaces.UnidadNegocioPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarNombreUnidad implements Question<String> {


    public static ValidarNombreUnidad creada() {
        return new ValidarNombreUnidad();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(UnidadNegocioPage.LABEL_NOMBRE).viewedBy(actor).asString();
    }
}
