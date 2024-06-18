package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("sometag")
class GreetingResourceConfigTest {
    @Test
    void shouldReturnGreeting() {
        given()
          .when().get("/hello/config")
          .then()
             .statusCode(200)
             .body(is("Hello from greeting resource"));
    }

}