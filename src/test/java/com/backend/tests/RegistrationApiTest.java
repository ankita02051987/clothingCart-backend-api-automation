
package com.backend.tests;

        import io.restassured.RestAssured;
        import io.restassured.response.Response;
        import org.testng.annotations.Test;

        import static org.testng.Assert.assertEquals;

public class RegistrationApiTest {

    @Test
    public void testUserRegistration() {
        // Base URI
        RestAssured.baseURI = "http://localhost:8081";

        // JSON Payload
        String payload = "{\n" +
                "  \"email\": \"bhumigoti4@gmail.com\",\n" +
                "  \"firstName\": \"Bhumika\",\n" +
                "  \"lastName\": \"Vaghasiya\",\n" +
                "  \"password\": \"bhumikA@123\"\n" +
                "}";

        // Send POST request to /api/users/register
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/users/register");

        // Print response body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        // Assert status code is 201 (Created)
        assertEquals(response.statusCode(), 201, "Expected status code 201");
    }
}
