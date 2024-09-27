Feature: Validate update and delete user

  Scenario: Verify user data can be updated
    Given user wants to call "/user/@name" end point
    And set header "Content-Type" to "application/json"
    And set request body from the file "update_user.json"
    When user perform put call
    Then verify status code is 200

  Scenario: verify user data can be deleted
    Given user wants to call "/user/@name" end point
    And set header "Content-Type" to "application/json"
    And  user perform delete call
    Then verify status code is 200

