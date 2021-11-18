package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/OrangeHRM.feature", glue = {"org.example.steps.definitions.orange"}, monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/JUnitreport.xml",
                "json:target/JSONReports/JsonReport.json",
                "html:target/HTMLReports/HTMLReport"})
public class TestRunnerOrange {
}
