package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/PIM.feature", glue = {"org.example.steps.pim"}, monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/JUnitreport.xml",
                "json:target/JSONReports/jsonReport.json",
                "html:target/HTMLReports/HTMLReport"})
public class TestRunnerPIM {

}
