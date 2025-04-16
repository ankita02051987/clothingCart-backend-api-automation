
package com.backend.tests;

        import io.restassured.RestAssured;
        import io.restassured.response.Response;
        import org.testng.annotations.Test;

        import static org.testng.Assert.assertEquals;
        import static org.testng.Assert.assertTrue;

public class LoginApiTest {

    @Test
    public void testUserLogin() {
        // Base URI
        RestAssured.baseURI = "http://localhost:8081";

        // Login payload
        String payload = "{\n" +
                "  \"email\": \"bhumigoti4@gmail.com\",\n" +
                "  \"password\": \"bhumikA@123\"\n" +
                "}";

        // Send POST request to login endpoint
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/users/login");

        // Print response
        System.out.println("Login Response:");
        System.out.println(response.getBody().asString());

        // Check for successful status code (usually 200)
        assertEquals(response.statusCode(), 200, "Expected status code 200");

        // Optionally, check for some keyword in response
        assertTrue(response.getBody().asString().toLowerCase().contains("success"), "Response should indicate success");
    }
}
