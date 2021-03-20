package com.test.santhoshravichandran.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/automationpractice_regression/Automation_Practice.feature",
glue = "com.test",tags = {"@regression"})
public class AutomationPractice_Runner  {
}
