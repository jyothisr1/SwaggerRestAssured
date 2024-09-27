package com.automation.steps;

import com.automation.pojo.CreateUserPojo;
import com.automation.pojo.UpdateUserPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Random;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        if (endPoint.contains("@name")) {
            String name = ConfigReader.getConfigValue("username");
            endPoint = endPoint.replace("@name", name);
        }
        RestAssuredUtils.setEndPoint(endPoint);

    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        if (value.contains("@token")) {
            value = value.replace("@token", ConfigReader.getConfigValue("api.token"));
        }
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set request body from the file {string}")
    public void setRequestBodyFromTheFile(String fileName) throws JsonProcessingException {
        String jsonFolderPath=ConfigReader.getConfigValue("json.folder.path");
        String jsonBody=RestAssuredUtils.getDataFromFile(jsonFolderPath+fileName);
        ObjectMapper om=new ObjectMapper();
        if(fileName.contains("update")){
            UpdateUserPojo updateUserPojo=om.readValue(jsonBody, UpdateUserPojo.class);
            RestAssuredUtils.setBody(updateUserPojo);
        }
        else {
            CreateUserPojo createUserPojo=om.readValue(jsonBody, CreateUserPojo.class);
            RestAssuredUtils.setBody(createUserPojo);
        }
    }

    @When("user perform post call")
    public void user_perform_post_call() {
        RestAssuredUtils.post();

    }

    @When("user perform get call")
    public void userPerformGetCall() {
        RestAssuredUtils.get();
    }

    @And("user perform put call")
    public void userPerformPutCall() {
        RestAssuredUtils.put();
    }

    @And("user perform delete call")
    public void userPerformDeleteCall() {
        RestAssuredUtils.delete();
    }
}
