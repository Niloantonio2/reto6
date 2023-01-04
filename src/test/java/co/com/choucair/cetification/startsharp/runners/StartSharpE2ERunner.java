package co.com.choucair.cetification.startsharp.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/startSharpE2E.feature",
        tags = "",
        glue = "co.com.choucair.cetification.startsharp.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE )

public class StartSharpE2ERunner {
}

