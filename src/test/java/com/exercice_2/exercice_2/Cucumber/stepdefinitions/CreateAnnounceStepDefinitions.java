package com.exercice_2.exercice_2.Cucumber.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CreateAnnounceStepDefinitions {

  @Autowired
  private RestTemplate restTemplate;

  private HttpEntity<String> requestEntity;
  private ResponseEntity<?> response;

  @Given("the request body is:")
  public void setRequestBody(String requestBody) {
    requestEntity = new HttpEntity<>(requestBody);
  }

  @When("the client sends a POST request to {string}")
  public void sendPostRequest(String url) {
    response = restTemplate.postForEntity(url, requestEntity, Object.class);
  }

  @Then("the response status code should be {string}")
  public void verifyStatusCode(String expectedStatusCode) {
    HttpStatus expectedStatus = HttpStatus.valueOf(expectedStatusCode);
    assertEquals(expectedStatus, response.getStatusCode());
  }
}
