package Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/OrangeHRM.feature"}, monochrome = true, glue = {"StepsDefinitions"},
        plugin = {"pretty", "junit:target/JUnitReports/JUnitreport.xml",
                "json:target/JSONReports/jsonReport.json",
                "html:target/HTMLReports/HTMLReport"})
public class TestRunner {

}
