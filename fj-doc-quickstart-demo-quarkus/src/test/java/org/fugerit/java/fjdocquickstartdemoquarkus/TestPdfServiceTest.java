package org.fugerit.java.fjdocquickstartdemoquarkus;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestPdfServiceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/pdftest")
          .then()
             .statusCode(200);
    }

}