package co.com.choucair.cetification.startsharp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioSesionPage {
    public static final Target TXT_NOMBRE_USUARIO = Target.the("campo para escribir username").located(By.id("LoginPanel0_Username"));
    public static final Target TXT_CLAVE = Target.the("campo para escribir password").located(By.id("LoginPanel0_Password"));
    public static final Target BTN_INICIAR_SESION = Target.the("boton ingresar").located(By.id("LoginPanel0_LoginButton"));


}
