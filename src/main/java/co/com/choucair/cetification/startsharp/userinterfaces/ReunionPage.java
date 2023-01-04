package co.com.choucair.cetification.startsharp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReunionPage {
    public static final Target INPUT_NOMBRE_REUNION = Target.the("").located(By.id("Serenity_Pro_Meeting_MeetingDialog10_MeetingName"));
    public static final Target DROPDOWN_TIPO_REUNION= Target.the("").located(By.id("select2-chosen-6"));
    public static final Target INPUT_TIPO_REUNION = Target.the("").located(By.id("s2id_autogen6_search"));
    public static final Target INPUT_NUMERO_REUNION = Target.the("").located(By.id("Serenity_Pro_Meeting_MeetingDialog10_MeetingNumber"));
    public static final Target INPUT_FECHA_INICIO = Target.the("").located(By.id("Serenity_Pro_Meeting_MeetingDialog10_StartDate"));
    public static final Target INPUT_FECHA_FIN = Target.the("").located(By.id("Serenity_Pro_Meeting_MeetingDialog10_EndDate"));
    public static final Target SELECT_HORA_INICIO = Target.the("").located(By.xpath("(//select[@class=\"editor s-DateTimeEditor time\"])[1]"));
    public static final Target SELECT_HORA_FIN = Target.the("").located(By.xpath("(//select[@class=\"editor s-DateTimeEditor time\"])[2]"));
    public static final Target DROPDOWN_UBICACION = Target.the("").located(By.id("select2-chosen-7"));
    public static final Target INPUT_UBICACION = Target.the("").located(By.id("s2id_autogen7_search"));
    public static final Target DROPDOWN_UNIDAD = Target.the("").located(By.id("s2id_Serenity_Pro_Meeting_MeetingDialog10_UnitId"));
    public static final Target INPUT_UNIDAD = Target.the("").located(By.xpath("//*[@id=\"s2id_autogen8_search\"]"));
    public static final Target DROPDOWN_ORGANIZADOR= Target.the("").located(By.id("select2-chosen-9"));
    public static final Target INPUT_ORGANIZADOR = Target.the("").located(By.id("s2id_autogen9_search"));
    public static final Target DROPDOWN_REPORTRTO= Target.the("").located(By.id("select2-chosen-10"));
    public static final Target INPUT_REPORTERO = Target.the("").located(By.xpath("//*[@id=\"s2id_autogen10_search\"]"));
    public static final Target DROPDOWN_ASISTENTE= Target.the("").located(By.id("select2-chosen-12"));
    public static final Target INPUT_ASISTENTE = Target.the("").located(By.xpath("//*[@id=\"s2id_autogen12_search\"]"));
    public static final Target INPUT_BUSCAR = Target.the("").located(By.xpath("(//input[@class=\"s-Serenity-QuickSearchInput s-QuickSearchInput\"])[1]"));
    public static final Target BTN_GUARDAR = Target.the("").located(By.xpath("//div[@class=\"tool-button save-and-close-button icon-tool-button\"]"));
    public static final Target LBL_NOMBRE_REUNION = Target.the("").located(By.xpath("(//*[@class=\"s-EditLink s-Pro-Meeting-MeetingLink\"])[2]"));

}
