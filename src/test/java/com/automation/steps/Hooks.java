package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void setUp(){

        ConfigReader.initConfig();
        RestAssured.baseURI="https://petstore.swagger.io/v2";
    }
    @After
    public void cleanUp(){

    }
}
