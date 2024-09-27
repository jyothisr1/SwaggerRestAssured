Feature: Validate get end point by name
  Scenario: verify user data can be retrieved by name
    Given user wants to call "/user/@name" end point
    And set header "Content-Type" to "application/json"
    And  user perform get call
    Then verify status code is 200