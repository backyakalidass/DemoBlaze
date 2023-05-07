package com.bac.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features=".\\src\\features\\HomePageAfterLogin.feature",
glue= {"com.bac.stepDefinition"},
dryRun = false,
monochrome = true,
tags= "not @Skip",

plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"}
)
public class Runner {

}

