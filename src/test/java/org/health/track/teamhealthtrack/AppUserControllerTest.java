package org.health.track.teamhealthtrack;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

class AppUserControllerTest extends BaseTestConfig {

  private final String LOCAL_HOST = "http://localhost:";

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;


/*  @Test
  void getUsers() throws Exception {
    String json = this.restTemplate.getForObject(LOCAL_HOST + port + "/users", String.class);
    Assertions.assertEquals(json,"sada");

  }*/
}