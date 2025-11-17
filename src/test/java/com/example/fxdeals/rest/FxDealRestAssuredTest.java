package com.example.fxdeals.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FxDealRestAssuredTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void testImportDealSuccess() {
        given()
                .contentType("application/json")
                .body("""
                    {
                        "dealId": "REST200",
                        "fromCurrency": "USD",
                        "toCurrency": "EUR",
                        "timestamp": "2024-02-02T12:00:00",
                        "amount": 2000
                    }
                  """)
                .when()
                .post("/api/deals")
                .then()
                .statusCode(201)
                .body("dealId", equalTo("REST200"));
    }

    @Test
    void testImportDealInvalidCurrency() {
        given()
                .contentType("application/json")
                .body("""
                    {
                        "dealId": "ERR001",
                        "fromCurrency": "INVALID",
                        "toCurrency": "EUR",
                        "timestamp": "2024-02-02T12:00:00",
                        "amount": 2000
                    }
                  """)
                .when()
                .post("/api/deals")
                .then()
                .statusCode(400);
    }
}
