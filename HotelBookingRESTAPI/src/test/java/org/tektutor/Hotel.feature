Feature: Develop a Hotel Booking REST API

    Scenario: Should be able to retrieve all hotel room booking done as on today
     Given I the rest api is hosted at "http://localhost:8080/tektutor-hotelcrud-rest-1.0.0/rest/bookings/all"
      When I invoke the hotel booking REST API with GET method 
      Then I expect response code "200"
      And I expect "5" booking records as response