package com.parata.utils.context;

/*
    3/8/2021 James Smith
    The purpose of this class is to share data points between test steps within a test

    Can be extended to add inter step functionality beyond simple value passing
*/
public class TestContext {

    public ScenarioContext scenarioContext;
 
    public TestContext(){

        scenarioContext = new ScenarioContext();

    }

    public ScenarioContext getScenarioContext() {

        return scenarioContext;

    }
 
}