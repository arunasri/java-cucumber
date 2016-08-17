package com.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        dryRun = false,
        format = "pretty",
        features = "src/test/resources/"
        )
public class GoogleTest {

}