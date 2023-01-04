package co.com.choucair.cetification.startsharp.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UnidadNegocioPage {
    public static final Target INPUT_NOMBRE = Target.the("").located(By.id("Serenity_Pro_Organization_BusinessUnitDialog3_Name"));
    public static final Target DROPDOWN_UNIDAD_PADRE = Target.the("").located(By.id("s2id_Serenity_Pro_Organization_BusinessUnitDialog3_ParentUnitId"));
    public static final Target INPUT_UNIDAD_PADRE = Target.the("").located(By.id("s2id_autogen1_search"));
    public static final Target BTN_GUARDAR = Target.the("").located(By.xpath("//div[@class=\"tool-button save-and-close-button icon-tool-button\"]"));
    public static final Target INPUT_BUSCAR = Target.the("").located(By.xpath("(//input[@class=\"s-Serenity-QuickSearchInput s-QuickSearchInput\"])[1]"));
    public static final Target LABEL_ID = Target.the("").located(By.xpath("//span[contains(text(),'ID') and @class=\"slick-column-name\"]"));
    public static final Target LABEL_NOMBRE = Target.the("").located(By.xpath("(//a[@class=\"s-EditLink s-Pro-Organization-BusinessUnitLink\"])[2]"));
    public static final Target LABEL_UNIDAD_PADRE = Target.the("").located(By.xpath("(//a[@class=\"s-EditLink s-Pro-Organization-BusinessUnitLink\"])[3]"));


}
