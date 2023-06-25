package com.exercice_2.exercice_2.Cucumber.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@CucumberContextConfiguration
public class CreateAnnounceStepDefinitions {

  @Autowired
  private TestRestTemplate restTemplate;

  private HttpEntity<String> requestEntity;
  private ResponseEntity<?> response;

  @Given("the request body is:")
  public void setRequestBody(String requestBody) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    requestEntity = new HttpEntity<>(requestBody, headers);
  }

  @When("the client sends a POST request to {string}")
  public void sendPostRequest(String url) {
    response = restTemplate.postForEntity(url, requestEntity, Object.class);
  }

  @Then("the response status code should be {string}")
  public void verifyStatusCode(String expectedStatusCode) {
    assertEquals(
      expectedStatusCode.toString(),
      response.getStatusCode().toString()
    );
  }
}
