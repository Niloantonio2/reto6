package co.com.choucair.cetification.startsharp.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InicioPage extends PageObject {
    public static final Target LBL_DASHBOARD = Target.the("").located(By.xpath("//*[@id=\"s-DashboardPage\"]/main/section/section"));
    public static final Target BTN_ORGANIZACION = Target.the("").located(By.xpath("//span[contains(text(),'Organization')]"));
    public static final Target BTN_UNIDAD = Target.the("").located(By.xpath("//span[contains(text(),'Business Units')]"));
    public static final Target BTN_NUEVA_UNIDAD = Target.the("").located(By.xpath("(//*[@class=\"button-inner\"]/i)[1]"));
    public static final Target BTN_REUNION = Target.the("").located(By.xpath("//span[contains(text(),'Meeting')]"));
    public static final Target BTN_REUNIONES = Target.the("").located(By.xpath("//span[contains(text(),'Meetings')]"));
    public static final Target BTN_NUEVA_REUNION = Target.the("").located(By.xpath("//*[contains(text(),'New Meeting')]"));

}
