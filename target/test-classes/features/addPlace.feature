Feature: Place API Testing

  Scenario: Validate create and get place API

    Given Add Place payload
    When User calls "AddPlaceAPI" with POST request
    Then API call is successful with status code 200
    And "status" in response body is "OK"
    And extract place_id from response

   Given Get Place payload using place_id
    When User calls "GetPlaceAPI" with GET request
   Then API call is successful with status code 200
   And "name" in response body is "Rahul Shetty Academy"