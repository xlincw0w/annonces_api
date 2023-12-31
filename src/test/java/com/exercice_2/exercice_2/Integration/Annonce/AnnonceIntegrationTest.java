package com.exercice_2.exercice_2.Integration.Annonce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AnnonceIntegrationTest {

  @Value(value = "${local.server.port}")
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void itShouldFetchAnnonces() {
    // WHEN
    ResponseEntity<?> response =
      this.restTemplate.getForEntity(
          "http://localhost:" + port + "/api/annonce",
          String.class
        );

    // THEN
    assertEquals("200 OK", response.getStatusCode().toString());
    assertEquals(true, response.getBody().toString().contains("payload"));
  }

  @Test
  public void itShouldCreateAnAnnouce() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String requestBody =
      "{\"title\":\"test\",\"description\":\"test\",\"price\":100,\"type\":\"VEHICULE\"}";
    HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

    // WHEN

    ResponseEntity<?> response =
      this.restTemplate.postForEntity(
          "http://localhost:" + port + "/api/annonce",
          requestEntity,
          Object.class
        );

    // THEN
    assertEquals("201 CREATED", response.getStatusCode().toString());
  }
}
