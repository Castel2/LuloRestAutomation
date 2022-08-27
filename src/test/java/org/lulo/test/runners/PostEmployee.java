package org.lulo.test.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/create_employee.feature",
        glue = "org.lulo.test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class PostEmployee {
}
