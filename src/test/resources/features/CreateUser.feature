Feature: Validate create new user
  Scenario: verify new user can be created
    Given user wants to call "/user" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "create_user.json"
    And  user perform post call
    Then verify status code is 200