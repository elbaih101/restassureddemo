package com.elbaih.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = "com.elbaih.stepDefs",
                monochrome = true,
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml",
                        "rerun:target/cucumber.txt",


                }



        )


public class TestRunner extends AbstractTestNGCucumberTests {

}
