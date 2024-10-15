package com.prueba.runners;

import com.prueba.utils.BeforeSuite;
import com.prueba.utils.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;


import java.io.IOException;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com.prueba.features",
        tags = {"@CP001,@CP002,@CP003,@CP004,@CP005,@CP006,@CP007"},
        glue = "com.prueba.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class PruebaTRunner {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/com.prueba.features");
    }
}
