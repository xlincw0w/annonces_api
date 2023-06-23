package com.exercice_2.exercice_2.Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/cucumber",
  glue = "com.exercice_2.exercice_2.Cucumber.stepdefinitions",
  plugin = { "pretty", "html:target/cucumber-reports" }
)
public class CreateAnnounceTestRunner {}
