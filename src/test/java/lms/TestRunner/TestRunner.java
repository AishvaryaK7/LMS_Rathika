package lms.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lms.Utilities.TestContext;

@RunWith(Cucumber.class)

@CucumberOptions(
		features ={"src/test/resources/Features/"}, 
		glue = {"lms.StepDefinition","lms.Hooks"}, 
		monochrome = true, 
		plugin = {"pretty",
				  "html:Reports/Cucumber_html_report",
				  "json:Reports/Cucumber_json_report.json",
				  "junit:Reports/Cucumber_junit_report.xml",
				  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish=true)

public class TestRunner 
{
	public static TestContext testContext = new TestContext();

}
