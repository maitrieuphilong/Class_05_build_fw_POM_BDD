package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// Đường dẫn tới file feature
        features = "src/test/java/features",
        
        // tìm đến package chứa các step
        glue = "stepDefinitions",
        monochrome = true,
        plugin = { "pretty", "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@register_login"
)
public class TestRunner {

}
