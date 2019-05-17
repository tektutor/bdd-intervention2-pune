package org.tektutor;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {

    private RequestSpecification request;
    private Response response;
    private int actualResponseCode, expectedResponseCode;

    @Given("I the rest api is hosted at {string}")
    public void i_the_rest_api_is_hosted_at(String url) {
        RestAssured.baseURI = url;
		request = RestAssured.given();
    }
    
    @When("I invoke the hotel booking REST API with GET method")
    public void i_invoke_the_hotel_booking_REST_API_with_GET_method() {
		request.header( "Content-Type", "application/json" );
		response = request.get();
    }

    @Then("I expect response code {string}")
    public void check_the_response_code(String strExpectedResponseCode) {
        actualResponseCode = response.getStatusCode();
        expectedResponseCode = Integer.parseInt(strExpectedResponseCode);

        assertEquals ( expectedResponseCode, actualResponseCode );
    }

    @Then("I expect {string} booking records as response")
    public void check_if_the_record_count_matches( String strExpectedRecordCount ) {

        Booking[] listOfBookings = response.as(Booking[].class);

        int actualRecordCount = listOfBookings.length;
        int expectedRecordCount = Integer.parseInt(strExpectedRecordCount);

        assertEquals(expectedRecordCount, actualRecordCount);

    }

}